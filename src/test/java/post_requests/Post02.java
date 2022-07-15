package post_requests;

import base_Urls.HerOkuAppBaseUrl;
import org.junit.Test;
import test_data.HerokuappTestData;

import java.util.Map;

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
                                                        "checkin": "2020-09-09",
                                                        "checkout": "2020-09-21"
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
                herokuapp.expectedDataSetup("John", "Doe", 11111, true, bookingDatesMap);

    }
}
