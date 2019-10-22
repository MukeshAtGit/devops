package app


import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.HttpRequest
import akka.stream.ActorMaterializer
import controller.Controller

import scala.concurrent.{ ExecutionContextExecutor, Future }
import scala.util.{ Failure, Success }

  object DevOps extends App {
    implicit val system: ActorSystem = ActorSystem("DataLateActorSystem")
    implicit val executionContext: ExecutionContextExecutor = system.dispatcher
    implicit val materialize: ActorMaterializer =ActorMaterializer()
    private val routes = new Controller
    private val serverBinding: Future[Http.ServerBinding] =
      Http().bindAndHandle(routes.routes,"localhost",8000 )
    val listName=List[String]("mukesh","sachin","munna","anuj")

    serverBinding.onComplete {
      case Success(bound) =>
        println(
          s"Server online at http://${ bound.localAddress.getHostName }:${ bound.localAddress.getPort }/")
        listName.foreach{ name =>
          val url = s"http://${ bound.localAddress.getHostName }:${ bound.localAddress.getPort }/name/$name"
          Http().singleRequest(HttpRequest(uri = url))
          Thread.sleep(5000)
        }
        Http()(system)
          .shutdownAllConnectionPools()
        system.terminate()
      case Failure(error) =>
        Http()(system)
          .shutdownAllConnectionPools()
          .andThen {
            case _ =>
              println("failed" + error)
              system.terminate()
          }
    }

  }
