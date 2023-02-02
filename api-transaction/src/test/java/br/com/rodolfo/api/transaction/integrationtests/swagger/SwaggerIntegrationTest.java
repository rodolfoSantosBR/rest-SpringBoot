package br.com.rodolfo.api.transaction.integrationtests.swagger;


import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

import br.com.rodolfo.api.transaction.integrationtests.testcontainers.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import br.com.rodolfo.api.transaction.configs.TestConfigs;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationTest{

    @Test
    public void shouldDisplaySwaggerUiPage() {
        var content =
                given()
                        .basePath("/swagger-ui/index.html")
                        .port(TestConfigs.SERVER_PORT)
                        .when()
                        .get()
                        .then()
                        .statusCode(200)
                        .extract()
                        .body()
                        .asString();
        assertTrue(content.contains("Swagger UI"));
    }

}