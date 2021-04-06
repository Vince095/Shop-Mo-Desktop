package models.order;

import java.util.List;

public class AdminInfo {
    private boolean success;
    private double totalAmount;
    private List<Order> orders;

    public double getTotalAmount() {
        return totalAmount;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public boolean getSuccess() {
        return success;
    }
}
