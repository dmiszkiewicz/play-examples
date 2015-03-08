import org.specs2._
import specification._

class ApplicationSpec extends script.Specification with Groups {
  def is = """
  This is a specification for REST API

  # GET /temperature/<city>

  Endpoint /temperature/<city> for request GET should return:
    + code 404 if there isn't such <city> in database
    + code 200 and temperature in JSON format if there is such <city> in database
           """
}