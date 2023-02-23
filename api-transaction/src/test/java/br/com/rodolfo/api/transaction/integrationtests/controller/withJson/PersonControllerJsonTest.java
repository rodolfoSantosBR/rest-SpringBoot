package br.com.rodolfo.api.transaction.integrationtests.controller.withJson;


import br.com.rodolfo.api.transaction.configs.TestConfigs;
import br.com.rodolfo.api.transaction.integrationtests.testcontainers.AbstractIntegrationTest;
import br.com.rodolfo.api.transaction.integrationtests.vo.PersonVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PersonControllerJsonTest extends AbstractIntegrationTest {


    private static RequestSpecification specification;

    private static ObjectMapper objectMapper;

    private static PersonVO person;


    @BeforeAll
    public static void setup() {

        objectMapper = new ObjectMapper();

        // Vai desabilitar falha quando vierem campos existentes no Json
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        person = new PersonVO();


    }


    @Test
    @Order(1)
    public void testCreate() throws JsonProcessingException {

        mockPerson();

        // Deve ficar aqui porque beforeAll nao pega o contexto do Spring
        specification = new RequestSpecBuilder()
                .addHeader(TestConfigs.HEADER_PARAM_ORIGIN, "https://erudio.com.br")
                .setBasePath("/person")
                .setPort(TestConfigs.SERVER_PORT)
                .addFilter(new RequestLoggingFilter(LogDetail.ALL))
                .addFilter(new ResponseLoggingFilter(LogDetail.ALL))
                .build();

        var content =
                given().spec(specification)
                        .contentType(TestConfigs.CONTENT_TYPE_JSON)
                        .body(person)
                        .when()
                        .post()
                        .then()
                        .statusCode(200)
                        .extract()
                        .body()
                        .asString();

        PersonVO createdPerson = objectMapper.readValue(content, PersonVO.class);
        person = createdPerson ;

        assertNotNull(person.getId());
        assertNotNull(person.getFirstName());
        assertTrue(createdPerson.getId() > 0);


        assertEquals("Richard", createdPerson.getFirstName());


    }

    private void mockPerson() {
        person.setFirstName("Richard");
        person.setLastName("Stallment");
        person.setAddress("Nova York");
        person.setGender("Male");

    }

}