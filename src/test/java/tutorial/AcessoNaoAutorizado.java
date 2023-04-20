package tutorial;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

public class AcessoNaoAutorizado extends BaseTest {

    @Test
    public void naoDeveAcessarApiSemToken() {
        given()
                .when()
                .get("/contas")
                .then().statusCode(401);
    }

}
