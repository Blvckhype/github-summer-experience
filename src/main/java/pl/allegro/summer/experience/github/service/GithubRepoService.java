package pl.allegro.summer.experience.github.service;

import org.springframework.stereotype.Service;
import pl.allegro.summer.experience.github.model.GithubRepo;

import java.io.IOException;

@Service
public interface GithubRepoService {

    public GithubRepo lastModifiedRepo() throws IOException;
}
