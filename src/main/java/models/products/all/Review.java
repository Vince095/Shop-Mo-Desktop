package models.products.all;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Review {
    @SerializedName("_id")
    @Expose()
    private String _id;
    @SerializedName("user")
    @Expose()
    private String user;
    @SerializedName("name")
    @Expose()
    private String name;
    @SerializedName("rating")
    @Expose()
    private int rating;
    @SerializedName("comment")
    @Expose()
    private String comment;

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String getUser() {
        return user;
    }
}
