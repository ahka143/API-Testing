package get_requests;

import base_Urls.DummyBasuUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyDataPojo;
import pojos.DummyResponsePojo;
import utils.JsonUtil;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get17 extends DummyBasuUrl {

    /*
       URL: https://dummy.restapiexample.com/api/v1/employee/1
       HTTP Request Method: GET Request
       Test Case: Type by using Gherkin Language
       Assert: 	i) Status code is 200
               ii) "employee_name" is "Tiger Nixon"
              iii) "employee_salary" is 320800
               iv)  "employee_age" is 61
                v) "status" is "success"
               vi)  "message" is "Successfully! Record has been fetched."
     */

    /*
    Given
          URL: https://dummy.restapiexample.com/api/v1/employee/1

    When
         User send the Get request
    Then
        Status code is 200
    And
        "employee_name" is "Tiger Nixon"
    And
       "employee_salary" is 320800
    And
        "employee_age" is 61
    And
       "status" is "success"
    And
       "message" is "Successfully! Record has been fetched."


     */
@Test
    public void get01(){
        //1.step: Set the url
        spec.pathParams("first","employee","second",1);

        //2.step:Set the ecpected Data
        DummyDataPojo dataPojo=new DummyDataPojo("Tiger Nixon",320800,61,"");
        DummyResponsePojo responseBodyPojo=new DummyResponsePojo("success",dataPojo,"Successfully! Record has been fetched.");


        //3.step:Send Get request and get the response

      Response response= given().spec(spec).when().get("/{first}/{second}");
      response.prettyPrint();

  DummyResponsePojo   actualResponcePojo=JsonUtil.convertJsonToJavaObject(response.asString(),DummyResponsePojo.class);
    System.out.println(actualResponcePojo.toString());
    //3.step:Do assertion
    response.then().assertThat().statusCode(200);
    assertEquals(responseBodyPojo.getStatus(),actualResponcePojo.getStatus());
    assertEquals(dataPojo.getEmployee_name(),actualResponcePojo.getData().getEmployee_name());
    assertEquals(dataPojo.getEmployee_salary(),actualResponcePojo.getData().getEmployee_salary());
    assertEquals(dataPojo.getEmployee_age(),actualResponcePojo.getData().getEmployee_age());
    assertEquals(responseBodyPojo.getMessage(),actualResponcePojo.getMessage());
    }
}
