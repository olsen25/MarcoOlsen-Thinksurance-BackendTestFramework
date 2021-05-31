import utils.PropertiesManager;

import static io.restassured.RestAssured.given;

public class GetEmployees extends BaseAPI {

    String apiPath= PropertiesManager.getProperty("getEmployeeAPI");
    String idEmployee;

    public GetEmployees(String baseURI){
        super(baseURI);
    }

    public void setIdEmployee(String idEmployee) {
        this.idEmployee = idEmployee;
    }

    @Override
    protected void createRequest() {
        requestSpecBuilder.setBaseUri(baseURI);
        requestSpecBuilder.setBasePath(apiPath);
        requestSpecBuilder.addPathParam("id",idEmployee);
        requestSpecification=requestSpecBuilder.build();
    }

    @Override
    protected void executeRequest() {
        apiResponse = given().spec(requestSpecification).get();
    }

    @Override
    protected void validateResponse() {
        responseSpecBuilder.expectStatusCode(expectedStatusCode);
        responseSpecification=responseSpecBuilder.build();
        apiResponse.then().spec(responseSpecification);
    }
}
