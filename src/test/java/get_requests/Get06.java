package get_requests;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Get06 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/555
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is “application/json”
        And
            Response body should be like;
          {
            "firstname": "Sally",
            "lastname": "Brown",
            "totalprice": 111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2013-02-23",
                "checkout": "2014-10-23"
            },
            "additionalneeds": "Breakfast"
        }
     */
    @Test
    public void get01() {
        //1.Set the Url
        spec.pathParams("first", "booking", "second", 101);

        //2.Set the expected data
        //3.Type the code to send request
        Response response = given().spec(spec).when().get("/{first}/{second}/");
        response.prettyPrint();

        //4.Do assertion
        //1.yol
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).
                body("firstname", equalTo("GGS"), "lastname", equalTo("FINCH"),
                        "totalprice", equalTo(111), "depositpaid", equalTo(true),
                        "bookingdates.checkin", equalTo("2018-01-01"),
                        "bookingdates.checkout", equalTo("2019-01-01")
                );

        //2.yol: JsonPath Class'la cozum
        JsonPath json = response.jsonPath();
        assertEquals("GGS",json.getString("firstname"));
        assertEquals("FINCH",json.getString("lastname"));
        assertTrue(json.getBoolean("depositpaid"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));

        //   String  actualJsn=jsonPath.getString("bookingdates");
        //   String expectedJsn="[checkin:2018-01-01, checkout:2019-01-01]";
        //   assertEquals(expectedJsn,actualJsn);

        //3.yol: Soft assertion
        //Soft assertion icin 3 adim izlenir:

        //1.adim:Soft assert objesi olusturulur
        SoftAssert softAssert=new SoftAssert();
        //2.adim:obje araciligi ile aseert yapilir
        softAssert.assertEquals("GGS",json.getString("firstname"));
        softAssert.assertEquals("FINCH",json.getString("lastname"));
        softAssert.assertTrue(json.getBoolean("depositpaid"));
        softAssert.assertEquals("2018-01-01",json.getString("bookingdates.checkin"),"tarih uyusmadi");
        softAssert.assertEquals("2019-01-01",json.getString("bookingdates.checkout"));
        softAssert.assertAll();

    }

}
