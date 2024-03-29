package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DummyDataPojo {


    private String employee_name;
    private Integer employee_salary;
    private Integer employee_age;
    private String profile_image;

    /**
     * No args constructor for use in serialization
     *
     */
    public DummyDataPojo() {
    }


    public DummyDataPojo(String employee_name, Integer employeeSalary, Integer employee_age, String profile_image) {
        super();

        this.employee_name = employee_name;
        this.employee_salary = employeeSalary;
        this.employee_age = employee_age;
        this.profile_image = profile_image;
    }





    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Integer getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(Integer employee_salary) {
        this.employee_salary = employee_salary;
    }

    public Integer getEmployee_age() {
        return employee_age;
    }

    public void setEmployee_age(Integer employee_age) {
        this.employee_age = employee_age;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    @Override
    public String toString() {
        return "DummyDataPojo{" +
                ", employeeName='" + employee_name + '\'' +
                ", employeeSalary=" + employee_salary +
                ", employeeAge=" + employee_age +
                ", profileImage='" + profile_image + '\'' +
                '}';
    }
}