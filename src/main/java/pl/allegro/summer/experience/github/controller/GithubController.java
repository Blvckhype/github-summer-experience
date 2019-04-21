package pl.allegro.summer.experience.github.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.allegro.summer.experience.github.model.GithubRepo;
import pl.allegro.summer.experience.github.service.GithubRepoService;

import java.io.IOException;

@RestController
public class GithubController {

    private GithubRepoService githubRepoService;

    public GithubController(GithubRepoService githubRepoService) {
        this.githubRepoService = githubRepoService;
    }

    @GetMapping(value = "/lastModifiedRepository", produces = MediaType.APPLICATION_JSON_VALUE)
    public GithubRepo lastModifiedRepository() throws IOException {
        return githubRepoService.lastModifiedRepo();
    }
}
