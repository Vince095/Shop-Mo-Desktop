package models.order;

import java.util.List;

public class AdminInfo {
    private boolean success;
    private double totalAmount;
    private List<Order> orders;

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

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
