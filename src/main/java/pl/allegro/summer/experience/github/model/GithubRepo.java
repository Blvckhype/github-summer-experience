package pl.allegro.summer.experience.github.model;

import com.google.gson.annotations.SerializedName;
import pl.allegro.summer.experience.github.parser.DataParser;

import java.text.ParseException;

public class GithubRepo implements Comparable<GithubRepo> {

    private String name;
    @SerializedName("updated_at")
    private String updatedAt;

    public GithubRepo(String name, String updatedAt) {
        this.name = name;
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(GithubRepo object) {
        try {
            if (DataParser.parseDate(updatedAt).compareTo(DataParser.parseDate(object.updatedAt)) < 0) {
                return 1;
            } else if (DataParser.parseDate(updatedAt).compareTo(DataParser.parseDate(object.updatedAt)) == 0) {
                if (getName().compareTo(object.getName()) > 0)
                    return 1;
                else
                    return -1;
            } else
                return -1;
        } catch (ParseException e) {
            e.getMessage();
            e.printStackTrace();
        }
        return 0;
    }
}
