package get_requests;

import base_Urls.AutomationPractiseBaseUrl;
import com.google.gson.JsonObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class GetDeneme extends AutomationPractiseBaseUrl {

    @Test
    public void get01() {
        //1.Set the url
        spec.pathParam("first","productsList");

        //2.set the expected data

        //3.send the request and get the response
        Response response = given().spec(spec).accept("application/json").contentType(ContentType.JSON).when().get("/{first}");
        response.prettyPrint();
        //4. do assertion
      //  response.then().assertThat().statusCode(200).contentType(ContentType.JSON);



    }
}
