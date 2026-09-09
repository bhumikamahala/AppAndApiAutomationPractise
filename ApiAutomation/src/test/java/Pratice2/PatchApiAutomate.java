package Pratice2;

import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PatchApiAutomate {

    @Test
    public void test01(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name","Def");
        jsonObject.addProperty("job","Sdet");
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users";
        given().
                pathParam("id",11)
                .body(jsonObject.toString())
              //  .header("Content-Type","applications/Json")
                .contentType("application/json")
                .when()
                .patch("/{id}")
                .then()
                .statusCode(200)
                .log().all();
    }
}
