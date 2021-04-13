package models.products.all;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("_id")
    private String _id;
    @SerializedName("public_id")
    @Expose()
    private String public_id;
    @SerializedName("url")
    @Expose()
    private String url;

    public String getImage_id() {
        return _id;
    }

    public String getPublic_id() {
        return public_id;
    }

    public String getImageUrl() {
        return url;
    }
}
