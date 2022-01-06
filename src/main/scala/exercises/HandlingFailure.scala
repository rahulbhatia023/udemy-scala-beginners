package exercises

import scala.util.{Random, Try}

object HandlingFailure extends App {
  val host = "localhost"
  val port = "80"

  def renderHTML(page: String): Unit = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())

      if (random.nextBoolean()) "<html>....</html>"
      else throw new RuntimeException("Connection Interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection = {
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")
    }

    def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))
  }

  val possibleConnection: Try[Connection] = HttpService.getSafeConnection(host, port)
  val possibleHTML: Try[String] = possibleConnection.flatMap(connection => connection.getSafe("/home"))

  println(possibleHTML.isSuccess)

  possibleHTML.foreach(renderHTML)

  /**
   * Chained Version
   */
  HttpService.getSafeConnection(host, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(println)

  /**
   * For-Comprehension
   */
  for {
    connection <- HttpService.getSafeConnection(host, port)
    html <- connection.getSafe("/home")
  } renderHTML(html)
}
