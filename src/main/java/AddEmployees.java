import utils.PropertiesManager;

import static io.restassured.RestAssured.given;

public class AddEmployees extends BaseAPI {

    String apiPath= PropertiesManager.getProperty("addEmployeeAPI");
    String employeeName, employeeSalary, employeeAge;

    public AddEmployees(String baseURI){
        super(baseURI);
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
    public void setEmployeesAge (String employeeAge) { this.employeeAge = employeeAge; }


    @Override
    protected void createRequest() {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(apiPath);
        requestSpecBuilder.addParam("name", employeeName);
        requestSpecBuilder.addParam("salary", employeeSalary);
        requestSpecBuilder.addParam("age", employeeAge);
        requestSpecification = requestSpecBuilder.build();
    }

    @Override
    protected void executeRequest() {
        apiResponse = given().spec(requestSpecification).post();
    }

    @Override
    protected void validateResponse() {
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecification=responseSpecBuilder.build();
        apiResponse.then().spec(responseSpecification);
    }
}
