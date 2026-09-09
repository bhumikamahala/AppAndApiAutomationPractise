package Pratice2;

import com.google.gson.JsonObject;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class PostApiAutomate {

    @Test
    public void test01(){
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("name","Abc");
        jsonObject.addProperty("job","QA");

      baseURI = "https://jsonplaceholder.typicode.com/users";
//      given().body(jsonObject).when().put(baseURI).then().statusCode(200);

        given().header("Content-Type","application/json")
                .body(jsonObject.toString())
                .when().post()
                .then().statusCode(201)
                .log().all();   // response m jo bhi hoga vo sab log kar dega - header , body , response code etc

    }
}
