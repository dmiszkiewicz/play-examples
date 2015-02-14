import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._

import play.api.test._
import play.api.test.Helpers._
import spray.json._
import controllers._
import controllers.MyJsonProtocol._


import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.mockito.Mockito._
import org.mockito.Matchers._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification with Mockito {

  "Application" should {

    "send 404 on a bad request" in new WithApplication {
      route(FakeRequest(GET, "/boum")) must beNone
    }

    "render the index page" in new WithApplication {
      val home = route(FakeRequest(GET, "/")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain("Your new application is ready.")
    }

    "return black color" in new WithApplication {
      val result = route(FakeRequest(GET, "/black")).get

      status(result) must equalTo(OK)
      contentType(result) must beSome.which(_ == "application/json")
      contentAsString(result).parseJson.convertTo[Color] must_== (Color("black", 0, 0, 0))
    }

    "return white color from black endpoint using mockito" in new WithApplication {
      val colorProvider = mock[ColorProvider]
      when(colorProvider.black()).thenReturn(Color("white", 255, 255, 255))
      val result = new Application(colorProvider).getBlackColor(FakeRequest())
      status(result) must equalTo(OK)
      contentType(result) must beSome.which(_ == "application/json")
      contentAsString(result).parseJson.convertTo[Color] must_== (Color("white", 255, 255, 255))
    }
  }
}
