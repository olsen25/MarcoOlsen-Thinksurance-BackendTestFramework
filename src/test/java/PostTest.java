import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.EmployeeData;
import utils.CSVAnnotation;
import utils.GenericDataProvider;
import utils.PropertiesManager;

import java.io.IOException;
import java.util.Map;

public class PostTest {
    public static final Logger logger = Logger.getLogger(PostTest.class);

    @Test(groups={"Regression"},dataProvider = "dataproviderForTestCase", dataProviderClass = GenericDataProvider.class)
    @CSVAnnotation.CSVFileParameters(path = "src/test/test-data/employeeInfo.csv", delimiter = "###")
    public void addEmployee(int rowNo, Map<String, String> inputData) throws IOException {
        //Insert employee
        AddEmployees addEmployee = new AddEmployees(PropertiesManager.getProperty("baseURI"));
        addEmployee.setEmployeeName(inputData.get("employee_name"));
        addEmployee.setEmployeeSalary(inputData.get("employee_salary"));
        addEmployee.setEmployeesAge(inputData.get("employee_age"));
        addEmployee.setExpectedStatusCode(200);
        addEmployee.perform();

        EmployeeData employeeData = addEmployee.getAPIResponseAsPOJO(EmployeeData.class);
        String actualMSG=employeeData.getMessage();
        Assert.assertEquals(actualMSG,"Successfully! Record has been added.");
        logger.info( "Employee added successfully");

    }

}
