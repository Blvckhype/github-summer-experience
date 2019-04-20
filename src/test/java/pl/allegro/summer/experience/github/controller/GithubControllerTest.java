package pl.allegro.summer.experience.github.controller;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.is;

@SpringBootTest
public class GithubControllerTest {

    @Test
    public void LAST_MODIFIED_REPOSITORY_STATUS_OK() {
        when().get("/lastModifiedRepository").then().statusCode(200);
    }

    @Test
    public void LAST_MODIFIED_REPOSITORY_SIZE_EQUALS_ONE() {
        when().get("/lastModifiedRepository").then().assertThat().body("size()", is(1));
    }

    @Test
    public void LAST_MODIFIED_REPOSITORY_SCHEMA_VALIDATION() {
        when().get("/lastModifiedRepository").then().body(matchesJsonSchemaInClasspath("lastModifiedRepositorySchema.json"));
    }
}