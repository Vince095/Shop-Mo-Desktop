package models.products.all;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Products {
    @SerializedName("success")
    @Expose()
    private boolean success;
    @SerializedName("productsCount")
    @Expose()
    private int productsCount;
    @SerializedName("resPerPage")
    @Expose()
    private int resPerPage;
    @SerializedName("filteredProductsCount")
    @Expose()
    private int filteredProductsCount;
    @SerializedName("products")
    @Expose()
    private List<Product> products;

    public List<Product> getProductsList() {
        return products;
    }

    public int getFilteredProductsCount() {
        return filteredProductsCount;
    }

    public int getProductsCount() {
        return productsCount;
    }

    public int getResPerPage() {
        return resPerPage;
    }

}
