import io.restassured.response.Response;

import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;


public class Get02 {
    @Test
    public void get02() {
        /*
        Given
            https://restful-booker.herokuapp.com/booking/1001
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Response body contains "Not Found"
        And
            Response body does not contain "TechProEd"
        And
            Server is "Cowboy"
     */

        // 1) Set the URL (URl'yi kurmak)

        String url = "https://restful-booker.herokuapp.com/booking/1005";
        // 2) Set the expected Data (beklenen datanın oluşturulması)   """POST, PUT PATCH"""
        // 3) Type code to send request (talep göndermek için kod yazma)
        Response response = given().get(url);
        response.prettyPrint();
        // 4) Do Assertion (doğrulama yapma)
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
        assertTrue(response.asString().contains("Not Found"));
        assertFalse(response.asString().contains("TechProEd"));
        assertEquals("Cowboy",response.header("Server"));

    }
}
