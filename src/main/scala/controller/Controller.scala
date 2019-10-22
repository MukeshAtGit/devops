package controller

import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

class Controller {

  val routes: Route =
    get {
      pathPrefix("name" / Segment) { name =>
       println("hello "+ name)
        complete(
          "My example DevOps route"
        )
      }
    }
}
