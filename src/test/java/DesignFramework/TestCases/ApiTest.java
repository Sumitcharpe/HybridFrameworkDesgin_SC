package DesignFramework.TestCases;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import DesginFramework.TestComponent.Baseclass;
import org.testng.annotations.Test;

public class ApiTest extends Baseclass {

  @Test
    public void createObjectApiTest() {
    given().baseUri("https://api.restful-api.dev")
           .header("Content-Type", "application/json")
           .body("{\"name\": \"Apple iPad Air\", \"data\": { \"Generation\": \"4th\", \"Price\": \"519.99\", \"Capacity\": \"256 GB\" }}")
           .post("/objects")
           .then().log().all()
           .statusCode(200);
  }
}

