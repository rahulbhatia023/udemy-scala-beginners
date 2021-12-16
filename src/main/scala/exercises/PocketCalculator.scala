package exercises

object PocketCalculator extends App {

  def add(x: Int, y: Int): Int = {
    val result = x + y
    if (x > 0 && y > 0 && result < 0) throw new OverflowException
    else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
    else result
  }

  def subtract(x: Int, y: Int): Int = {
    val result = x - y
    if (x > 0 && y < 0 && result < 0) throw new OverflowException
    else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
    else result
  }

  def multiply(x: Int, y: Int): Int = {
    val result = x * y
    if (x > 0 && y > 0 && result < 0) throw new OverflowException
    else if (x < 0 && y < 0 && result < 0) throw new OverflowException
    else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
    else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
    else result
  }

  def divide(x: Int, y: Int): Int = {
    if (y == 0) throw new MathCalculationException
    else x / y
  }

  // OverflowException
  // println(add(Int.MaxValue, 10))

  // MathCalculationException
  // println(divide(2,0))
}

class OverflowException extends Exception

class UnderflowException extends Exception

class MathCalculationException extends Exception