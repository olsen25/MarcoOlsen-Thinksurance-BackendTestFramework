import com.fasterxml.jackson.databind.JsonNode;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.EmployeeData;
import utils.CSVAnnotation;
import utils.GenericDataProvider;
import utils.PropertiesManager;

import java.io.IOException;
import java.util.Map;

public class GetTest extends BaseTest {
    @Test(groups={"Smoke","Regression"},dataProvider = "dataproviderForTestCase", dataProviderClass = GenericDataProvider.class)
    @CSVAnnotation.CSVFileParameters(path = "src/test/test-data/employeeInfo.csv", delimiter = "###")
    public void getEmployees(int rowNo, Map<String, String> inputData) throws IOException {
        GetEmployees getEmployees = new GetEmployees(PropertiesManager.getProperty("baseURI"));
        getEmployees.setIdEmployee(inputData.get("idEmployee"));
        getEmployees.setExpectedStatusCode(200);
        getEmployees.perform();

        EmployeeData employeeData = getEmployees.getAPIResponseAsPOJO(EmployeeData.class);
        JsonNode data = employeeData.getData();
        String actualName = employeeData.getEmployee_name(data);
        String expectedName = inputData.get("employee_name");
        Assert.assertEquals(actualName, expectedName);
        String actualSalary = employeeData.getEmployee_Salary(data);
        String expectedSalary = inputData.get("employee_salary");
        Assert.assertEquals(actualSalary, expectedSalary);
        String actualAge = employeeData.getEmployee_Age(data);
        String expectedAge = inputData.get("employee_age");
        Assert.assertEquals(actualAge, expectedAge);
    }
}
