package pl.allegro.summer.experience.github.service;

import org.springframework.stereotype.Service;
import pl.allegro.summer.experience.github.model.GithubRepo;

import java.io.IOException;
import java.util.List;

@Service
public interface GithubRepoService {

    GithubRepo lastModifiedRepo(List<GithubRepo> githubRepos) throws IOException;
}
