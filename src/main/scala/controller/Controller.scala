package controller

import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import app.DevOps.system

class Controller {

  val routes: Route =
    get {
      pathPrefix("name" / Segment) { name =>
       println("hello "+ name)
        complete(
          s"My example DevOps route $name"
        )
      }
    } ~ get{
      pathPrefix("exit" ) {
        println("bye bye")
        Http()(system)
          .shutdownAllConnectionPools()
        system.terminate()
        complete(
          "bye bye"
        )
      }

    }
}
