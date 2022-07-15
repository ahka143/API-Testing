package post_requests;

import base_Urls.HerOkuAppBaseUrl;
import org.junit.Test;
import test_data.HerokuappTestData;

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
        spec.pathParam("first","booking");

        //2.set the expected data

        HerokuappTestData herokuappTestData=new HerokuappTestData();


    }
}
