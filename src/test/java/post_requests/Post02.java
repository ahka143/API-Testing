package post_requests;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.HerokuappTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Post02 extends HerOkuAppBaseUrl {
    /*
    Given
            1) https://restful-booker.herokuapp.com/booking
            2) {
                 "firstname": "John",
                 "lastname": "Doe",
                 "totalprice": 11111,
                 "depositpaid": true,
                 "bookingdates": {
                     "checkin": "2021-09-09",
                     "checkout": "2021-09-21"
                  }
               }
        When
            I send POST Request to the Url
        Then
            Status code is 200
            And response body should be like {
                                                "bookingid": 5315,
                                                "booking": {
                                                    "firstname": "John",
                                                    "lastname": "Doe",
                                                    "totalprice": 11111,
                                                    "depositpaid": true,
                                                   "bookingdates": {
                                                         "checkin": "2021-09-09",
                                                         "checkout": "2021-09-21"
                                                      }
                                                }
                                             }
     */

    @Test
    public void post01() {
        //1.set the url
        spec.pathParam("first", "booking");

        //2.set the expected data

        HerokuappTestData herokuapp = new HerokuappTestData();
        Map<String, String> bookingDatesMap =
                herokuapp.bookingDatesSetup("2021-09-09", "2021-09-21");
        Map<String, Object> expectedDataMap =
                herokuapp.expectedDataSetup("Ahmet", "Kaya", 11111, true, bookingDatesMap);

        //3.send the post request and get the  response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).post("/{first}");
        response.prettyPrint();
        //4.Do assertion

        Map<String, Object> actualDataMap = response.as(HashMap.class);

        assertEquals(expectedDataMap.get("firstname"), ((Map) actualDataMap.get("booking")).get("firstname"));
        assertEquals(expectedDataMap.get("lastname"), ((Map) actualDataMap.get("booking")).get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"), ((Map) actualDataMap.get("booking")).get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"), ((Map) actualDataMap.get("booking")).get("depositpaid"));
        assertEquals(bookingDatesMap.get("checkin"), ((Map) ((Map) actualDataMap.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(bookingDatesMap.get("checkout"), ((Map) ((Map) actualDataMap.get("booking")).get("bookingdates")).get("checkout"));
        assertTrue(response.getStatusCode() == 200);


    }
}
