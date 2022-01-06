package exercises

import jdk.internal.org.objectweb.asm.util.Printer

object PatternMatching extends App {

  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(e: Expr): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Prod(e1, e2) => {
      def maybeParenthesis(expr: Expr) = expr match {
        case Prod(_, _) => show(expr)
        case Number(_) => show(expr)
        case _ => "(" + show(expr) + ")"
      }

      maybeParenthesis(e1) + " * " + maybeParenthesis(e2)
    }
  }

  println(show(Sum(Number(2), Number(3)))) // 2 + 3
  println(show(Sum(Sum(Number(2), Number(3)), Number(4)))) // 2 + 3 + 4
  println(show(Prod(Sum(Number(2), Number(1)), Number(3)))) // (2 + 1) * 3
  println(show(Prod(Sum(Number(1), Number(2)), Sum(Number(3), Number(4))))) // (1 + 2) * (3 + 4)
  println(show(Sum(Prod(Number(2), Number(1)), Number(3)))) // 2 * 1 + 3
}
