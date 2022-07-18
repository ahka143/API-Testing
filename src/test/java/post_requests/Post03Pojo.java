package post_requests;

import base_Urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Post03Pojo extends JsonPlaceHolderBaseUrl {
/*
         Given
            https://jsonplaceholder.typicode.com/todos
            {
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
    public void postPojo01() {
        //1-set the url
        spec.pathParam("first", "todos");

        //2=set the expected data
        JsonPlaceHolderPojo requestBody = new JsonPlaceHolderPojo(55, "Tidy your room", false);

        //3-send post request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(requestBody).when().post("/{first}");
        response.prettyPrint();
        //4-Do assertion
        JsonPlaceHolderPojo actualBody = response.as(JsonPlaceHolderPojo.class);
        //  assertEquals(requestBody.getUserId(), actualBody.getUserId());
        //  assertEquals(requestBody.getTitle(), actualBody.getTitle());
        //  assertEquals(requestBody.getCompleted(), actualBody.getCompleted());

        assertEquals(requestBody.toString(), actualBody.toString());
    }
}
