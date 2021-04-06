package models.order;

import java.util.Date;
import java.util.List;

public class Order {
    private ShippingInfo shippingInfo;
    private PaymentInfo paymentInfo;
    private double itemsPrice;
    private double taxPrice;
    private int shippingPrice;
    private double totalPrice;
    private String orderStatus;
    private String _id;
    private List<OrderItem> orderItems;
    private Date paidAt;
    private String user;
    private Date createdAt;
    private int __v;
    private Date deliveredAt;

    public String get_id() {
        return _id;
    }

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public double getItemsPrice() {
        return itemsPrice;
    }

    public PaymentInfo getPaymentInfo() {
        return paymentInfo;
    }

    public Date getDeliveredAt() {
        return deliveredAt;
    }

    public double getTaxPrice() {
        return taxPrice;
    }

    public int getShippingPrice() {
        return shippingPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public Date getPaidAt() {
        return paidAt;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getUser() {
        return user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

}
