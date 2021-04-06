package models.order;

public class PaymentInfo {
    private String id;
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public String getId() {
        return id;
    }
}
