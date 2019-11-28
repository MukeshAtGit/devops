
import akka.http.scaladsl.model._
import akka.http.scaladsl.testkit.ScalatestRouteTest
import controller.Controller
import org.scalatest.{ Matchers, WordSpecLike }

class ControllerSpec extends WordSpecLike with Matchers with ScalatestRouteTest {

  "CrawlerRoute" should {
    "be able to welcome user" in {

      val getRequest = HttpRequest(uri = "/name/mukesh")

      getRequest ~> (new Controller).routes ~> check {
        status === StatusCodes.OK
        contentType === ContentTypes.`text/plain(UTF-8)`
        entityAs[String] contains "My example DevOps route"
      }
    }
  }
}
