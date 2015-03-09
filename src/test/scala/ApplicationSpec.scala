import com.dmiszkiewicz.{Repository, MyJsonProtocol, Temperature, MyController}
import MyJsonProtocol._
import org.specs2._
import specification._
import play.api.test._
import play.api.test.Helpers._
import spray.json._


class ApplicationSpec extends script.Specification with Groups {
  def is = """
  This is a specification for REST API

  # GET /temperature/<city>

  Endpoint /temperature/<city> for request GET should return:
    + code 404 if there isn't such <city> in database
    + code 200 and temperature in JSON format if there is such <city> in database
           """

  "GET /temperature/<city>" - new group with MockController {
    eg := {
      //Given
      val city = "Zakopane"
      //When
      val temp = controller.getTemperature(city)(FakeRequest())
      //Then
      status(temp) must equalTo(NOT_FOUND)
    }
    eg := {
      //Given
      val city = "Warsaw"
      //When
      val result = controller.getTemperature(city)(FakeRequest())
      //Then
      (status(result) must equalTo(OK)) and
        (contentAsString(result).parseJson.convertTo[Temperature] mustEqual Temperature(0)) and
        (contentType(result) mustEqual Some("application/json"))
    }
  }

  trait MockController extends Scope {
    val controller = {
      val repository = new Repository {
        val map = Map(("Warsaw" -> Temperature(0)), ("Cracow" -> Temperature(-3.0)))

        override def getTemperature(city: String): Option[Temperature] = {
          map.get(city)
        }
      }
      new MyController(repository)
    }
  }

}