package get_requests;

import base_Urls.GorestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GoRestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get10 extends GorestBaseUrl {
/*
        Given
            https://gorest.co.in/public/v1/users/2986
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
       {
    "meta": null,
    "data": {
        "id": 2965,
        "name": "Mr. Gita Menon",
        "email": "gita_menon_mr@bayer.com",
        "gender": "female",
        "status": "inactive"
    }
}
     */

    @Test
    public void get01() {
        //1.Set the Url
        spec.pathParams("first","users","second",2965);
        //2.set the expected data
        GoRestTestData dataKey=new GoRestTestData();

       Map<String,String> dataKeyMap= dataKey.dataKeyMap("Mr. Gita Menon","gita_menon_mr@bayer.com","female","inactive");

      Map<String,Object> expectedData =  dataKey.expectedDataMap(null,dataKeyMap);


        //3.send the request and get the response

       Response response = given().spec(spec).when().get("/{first}/{second}");
      Map<String,Object> actualData=response.as(HashMap.class);

       //4.Do assertion

        assertEquals(expectedData.get("meta"),actualData.get("meta"));
        assertEquals(dataKeyMap.get("name"),((Map)actualData.get("data")).get("name"));
        assertEquals(dataKeyMap.get("email"),((Map)actualData.get("data")).get("email"));
        assertEquals(dataKeyMap.get("gender"),((Map)actualData.get("data")).get("gender"));
        assertEquals(dataKeyMap.get("status"),((Map)actualData.get("data")).get("status"));
        assertEquals(200,response.getStatusCode());





    }
}
