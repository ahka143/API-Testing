package get_requests;

import base_Urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingPojo;
import test_data.HerokuappTestData;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get15ObjectMapper extends HerOkuAppBaseUrl {

/*
Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
               {
    "firstname": "Oliver",
    "lastname": "Smith",
    "totalprice": 100,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2022-07-18",
        "checkout": "2022-07-19"
    },
    "additionalneeds": "Breakfast"
}
 */

    @Test
    public void get01() {
        //1.step: set the url
        spec.pathParams("first","booking","second",22);

        //2.step: set the expected data
      HerokuappTestData herokuappTestData=new HerokuappTestData();
        String expectedData=herokuappTestData.herokuAppjsonToString("Oliver","Smith",100,true,"2022-07-18","2022-07-19","Breakfast");

      BookingPojo expecteddataPojo=  JsonUtil.convertJsonToJavaObject(expectedData, BookingPojo.class);

      //3.step:Send the Get request and get the response
      Response response = given().spec(spec).when().get("/{first}/{second}");

      //4.step:Do assertion
        BookingPojo actualdataPojo=  JsonUtil.convertJsonToJavaObject(response.asString(), BookingPojo.class);

//        assertEquals(200,response.getStatusCode());
//        assertEquals(expecteddataPojo.getFirstname(),actualdataPojo.getFirstname());
//        assertEquals(expecteddataPojo.getLastname(),actualdataPojo.getLastname());
//        assertEquals(expecteddataPojo.getTotalprice(),actualdataPojo.getTotalprice());
//        assertEquals(expecteddataPojo.getDepositpaid(),actualdataPojo.getDepositpaid());
//        assertEquals(expecteddataPojo.getAdditionalneeds(),actualdataPojo.getAdditionalneeds());
//        assertEquals(expecteddataPojo.getBookingdates().getCheckin(),actualdataPojo.getBookingdates().getCheckin());
//        assertEquals(expecteddataPojo.getBookingdates().getCheckout(),actualdataPojo.getBookingdates().getCheckout());

        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(200,response.getStatusCode());
        softAssert.assertEquals(expecteddataPojo.getFirstname(),actualdataPojo.getFirstname());
        softAssert.assertEquals(expecteddataPojo.getLastname(),actualdataPojo.getLastname());
        softAssert.assertEquals(expecteddataPojo.getTotalprice(),actualdataPojo.getTotalprice());
        softAssert.assertEquals(expecteddataPojo.getDepositpaid(),actualdataPojo.getDepositpaid());
        softAssert.assertEquals(expecteddataPojo.getAdditionalneeds(),actualdataPojo.getAdditionalneeds());
        softAssert.assertEquals(expecteddataPojo.getBookingdates().getCheckin(),actualdataPojo.getBookingdates().getCheckin());
        softAssert.assertEquals(expecteddataPojo.getBookingdates().getCheckout(),actualdataPojo.getBookingdates().getCheckout());
        softAssert.assertAll();

    }
}
