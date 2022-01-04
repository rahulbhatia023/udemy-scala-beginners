package exercises

import scala.util.Random

object Options extends App {
  val config: Map[String, String] = Map(
    "host" -> "0.0.0.0",
    "port" -> "80"
  )

  class Connection {
    def connect() = "Connected"
  }

  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] = {
      if (random.nextBoolean()) Some(new Connection())
      else None
    }
  }

  val host = config.get("host")
  val port = config.get("port")

  /*
    if(host != null)
      if(port != null)
        return Connection.apply(host, port)

    return null
  */
  val connection: Option[Connection] = host.flatMap(h => port.flatMap(p => Connection(h, p)))

  /*
    if(connection != null)
      return connection.connect()

    return null
  */
  val connectionStatus: Option[String] = connection.map(c => c.connect())

  /*
    if(connectionStatus == null)
      println(None)
    else
      println(Some(connectionStatus.get))
  */
  println(connectionStatus)
  connectionStatus.foreach(println)

  /**
   * Putting all steps together
   */
  config.get("host")
    .flatMap(host => config.get("port")
      .flatMap(port => Connection(host, port)))
    .map(connection => connection.connect())
    .foreach(println)

  /**
   * Use for-comprehension
   */
  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection(host, port)
  } yield {
    connection.connect()
  }
  forConnectionStatus.foreach(println)
}
