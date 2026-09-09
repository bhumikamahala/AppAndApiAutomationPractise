package Pratice2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class QueryParamDataValidate {

    @Test
    public void QueryParam01(){
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://jsonplaceholder.typicode.com");
        requestSpecification.basePath("/users");
        requestSpecification.queryParam("page","2").queryParam("id",10);

        Response response = requestSpecification.get();
        ResponseBody responseBody = response.getBody();
        String responseString = response.asString();
        System.out.println(responseString);

    }
}
