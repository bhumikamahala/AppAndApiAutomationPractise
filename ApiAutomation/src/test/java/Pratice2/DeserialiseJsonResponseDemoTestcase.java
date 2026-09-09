package Pratice2;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeserialiseJsonResponseDemoTestcase {

    @Test
    public void testResponse01(){

        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://jsonplaceholder.typicode.com");
        requestSpecification.basePath("/users");


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name","Abc");
        jsonObject.addProperty("id",11);

       Response response = requestSpecification.contentType(ContentType.JSON).body(jsonObject.toString()).post();

        ResponseBody responseBody = response.getBody();

        // Deseralise response body that is json body to class - object

        JsonPostrequestResponse jsonPostrequestResponse = response.as(JsonPostrequestResponse.class);
        Assert.assertEquals(jsonPostrequestResponse.name, "Abc");
        Assert.assertEquals(jsonPostrequestResponse.id, 11);
    }
}
