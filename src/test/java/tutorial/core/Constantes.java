package tutorial.core;

import io.restassured.http.ContentType;

public interface Constantes {
    String base_URL = "http://barrigarest.wcaquino.me";
    Integer App_PORT = 80;
    String APP_BASE_PATH = "";
    ContentType App_CONTENT_TYPE = ContentType.JSON;

    Long MAX_TIMEOUT = 5000L;

}
