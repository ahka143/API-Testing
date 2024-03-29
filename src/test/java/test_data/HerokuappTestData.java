package test_data;

import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class HerokuappTestData {

   public Map<String,String> bookingDatesSetup(String checkin,String checkout){

       Map<String,String> bookingDatesMap=new HashMap<>();
       bookingDatesMap.put("checkin",checkin);
       bookingDatesMap.put("checkout",checkout);

       return bookingDatesMap;
   }

   public Map<String,Object> expectedDataSetup(String firstname,String lastname,Integer totalprice,boolean depositpaid, Map<String,String> bookingdates ){

       Map<String,Object> expectedDataMap = new HashMap<>();
       expectedDataMap.put("firstname",firstname);
       expectedDataMap.put("lastname",lastname);
       expectedDataMap.put("totalprice",totalprice);
       expectedDataMap.put("depositpaid",depositpaid);
       expectedDataMap.put("bookingdates",bookingdates);
       return expectedDataMap;
   }


   public String herokuAppjsonToString(String firstname,String lastname,Integer totalprice,Boolean depositpaid,String checkin,String checkout,String additionalneeds) {

       String expectedData = "             {\n" +
               "\"firstname\": \"" + firstname + "\",\n" +
               "\"lastname\": \"" + lastname + "\",\n" +
               "\"totalprice\": " + totalprice + ",\n" +
               "\"depositpaid\": " + depositpaid + ",\n" +
               "\"bookingdates\": {\n" +
               "    \"checkin\": \"" + checkin + "\",\n" +
               "    \"checkout\": \"" + checkout + "\"\n" +
               "},\n" +
               "\"additionalneeds\": \"" + additionalneeds + "\"\n" +
               "}";
   return expectedData;
   }
}
