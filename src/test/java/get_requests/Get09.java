package get_requests;

import base_Urls.HerOkuAppBaseUrl;
import org.junit.Test;

public class Get09 extends HerOkuAppBaseUrl {

    /*
    Given
            https://restful-booker.herokuapp.com/booking/91
        When
            I send GET Request to the url
        Then
            Response body should be like that;
            {
        "firstname": "James",
        "lastname": "Brown",
        "totalprice": 111,
        "depositpaid": true,
        "bookingdates": {
            "checkin": "2018-01-01",
            "checkout": "2019-01-01"
        },
        "additionalneeds": "Breakfast"
         }
     */

    @Test
    public void get01() {
        //1.Set the Url

        spec.pathParams("first","booking","second",91);

        //2.Set the expectedData



    }
}
