package tutorial;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticaJWT {

    @Test
    public void devefazerAuthenticacaoComJWT() {
        Map<String, String> login = new HashMap<String, String>();
        login.put("email", "ediel@mail.com");
        login.put("senha", "123456");

        String token = given().log().all()
                .body(login)
                .contentType(ContentType.JSON)
                .when()
                .post("http://barrigarest.wcaquino.me/signin")
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("token");

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
