package get_requests;

import base_Urls.JsonPlaceHolderBaseUrl;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get07 extends JsonPlaceHolderBaseUrl {

    /*
        Given
	   	    https://jsonplaceholder.typicode.com/todos
		When
			 I send GET Request to the URL
		Then
			 1)Status code is 200
			 2)Print all ids greater than 190 on the console
			   Assert that there are 10 ids greater than 190
			 3)Print all userIds whose ids are less than 5 on the console
			   Assert that the number of userIds whose ids are less than 5 is 4
			 4)Print all titles whose ids are less than 5
			   Assert that "delectus aut autem" is one of the titles whose id is less than 5
     */

    @Test
    public void get01() {

        //1.Set the Url
        spec.pathParam("first", "todos");
        //2.Set the expeted data
        //3.Send the request and get the response
        Response response = given().spec(spec).get("{first}");
        //response.prettyPrint();
        //4.Do assertion

        //a-Status code is 200
        response.then().assertThat().statusCode(200);

        //b-Print all ids greater than 190 on the console
        //Assert that there are 10 ids greater than 190
        JsonPath jsonPath = response.jsonPath();
        List<Integer> ids = jsonPath.getList("findAll{it.id>190}.id");
        System.out.println(ids);
        assertEquals(10, ids.size());

        //c-Print all userIds whose ids are less than 5 on the console
        //Assert that the number of userIds whose ids are less than 5 is 4

        List<Integer> ids2 = jsonPath.getList("findAll{it.id<5}.userId");
        System.out.println(ids2);
        assertEquals(4, ids2.size());

        //d-Print all titles whose ids are less than 5
        //Assert that "delectus aut autem" is one of the titles whose id is less than 5

        List<String> ids3 = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println(ids3);
        assertTrue(ids3.contains("delectus aut autem"));



    }
}
