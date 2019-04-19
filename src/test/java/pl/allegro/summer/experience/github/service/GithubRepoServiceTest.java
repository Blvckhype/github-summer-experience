package pl.allegro.summer.experience.github.service;

import org.junit.Assert;
import org.junit.Test;
import pl.allegro.summer.experience.github.model.GithubRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GithubRepoServiceTest {

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

}