package delete_requests;

import base_Urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Delete01 extends JsonPlaceHolderBaseUrl {

    /*
    Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }


     */

    @Test
    public void delete01(){
        //1-set the url

        spec.pathParams("first","todos","second",198);

        //2-set the expected data
        Map<String,Object> expectedData=new HashMap<>();
        //3-send delete request and get the response

       Response response= given().spec(spec).when().delete("/{first}/{second}");
       response.prettyPrint();
       //4-Do assertion
        response.then().assertThat().statusCode(200);
       Map<String,Object> actualData=response.as(HashMap.class);
       assertEquals(expectedData,actualData);
    }
}
