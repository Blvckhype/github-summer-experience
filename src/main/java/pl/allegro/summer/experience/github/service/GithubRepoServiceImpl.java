package pl.allegro.summer.experience.github.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import pl.allegro.summer.experience.github.exception.RepositoriesNotFoundException;
import pl.allegro.summer.experience.github.model.GithubRepo;
import pl.allegro.summer.experience.github.repository.GithubRepoRepository;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
public class GithubRepoServiceImpl implements GithubRepoService {

    private static final String GITHUB_BASE_URL = "https://api.github.com";
    private GithubRepoRepository githubRepoRepository;

    public GithubRepoServiceImpl() {
        this.githubRepoRepository = new Retrofit.Builder()
                                        .baseUrl(GITHUB_BASE_URL)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build()
                                        .create(GithubRepoRepository.class);
    }

    private List<GithubRepo> getAllGithubRepositories() throws IOException {
        Response<List<GithubRepo>> response = githubRepoRepository.getReposFromGithub().execute();

        if(response.code() == 200) {
            return response.body();
        } else {
            throw new IOException(response.errorBody() == null ? "ERROR" : response.errorBody().string());
        }
    }

    @Override
    public GithubRepo lastModifiedRepo() throws IOException {
        List<GithubRepo> githubRepos = getAllGithubRepositories();
        if (githubRepos.size() >= 1) {
            Collections.sort(githubRepos);
            return githubRepos.get(0);
        }
        throw new RepositoriesNotFoundException();
    }

    GithubRepoRepository getGithubRepoRepository() {
        return githubRepoRepository;
    }
}
