package get_requests;

import base_Urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import test_data.JsonPlaceHolderTestData;
import utils.JsonUtil;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;
import static utils.JsonUtil.convertJsonToJavaObject;

public class Get14ObjectMapper extends JsonPlaceHolderBaseUrl {

/*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test
    public void get01ObjectMapper() {
        //1.step: set the url
        spec.pathParams("first", "todos", "second", 198);

        String exdat="{\n" +
                "\"userId\": 10,\n" +
                "\"title\": \"quis eius est sint explicabo\",\n" +
                "\"completed\": true\n" +
                "}";


        //2.step:set the expected data
        JsonPlaceHolderTestData jsonPlaceHolderTestData=new JsonPlaceHolderTestData();
        String expectedData = jsonPlaceHolderTestData.jsonPlaceHolderjsonToString(10,"quis eius est sint explicabo",true);
        HashMap<String, Object> expectedDataMap = JsonUtil.convertJsonToJavaObject(expectedData, HashMap.class);

        //3.step: send the Get request and get the response

      Response response = given().spec(spec).when().get("/{first}/{second}");
response.prettyPrint();
      //4.step: Do assertion

      HashMap<String,Object> actualdataMap =  JsonUtil.convertJsonToJavaObject(response.asString(),HashMap.class);
        System.out.println("actualdataMap = " + actualdataMap);
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedDataMap.get("userId"),actualdataMap.get("userId"));
        assertEquals(expectedDataMap.get("title"),actualdataMap.get("title"));
        assertEquals(expectedDataMap.get("completed"),actualdataMap.get("completed"));


    }

    @Test
    public void get02ObjectMapper() {
        //1.step: set the url
        spec.pathParams("first", "todos", "second", 198);


        //2.step:set the expected data
        String expectedData = "{\n" +
                "   \"userId\": 10,\n" +
                "   \"id\": 198,\n" +
                "   \"title\": \"quis eius est sint explicabo\",\n" +
                "   \"completed\": true\n" +
                " }";
        JsonPlaceHolderPojo expectedDataPojo = JsonUtil.convertJsonToJavaObject(expectedData, JsonPlaceHolderPojo.class);

        //3.step: send the Get request and get the response

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        JsonPlaceHolderPojo actualDataPojo= JsonUtil.convertJsonToJavaObject(response.asString(),JsonPlaceHolderPojo.class);

        //4.step: Do assertion
        assertEquals(200,response.getStatusCode());
        assertEquals(expectedDataPojo.getUserId(),actualDataPojo.getUserId());
        assertEquals(expectedDataPojo.getTitle(),actualDataPojo.getTitle());
        assertEquals(expectedDataPojo.getCompleted(),actualDataPojo.getCompleted());


    }
}
