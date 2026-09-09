package Pratice2;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PutApiAutomate {

    @Test
    public void test01(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name","Abc");
        jsonObject.addProperty("job","SDET");

        RestAssured.given()
                 .pathParam("id", 11)
                .header("Content-Type","application/Json")
                .body(jsonObject.toString())
                .when()
              //  .put("/users/11")
                .put("/{id}")
                .then()
                .statusCode(200)
                .log().all();
    }

    public static class ValidateResponseBody {


        @Test
        public void testValidateResponse01(){
            RequestSpecification requestSpecification = RestAssured.given();
            requestSpecification.baseUri("https://jsonplaceholder.typicode.com");
            requestSpecification.basePath("/users");

            Response response = requestSpecification.get();
           ResponseBody ResponseBody = response.getBody();

           // want to print as a string then
          //  String responsebody = ResponseBody.asString();
           // System.out.println(responsebody);
          //  Assert.assertEquals("Samantha","Samantha","name is correct present in response body");


            // want to validate json response body full exact details
            JsonPath jsonPath = ResponseBody.jsonPath();
            String username = jsonPath.getString("[0].username");
            Assert.assertEquals(username,"Bret","username is not correct");
        }
    }
}
