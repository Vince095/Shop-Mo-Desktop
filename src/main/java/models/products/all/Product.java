package models.products.all;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class Product extends Products {
    @SerializedName("price")
    @Expose()
    private double price;
    @SerializedName("ratings")
    @Expose()
    private double ratings;
    @SerializedName("stock")
    @Expose()
    private int stock;
    @SerializedName("numOfReviews")
    @Expose()
    private int numOfReviews;
    @SerializedName("_id")
    @Expose()
    private String _id;
    @SerializedName("name")
    @Expose()
    private String productName;
    @SerializedName("description")
    @Expose()
    private String description;
    @SerializedName("images")
    @Expose()
    private List<Image> images;
    @SerializedName("category")
    @Expose()
    private String category;
    @SerializedName("seller")
    @Expose()
    private String seller;
    @SerializedName("reviews")
    @Expose()
    private List<Review> reviews;
    @SerializedName("createdAt")
    @Expose()
    private Date createdAt;
    @SerializedName("__v")
    @Expose()
    private int __v;

    public String get_id() {
        return _id;
    }

    public int getStock() {
        return stock;
    }

    public String getProductName() {
        return productName;
    }

    public String getSeller() {
        return seller;
    }

    public int getNumOfReviews() {
        return numOfReviews;
    }

    public double getPrice() {
        return price;
    }

    public double getRatings() {
        return ratings;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Image> getImages() {
        return images;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public int get__v() {
        return __v;
    }
}
