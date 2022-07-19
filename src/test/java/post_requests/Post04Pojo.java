package post_requests;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import pojos.BookingResponseBodyPojo;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Post04Pojo extends HerOkuAppBaseUrl {

/*
         Given
            https://restful-booker.herokuapp.com/booking
            {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 }
                 "additionalneeds": "Breakfast with white tea, Dragon juice"
             }
        When
 		    I send POST Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
 		                            "bookingid": 16,
 		                            "booking" :{
                                        "firstname": "Ali",
                                        "lastname": "Can",
                                        "totalprice": 999,
                                        "depositpaid": true,
                                        "bookingdates": {
                                            "checkin": "2021-09-21",
                                            "checkout": "2021-12-21"
                                        }
                                        "additionalneeds": "Breakfast with white tea, Dragon juice"
                                     }
                                  }
     */

    @Test
    public void postPojo01() {
        //1.step: Set the Url
        spec.pathParam("first", "booking");

        //2.step:Set the expected data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2021-09-21", "2021-12-21");
        BookingPojo booking = new BookingPojo("Ali", "Can", 999, true, bookingDates, "Breakfast with white tea, Dragon juice");


        //3.step: Send post request and get the response
    Response response= given().spec(spec).contentType(ContentType.JSON).body(booking).when().post("/{first}");

        //4.step: Do assertion
        BookingResponseBodyPojo actualPojo=response.as(BookingResponseBodyPojo.class);

        assertEquals(200,response.getStatusCode());
        assertEquals(booking.getFirstname(),actualPojo.getBooking().getFirstname());
        assertEquals(booking.getLastname(),actualPojo.getBooking().getLastname());
        assertEquals(booking.getTotalprice(),actualPojo.getBooking().getTotalprice());
        assertEquals(booking.getDepositpaid(),actualPojo.getBooking().getDepositpaid());
        assertEquals(booking.getBookingdates().getCheckin(),actualPojo.getBooking().getBookingdates().getCheckin());
        assertEquals(booking.getBookingdates().getCheckout(),actualPojo.getBooking().getBookingdates().getCheckout());
        assertEquals(booking.getAdditionalneeds(),actualPojo.getBooking().getAdditionalneeds());


    }
}
