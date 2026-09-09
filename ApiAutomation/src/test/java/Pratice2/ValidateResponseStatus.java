package Pratice2;

import com.sun.net.httpserver.HttpServer;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.protocol.HTTP;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ValidateResponseStatus {


    // through bbd style
    @Test
    public void validateStatusCode1(){
      //  baseURI = "https://jsonplaceholder.typicode.com/users";
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .log()
                .all();
    }

    // non BDD style using Assert
    @Test
    public void ValidateStatusCode2(){
        baseURI = "https://jsonplaceholder.typicode.com/users";
        RequestSpecification requestSpecification = given();
       Response response =  requestSpecification.get();
       int ActualStCode = response.getStatusCode();
       String ActualStLine = response.getStatusLine();
        Assert.assertEquals(ActualStCode,200);
        Assert.assertEquals(ActualStLine, "HTTP/1.1 200 OK");
    }

    // non BDD style without Assertion
    @Test
    public void ValidateStatusCode3(){
        baseURI = "https://jsonplaceholder.typicode.com/users";
        RequestSpecification requestSpecification = given();
        Response response = requestSpecification.get();
        response.then().statusCode(200).statusLine("HTTP/1.1 200 OK")
                .log().all();
    }
}
