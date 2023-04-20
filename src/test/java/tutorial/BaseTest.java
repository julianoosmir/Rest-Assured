package tutorial;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import tutorial.core.Constantes;

import static io.restassured.RestAssured.given;

public class BaseTest implements Constantes {

    protected static String token;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = base_URL;
        RestAssured.port = App_PORT;
        RestAssured.basePath = APP_BASE_PATH;

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setContentType(App_CONTENT_TYPE);
        RestAssured.requestSpecification = reqBuilder.build();

        ResponseSpecBuilder respBuilder = new ResponseSpecBuilder();
        respBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
        RestAssured.responseSpecification = respBuilder.build();

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        token = obterToken();
    }

    public static String obterToken() {
        Map<String, String> login = new HashMap<String, String>();
        login.put("email", "ediel@mail.com");
        login.put("senha", "123456");

        return given().log().all()
                .body(login)
                .contentType(ContentType.JSON)
                .when()
                .post("/signin")
                .then()
                .log().all()
                .statusCode(200)
                .extract().path("token");
    };

}
