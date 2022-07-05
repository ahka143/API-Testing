import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.*;

public class Deneme01 {

    @Test
    public void test01() {
          /*
    Given
            https://restful-booker.herokuapp.com/booking/3
        When
            User sends a GET Request to the url
        Then
            HTTP Status Code should be 200
        And
            Content Type should be JSON
        And
            Status Line should be HTTP/1.1 200 OK
     */


        //1) Set the URL (URl'yi kurmak)
        String url ="https://restful-booker.herokuapp.com/booking/555";

        // 2) Set the expected Data (beklenen datanın oluşturulması)   """POST, PUT PATCH"""
        // 3) Type code to send request (talep göndermek için kod yazma)
        Response response = given().get(url);

        // 4) Do Assertion (doğrulama yapma)
        response.then().assertThat().statusCode(200).contentType("application/json;").statusLine("HTTP/1.1 200 OK");
        Assert.assertEquals(200,response.statusCode());

    }
}
