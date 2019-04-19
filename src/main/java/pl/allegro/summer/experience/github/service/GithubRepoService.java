package pl.allegro.summer.experience.github.service;

import org.springframework.stereotype.Service;
import pl.allegro.summer.experience.github.model.GithubRepo;
import pl.allegro.summer.experience.github.parser.DataParser;
import pl.allegro.summer.experience.github.repository.GithubRepoRepository;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class GithubRepoService {

    private static final String GITHUB_BASE_URL = "https://api.github.com";
    private GithubRepoRepository githubRepoRepository;

    public GithubRepoService() {
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

    public GithubRepo lastModifiedRepo() throws IOException {
        List<GithubRepo> githubRepos = getAllGithubRepositories();
        Collections.sort(githubRepos);
//        Collections.reverse(githubRepos);
        githubRepos.forEach(GithubRepo::getName);
        return githubRepos.get(0);
    }

}
