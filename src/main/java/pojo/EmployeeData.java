package pojo;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "status",
        "data",
        "message"
})
public class EmployeeData {
    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private JsonNode data;
    @JsonProperty("message")
    private String message;
    @JsonProperty("id")
    private String id;
    @JsonProperty("employee_name")
    private String employee_name;
    @JsonProperty("employee_salary")
    private String employee_salary;
    @JsonProperty("employee_age")
    private String employee_age;
    @JsonProperty("profile_image")
    private String profile_image;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonProperty("message")
    public String  getMessage() {
        return message;
    }
    @JsonProperty("message")
    public void setMessage() { this.message = message;}

    @JsonProperty("data")
    public JsonNode getData() {
        return data;
    }
    @JsonProperty("data")
    public void setData() { this.data = data;}

    @JsonProperty("id")
    public String getId(JsonNode data) { return id; }
    @JsonProperty("id")
    public void setId(JsonNode data) { this.id = id; }

    @JsonProperty("employee_name")
    public String getEmployee_name(JsonNode data) { return employee_name; }
    @JsonProperty("employee_name")
    public void setEmployee_name(JsonNode data) { this.employee_name = employee_name; }

    @JsonProperty("employee_salary")
    public String getEmployee_Salary(JsonNode data) { return employee_salary; }
    @JsonProperty("employee_salary")
    public void setEmployee_Salary(JsonNode data) { this.employee_salary = employee_salary; }

    @JsonProperty("employee_age")
    public String getEmployee_Age(JsonNode data) { return employee_age; }
    @JsonProperty("employee_age")
    public void setEmployee_Age(JsonNode data) { this.employee_age = employee_age; }

    @JsonProperty("profile_image")
    public String getEmployee_image(JsonNode data) { return profile_image; }
    @JsonProperty("profile_image")
    public void setEmployee_image(JsonNode data) { this.profile_image = profile_image; }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }
    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
