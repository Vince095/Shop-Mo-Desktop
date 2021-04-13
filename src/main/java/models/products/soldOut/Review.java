package models.products.soldOut;

public class Review {
    private String _id;
    private String user;
    private String name;
    private int rating;
    private String comment;

    public String getName() {
        return name;
    }

    public String get_id() {
        return _id;
    }

    public String getUser() {
        return user;
    }

    public int getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
