package tutorial;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class EntendendoVerboPut {

    @Test
    public void deveAlterarAtividade() {
        given().log().all()
                .contentType("application/json")
                .body("{\"completed\": true }")
                .when().put("https://fakerestapi.azurewebsites.net//api/v1/Activities/15")
                .then().log().all().statusCode(200);

    }

    @Test
    public void deveAlterarUsuario() {
        given().log().all()
                .contentType("application/json")
                .body("{\"name\":  \"joao testado\" }")
                .when().put("https://restapi.wcaquino.me/users/1")
                .then().log().all()
                .statusCode(200)
                .body("name", Matchers.is("joao testado"));

    }
}
