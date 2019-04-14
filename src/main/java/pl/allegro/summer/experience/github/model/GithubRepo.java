package pl.allegro.summer.experience.github.model;

import com.google.gson.annotations.SerializedName;

public class GithubRepo {

    private String name;

    @SerializedName("updated_at")
    private String updateedAt;

    public String getName() {
        return name;
    }

    public String getUpdatedAt() {
        return updateedAt;
    }

}
