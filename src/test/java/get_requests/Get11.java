package get_requests;

import base_Urls.GorestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Get11 extends GorestBaseUrl {

    /*
    Given
            https://gorest.co.in/public/v1/users
        When
            User send GET Request
        Then
            The value of "pagination limit" is 20
        And
            The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        And
            The number of users should  be 10
        And
            We have at least one "active" status
        And
           "Agastya Somayaji", "Acharyasuta Chattopadhyay DC", "Shresth Nehru" are among the users
        And
            The female users are more  than male users or equals
     */

    @Test
    public void get01() {
        //1.set the url

        spec.pathParam("first", "users");

        //2.set the expected data

        //3.send the request and get the response

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //4.Do assertion

        response.
                then().
                assertThat().
                body("meta.pagination.limit", equalTo(10),
                        "meta.pagination.links.current", equalTo("https://gorest.co.in/public/v1/users?page=1"),
                        "data.id", hasSize(10), "data.status", hasItem("active"), "data.name", hasItems("Aalok Acharya DDS", "Acharyasuta Chattopadhyay DC", "Shresth Nehru"));
        // "The female users are more  than male users or equals" 1.yol:
        JsonPath json = response.jsonPath();
        List<String> gender = json.getList("data.gender");

        int numberOfFemales = 0;
        for (String each : gender
        ) {
            if (each.equalsIgnoreCase("female")) {
                numberOfFemales++;
            }
        }
        System.out.println("numberOfFemales = " + numberOfFemales);

        assertTrue(numberOfFemales >= gender.size() - numberOfFemales);
        //2.yol

      List<String> femaleList=  json.getList("data.findAll{it.gender=='female'}.gender");
      List<String> maleList=  json.getList("data.findAll{it.gender=='male'}.gender");
      assertTrue(femaleList.size()>maleList.size());

    }
}
