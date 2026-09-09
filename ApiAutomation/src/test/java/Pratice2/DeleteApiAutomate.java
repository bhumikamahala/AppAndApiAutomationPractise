package Pratice2;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DeleteApiAutomate {

    @Test
    public void test1() {
        baseURI = "https://jsonplaceholder.typicode.com/users";
        given().
                pathParam("id",11)
                .when()
                .delete("/{id}")
                .then()
                .statusCode(200)
                .log()
                .all();
    }
}
