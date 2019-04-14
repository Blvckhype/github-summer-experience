package pl.allegro.summer.experience.github.repository;

import pl.allegro.summer.experience.github.model.GithubRepo;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface GithubRepoRepository {

    @GET("/users/allegro/repos")
    Call<List<GithubRepo>> getReposFromGithub();
}
