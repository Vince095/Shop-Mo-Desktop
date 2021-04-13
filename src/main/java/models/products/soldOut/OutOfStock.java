package models.products.soldOut;

import java.util.List;

public class OutOfStock {
    private boolean success;
    private List<SoldOut> soldOut;

    public List<SoldOut> getSoldOut() {
        return soldOut;
    }

    public boolean isSuccess() {
        return success;
    }
}
