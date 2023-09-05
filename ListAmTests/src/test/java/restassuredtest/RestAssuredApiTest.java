package restassuredtest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredApiTest {
    @Test(groups = "statusCode")
    void statusCodeTest() {
        Response response = RestAssured.get("https://reqres.in/api/users/2");
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(groups = "responseTime")
    void responseTimeTest() {
        RestAssured.baseURI = "https://reqres.in/api/users";
        RequestSpecification HTTPRequest = RestAssured.given();
        Response response = HTTPRequest.request(Method.GET, "/2");
        boolean isResponseTimeUnder5000 = response.getTime() < 5000;
        Assert.assertTrue(isResponseTimeUnder5000);
    }

    @Test(groups = "statusCode")
    public void statusCodeTest1() {
        String endpoint = "https://reqres.in/api/users/2";
        RestAssured.given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().statusCode(200);
    }
}
