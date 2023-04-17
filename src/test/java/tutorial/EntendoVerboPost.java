package tutorial;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import io.restassured.http.ContentType;

public class EntendoVerboPost {

    @Test
    public void deveRealizarPost() {
        given().log().all()
                .contentType("application/json")
                .body("{\"title\" : \"teste\",\"dueDate\":\"2023-04-16T00:53:37.8719604+00:00\",\"completed\": false }")
                .when().post("https://fakerestapi.azurewebsites.net//api/v1/Activities")
                .then().log().all().statusCode(200);
    }

    @Test
    public void deveRealizarPostSerializado() {
        Map<String, Object> params = new HashMap<String, Object>();

        params.put("title", "parametro");
        params.put("dueDate", "2023-04-16T00:53:37.8719604+00:00");
        params.put("completed", false);

        given().log().all()
                .contentType(ContentType.JSON)
                .body(params)
                .when().post("https://fakerestapi.azurewebsites.net//api/v1/Activities")
                .then().log().all()
                .statusCode(200)
                .body("title", Matchers.is("parametro"));
    }

    @Test
    public void deveRealizarPostObjetoSerializado() {
        Activity activity = new Activity("parametro", "2023-04-16T00:53:37.8719604+00:00", false);

        given().log().all()
                .contentType(ContentType.JSON)
                .body(activity)
                .when().post("https://fakerestapi.azurewebsites.net//api/v1/Activities")
                .then().log().all()
                .statusCode(200)
                .body("title", Matchers.is("parametro"));
    }

    @Test
    public void deveRealizarPostObjetoDesSerializado() {
        Activity activity = new Activity("parametro", "2023-04-16T00:53:37.8719604+00:00", false);

        Activity activityDescerializado = given().log().all()
                .contentType(ContentType.JSON)
                .body(activity)
                .when().post("https://fakerestapi.azurewebsites.net//api/v1/Activities")
                .then().log().all()
                .statusCode(200)
                .body("title", Matchers.is("parametro"))
                .extract().body().as(Activity.class);

        System.out.println("funfou " + activityDescerializado.toString());
    }
}
