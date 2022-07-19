package get_requests;

import base_Urls.GorestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GoRestDataPojo;
import pojos.GoRestResponseBodyPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get13Pojo extends GorestBaseUrl {
    /*
    Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
          {
    "meta": null,
    "data": {
        "id": 2508,
        "name": "Akshita Nehru",
        "email": "nehru_akshita@jast.info",
        "gender": "female",
        "status": "active"
    }
}
            }

     */

    @Test
    public void get01Pojo() {

        //1.step:Set the url

        spec.pathParams("first", "users", "second", 2508);

        //2.step:set the expected data

        GoRestDataPojo goRestDataPojo = new GoRestDataPojo(2508, "Akshita Nehru", "nehru_akshita@jast.info", "female", "active");
        GoRestResponseBodyPojo goRestResponseBodyPojo = new GoRestResponseBodyPojo(null, goRestDataPojo);

        //3.step:Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4.step:Do Assertion
        GoRestResponseBodyPojo actualPojo= response.as(GoRestResponseBodyPojo.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(goRestResponseBodyPojo.getMeta(),actualPojo.getMeta());
        assertEquals(goRestDataPojo.getId(),actualPojo.getData().getId());
        assertEquals(goRestDataPojo.getName(),actualPojo.getData().getName());
        assertEquals(goRestDataPojo.getEmail(),actualPojo.getData().getEmail());
        assertEquals(goRestDataPojo.getGender(),actualPojo.getData().getGender());
        assertEquals(goRestDataPojo.getStatus(),actualPojo.getData().getStatus());

    }
}
