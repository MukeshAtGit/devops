package app

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
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
    serverBinding.onComplete {
      case Success(bound) =>
        println(
          s"Server online at http://${ bound.localAddress.getHostName }:${ bound.localAddress.getPort }/")

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
