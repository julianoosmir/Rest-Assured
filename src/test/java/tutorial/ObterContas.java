package tutorial;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class ObterContas extends BaseTest {

    // @BeforeEach
    // public void obterToken() {
    // Map<String, String> login = new HashMap<String, String>();
    // login.put("email", "ediel@mail.com");
    // login.put("senha", "123456");

    // this.token = given().log().all()
    // .body(login)
    // .contentType(ContentType.JSON)
    // .when()
    // .post("/signin")
    // .then()
    // .log().all()
    // .statusCode(200)
    // .extract().path("token");
    // };

    @Test
    public void deveRetonarTodasAsConstas() {
        given()
                .log()
                .all()
                .header("Authorization", "JWT " + token)
                .when()
                .get("http://barrigarest.wcaquino.me/contas")
                .then()
                .log()
                .all()
                .statusCode(200);
    }

}
