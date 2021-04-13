package models.products.soldOut;

import java.util.Date;
import java.util.List;

public class SoldOut {
    private int price;
    private int ratings;
    private int stock;
    private int numOfReviews;
    private String _id;
    private String name;
    private String description;
    private List<Image> images;
    private String category;
    private String seller;
    private List<Review> reviews;
    private Date createdAt;
    private int __v;

    public String get_id() {
        return _id;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public int getNumOfReviews() {
        return numOfReviews;
    }

    public int getRatings() {
        return ratings;
    }

    public int getStock() {
        return stock;
    }

    public List<Image> getImages() {
        return images;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public String getSeller() {
        return seller;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

}
