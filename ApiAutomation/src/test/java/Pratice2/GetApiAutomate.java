package Pratice2;

// import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetApiAutomate {


    // GET Api automate : https://reqres.in/api/test-suite/collections/users/records
    @Test
    public void Test01(){
//        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users");
//        System.out.println(response.asString());
//        System.out.println(response.statusCode());
        //   if we want that we don't use Restassured class again and again in test case then we have to do import static - import static io.restassured.RestAssured.*;
        Response response = get("https://jsonplaceholder.typicode.com/users");
        System.out.println(response.asString());
        System.out.println(response.statusCode());
    }

    // https://jsonplaceholder.typicode.com/users/2

    @Test
    public void test02(){
//        Response response = RestAssured.get("https://jsonplaceholder.typicode.com/users/2");
        //   if we want that we don't use Restassured class again and again in test case then we have to do import static - import static io.restassured.RestAssured.*;
        Response response = get("https://jsonplaceholder.typicode.com/users/2");
        int statuscodeActual =  response.getStatusCode();
        System.out.println(response.getBody().asPrettyString());
      //  System.out.println(response.getHeaders());
        System.out.println(response.getHeader("Content-Type"));
        System.out.println(response.getTime());

        // valid status code : 200
        int statuscodeExpected = 200 ;
        Assert.assertEquals(statuscodeActual, statuscodeExpected);
    }


    // https://jsonplaceholder.typicode.com/users?name=Ervin%20Howell
    @Test
    public void test03(){
//        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/users" ;
//        RestAssured.given().queryParam("name","Ervin%20Howell").then().statusCode(200);
        //   if we want that we don't use Restassured class again and again in test case then we have to do import static - import static io.restassured.RestAssured.*;

     baseURI = "https://jsonplaceholder.typicode.com/users" ;
       given().queryParam("name","Ervin%20Howell").then().statusCode(200);
    }


}
