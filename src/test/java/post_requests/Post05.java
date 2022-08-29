package post_requests;

import base_Urls.DummyBasuUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDataPojo;
import pojos.DummyResponsePojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Post05 extends DummyBasuUrl {
/*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body: {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
    "status": "success",
    "data": {
        "employee_name": "Tom Hanks",
        "employee_salary": 111111,
        "employee_age": 23,
        "profile_image": "Perfect image",
        "id": 7924
    },
    "message": "Successfully! Record has been added."
}
     */

    /*
    Given
         URL: https://dummy.restapiexample.com/api/v1/create
    When
        User send the Post Request
        Request body: {
                        "employee_name": "Tom Hanks",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
     Then
           Status code is 200
     And
                          {
    "status": "success",
    "data": {
        "employee_name": "Tom Hanks",
        "employee_salary": 111111,
        "employee_age": 23,
        "profile_image": "Perfect image",
        "id": 7924
    },
    "message": "Successfully! Record has been added."
}
     */

    @Test
    public void post01() {
        spec.pathParam("first", "create");
        DummyDataPojo dataPojo = new DummyDataPojo("Tom Hanks", 111111, 23, "Perfect image");
        DummyResponsePojo expectedDataPojo = new DummyResponsePojo("success", dataPojo, "Successfully! Record has been added.");
        Response response = given().spec(spec).contentType(ContentType.JSON).body(dataPojo).post("/{first}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
     DummyResponsePojo actualPojo  = JsonUtil.convertJsonToJavaObject(response.asString(),DummyResponsePojo.class);
        assertEquals(expectedDataPojo.getMessage(),actualPojo.getMessage());
        assertEquals(expectedDataPojo.getStatus(),actualPojo.getStatus());
        assertEquals(expectedDataPojo.getData().getEmployee_name(),actualPojo.getData().getEmployee_name());
        assertEquals(expectedDataPojo.getData().getEmployee_salary(),actualPojo.getData().getEmployee_salary());
        assertEquals(expectedDataPojo.getData().getEmployee_age(),actualPojo.getData().getEmployee_age());
        assertEquals(expectedDataPojo.getData().getProfile_image(),actualPojo.getData().getProfile_image());

    }
}
