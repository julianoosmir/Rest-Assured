package tutorial;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

public class InserirMovimentacao extends BaseTest {

    @Test
    public void deveInserirMovimentacao() {
        Movimentacao mov = new Movimentacao();
        mov.setConta_id(1480891);
        mov.setDescrição("movimentacao do caixa 2");
        mov.setEnvolvido("Envolvido na movimentacao");
        mov.setTipo("REC");
        mov.setDescrição("01/01/2020");
        mov.setDescrição("01/01/2023");
        mov.setValor(350f);
        mov.setStatus(true);

        given()
                .header("Authorization", "JWT " + token)
                .body(mov)
                .when()
                .get("/transacoes")
                .then().statusCode(200);
    }
}
