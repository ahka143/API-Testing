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



        //4.step: Do assertion

        //i) Status code is 200
        //  ii) There are 24 employees
        // iii) "Tiger Nixon" and "Garrett Winters" are among the employees
        response.then().assertThat().statusCode(200).body("data.id",hasSize(24),
                "data.employee_name",hasItems("Tiger Nixon","Garrett Winters"));

        //  iv) The greatest age is 66

        JsonPath jsonPath=response.jsonPath();
      List<Integer> employeesAgeList=jsonPath.getList("data.employee_age");
        Collections.sort(employeesAgeList);
       assertTrue(employeesAgeList.get(employeesAgeList.size()-1)==66);
        System.out.println("employeesAgeList = " + employeesAgeList.get(0));
        //   v) The name of the lowest age is "Tatyana Fitzpatrick"
      List<String> lowestAgeList= jsonPath.getList("data.findAll{it.employee_age== "+employeesAgeList.get(0)+"}.employee_name");
        System.out.println("lowestAgeList = " + lowestAgeList);
        assertEquals("Tatyana Fitzpatrick",lowestAgeList.get(0));
        //  vi) Total salary of all employees is 6,644,770

        List<Integer> employeesSalaryList=jsonPath.getList("data.employee_salary");
        System.out.println("employeesSalaryList = " + employeesSalaryList);
      Integer totalSalary=  employeesSalaryList.stream().reduce(Integer::sum).get();
        System.out.println("totalSalary = " + totalSalary);

        assertEquals(6644770, (int) totalSalary);

    }
}
