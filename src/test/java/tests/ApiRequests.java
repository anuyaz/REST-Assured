package tests;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.hasItems;

public class ApiRequests {

    @Test
    public void getTest(){
        baseURI = "https://reqres.in/api";

        given().get("/users?page=2").
                then().
                statusCode(200).
                body("data.first_name", hasItems("Byron","Rachel"));
    }

    @Test
    public void postTest(){
        baseURI = "https://reqres.in/api";

        JSONObject request = new JSONObject();

        request.put("name","Anuradha");
        request.put("job","Senior QA");

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();
    }

    @Test
    public void putTest(){
        baseURI = "https://reqres.in/api";

        JSONObject request = new JSONObject();

        request.put("name","Anuradha");
        request.put("job","QA");

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void patchTest(){
        baseURI = "https://reqres.in/api";

        JSONObject request = new JSONObject();

        request.put("name","Anuradha");
        request.put("job","QA");

        given().
                header("Content-Type","application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("/users/2").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void deleteTest(){
        baseURI = "https://reqres.in/api";

        when().
                delete("/users/2").
                then().
                statusCode(204).
                log().all();
    }
}
