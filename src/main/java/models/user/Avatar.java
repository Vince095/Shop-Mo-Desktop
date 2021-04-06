package models.user;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Avatar {
    @SerializedName("public_id")
    @Expose
    private String public_id;
    @SerializedName("url")
    @Expose
    private String avatarUrl;

    public void setPublic_id(String public_id) {
        this.public_id = public_id;
    }

    public String getPublic_id() {
        return public_id;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl= avatarUrl;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }
}
