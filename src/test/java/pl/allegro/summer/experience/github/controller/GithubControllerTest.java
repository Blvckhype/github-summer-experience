package pl.allegro.summer.experience.github.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.allegro.summer.experience.github.exception.RepositoriesNotFoundException;
import pl.allegro.summer.experience.github.model.GithubRepo;
import pl.allegro.summer.experience.github.service.GithubRepoServiceImpl;

import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GithubControllerTest {

    private GithubController githubController;

    @InjectMocks
    private GithubRepoServiceImpl githubRepoServiceImplMock;

    @Before
    public void init() {
        githubController = new GithubController(githubRepoServiceImplMock);
    }

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

    @Test
    public void LAST_MODIFIED_REPOSITORY_CHECK_RETURN_CONTENT() throws IOException {
        when().get("/lastModifiedRepository").then().body("name", equalTo(githubController.lastModifiedRepository().getName()));
    }

    @Test(expected = RepositoriesNotFoundException.class)
    public void GET_REPOSITORIES_NOT_FOUND_EXCEPTION_FOR_MOCK_SIZE_ZERO() {
    }
}