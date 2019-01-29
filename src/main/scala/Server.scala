import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContext

object Server extends App {

  override def main(args: Array[String]) {
    val host = "0.0.0.0"
    val port = 9000
    implicit val system: ActorSystem = ActorSystem("helloworld")
    implicit val executor: ExecutionContext = system.dispatcher
    implicit val materializer: ActorMaterializer = ActorMaterializer()

    Http().bindAndHandle(route, host, port)
  }

  def route = path("hello") {
    get {
      complete("Hello, World!")
    }
  }
}