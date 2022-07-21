package get_requests;

import base_Urls.DummyBasuUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Get16 extends DummyBasuUrl {

    /*
           URL: https://dummy.restapiexample.com/api/v1/employees
           HTTP Request Method: GET Request
           Test Case: Type by using Gherkin Language
           Assert:  i) Status code is 200
                   ii) There are 24 employees
                  iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                   iv) The greatest age is 66
                    v) The name of the lowest age is "Tatyana Fitzpatrick"
                   vi) Total salary of all employees is 6,644,770
    */

    @Test
    public void get01() {


        //1.step: set the url

        spec.pathParam("first", "employees");

        //2.step:set the ecpected data

        //3.step: send the get request and get the response

        Response response = given().spec(spec).accept(ContentType.JSON).when().get("/{first}");
        response.prettyPrint();


        //4.step: Do assertion

        //i) Status code is 200
        //  ii) There are 24 employees
        // iii) "Tiger Nixon" and "Garrett Winters" are among the employees
        response.then().assertThat().statusCode(200).body("data.id",hasSize(24),
                "data.employee_name",hasItems("Tiger Nixon","Garrett Winters"));

        //  iv) The greatest age is 66

        JsonPath jsonPath=response.jsonPath();
      List<String> employeesAgeList=jsonPath.getList("data.employee_age");
        Collections.sort(employeesAgeList);
        assertEquals()
        System.out.println("employeesAgeList = " + employeesAgeList);
        //   v) The name of the lowest age is "Tatyana Fitzpatrick"
        //  vi) Total salary of all employees is 6,644,770

    }
}
