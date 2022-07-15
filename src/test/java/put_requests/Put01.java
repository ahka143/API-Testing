package put_requests;

import base_Urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Put01 extends JsonPlaceHolderBaseUrl {
    /*
        Given
	        1) https://jsonplaceholder.typicode.com/todos/198
	        2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
	 		I send PUT Request to the Url
	    Then
	   	   Status code is 200
	   	   And response body is like   {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									   }
     */

    @Test
    public void put01() {
        //1.set the url
        spec.pathParams("first","todos","second",198);
        //2.set the expected data
        JsonPlaceHolderTestData expecteData= new JsonPlaceHolderTestData();
      Map<String ,Object> expecteDataMap= expecteData.expectedDataWithAllKeys(21, "Wash the dishes",false);
        //3.send the put request get the response
    Response response= given().spec(spec).contentType(ContentType.JSON).body(expecteDataMap).when().put("/{first}/{second}");
        response.prettyPrint();

        //4. Do assertion

       Map<String,Object> actualDataMAp= response.as(HashMap.class);
       assertEquals(expecteDataMap.get("userId"),actualDataMAp.get("userId"));
       assertEquals(expecteDataMap.get("title"),actualDataMAp.get("title"));
       assertEquals(200,response.getStatusCode());


    }
}
