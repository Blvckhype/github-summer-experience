package pl.allegro.summer.experience.github.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import pl.allegro.summer.experience.github.model.GithubRepo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class GithubRepoServiceImplTest {

    @InjectMocks
    private GithubRepoServiceImpl githubRepoService;

    @Test
    public void THIS_SAME_TIMESTAMP_FOR_TWO_PROJECTS() {
        GithubRepo ataner = new GithubRepo("Ataner", "2019-04-19T02:42:45Z");
        GithubRepo altano = new GithubRepo("Altano", "2019-04-19T02:42:45Z");
        List<GithubRepo> repos = new ArrayList<GithubRepo>() {{
            add(ataner);
            add(altano);
        }};

        Collections.sort(repos);
        Assert.assertEquals(altano, repos.get(0));
    }

    @Test
    public void GITHUB_API_RESPONSE_OK() throws IOException {
        Assert.assertEquals(200, githubRepoService.getGithubRepoRepository().getReposFromGithub().execute().code());
    }

}