package models.order;

public class OrderItem {
    private String _id;
    private String product;
    private String name;
    private double price;
    private String image;
    private int quantity;

    public String get_id() {
        return _id;
    }

    public String getProduct() {
        return product;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
