package tutorial;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import junit.framework.Assert;

public class EntendendoRestAssured {

    @Test
    public void develistarTodasActivities() {
        Response response = RestAssured.request(Method.GET, "https://fakerestapi.azurewebsites.net//api/v1/Activities");
        System.out.println(response.getBody().asPrettyString());
        Assertions.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void estendendoFormasRestAssured() {
        given().when().get("https://fakerestapi.azurewebsites.net//api/v1/Activities").then().statusCode(200);

    }

    @Test
    public void deveTrazerInformacaoEspecifica() {
        given().when().get("https://fakerestapi.azurewebsites.net//api/v1/Activities/22")
                .then()
                .body("completed", Matchers.is(true))
                .body("title", Matchers.is("Activity 22"))
                .statusCode(200);
    }

    @Test
    public void erroDeConsulta() {
        given().when().get("https://fakerestapi.azurewebsites.net//api/v1/Activities/50")
                .then()
                .body("title", Matchers.is("Not Found"))
                .statusCode(404);
    }

}
