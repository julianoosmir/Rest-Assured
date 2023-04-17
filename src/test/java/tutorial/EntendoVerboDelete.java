package tutorial;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

public class EntendoVerboDelete {

    @Test
    public void DeveDeletarUsuario() {
        given().log().all()
                .when().delete("https://restapi.wcaquino.me/users/1")
                .then().log().all().statusCode(204);
    }
}
