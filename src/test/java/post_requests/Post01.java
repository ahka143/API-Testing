package post_requests;

import base_Urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Post01 extends JsonPlaceHolderBaseUrl {

    /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2)  {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
              }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */

    @Test
    public void post01() {
        //1.set the url

        spec.pathParam("first", "todos");

        //2.Set the expected data

        JsonPlaceHolderTestData expectedData = new JsonPlaceHolderTestData();
        Map<String, Object> expectedDatamap = expectedData.expectedDataWithAllKeys(55, "Tidy your room", false);
        //3.Send the post request and get the response
      Response response= given().spec(spec).contentType(ContentType.JSON).body(expectedDatamap).when().post("/{first}");
      response.prettyPrint();

      //4.do assertion

        Map<String,Object> actualData=response.as(HashMap.class);
        assertEquals(expectedDatamap.get("userId"),actualData.get("userId"));
        assertEquals(expectedDatamap.get("title"),actualData.get("title"));
        assertEquals(expectedDatamap.get("completed"),actualData.get("completed"));

    }
}
