package delete_requests;

import base_Urls.DummyBasuUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Delete02 extends DummyBasuUrl {

    /*
    URL: https://dummy.restapiexample.com/api/v1/delete/2
   HTTP Request Method: DELETE Request
   Test Case: Type by using Gherkin Language
   Assert:     i) Status code is 200
           ii) "status" is "success"
          iii) "data" is "2"
           iv) "message" is "Successfully! Record has been deleted"
 */

    /*
    Given
        URL: https://dummy.restapiexample.com/api/v1/delete/2
    When
        User send the DELETE request
    Then
        Status code is 200
    And
        "data" is "2"
    And
       "message" is "Successfully! Record has been deleted"

     */

    @Test
    public void delete01() {
        spec.pathParams("first","delete","second",2);
    Response response =   given().spec(spec).when().delete("/{first}/{second}");
    response.prettyPrint();
    response.
            then().
            assertThat().
            statusCode(200).
            body("status",equalTo("success"),
            "data",equalTo("2"),
            "message",equalTo("Successfully! Record has been deleted"));



    }
}
