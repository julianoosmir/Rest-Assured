package tutorial;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class RestAssuredAuth {

    @Test
    public void DeveAutenticar() {
        given()
                .log()
                .all().auth().basic("admin", "senha")
                .when()
                .get("https://restapi.wcaquino.me/basicauth")
                .then()
                .log().all()
                .statusCode(200)
                .body("status", Matchers.is("logado"));
    }

    @Test
    public void naoDeveAutenticar() {
        given()
                .log()
                .all()
                .when()
                .get("https://restapi.wcaquino.me/basicauth")
                .then()
                .log().all()
                .statusCode(401);
    }
}
