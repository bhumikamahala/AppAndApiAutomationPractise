package Pratice2;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ValidateResponseheader {

    @Test
    public void test01HeaderResponse() {

        RequestSpecification requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://jsonplaceholder.typicode.com");
        requestSpecification.basePath("/users");

        Response response = requestSpecification.get();

        Headers headerList = response.headers();

        // Print all response headers
        for (Header header : headerList) {
            System.out.println(header.getName() + ": " + header.getValue());
        }

        // Get Content-Type header value
        String contentType = headerList.getValue("Content-Type");

        // Validate Content-Type header
        Assert.assertEquals(
                contentType,
                "application/json; charset=utf-8",
                "Content-Type header value did not match"
        );
    }
}