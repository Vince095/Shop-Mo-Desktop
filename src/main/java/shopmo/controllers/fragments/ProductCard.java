package shopmo.controllers.fragments;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class ProductCard {

    @FXML
    private ImageView productImage;
    @FXML
    private Button detailsBtn;
    @FXML
    private Label productDetails;
    @FXML
    private Label price;
    @FXML
    private VBox vbox;

    public void setProductData(String name, String amount, Image image){

        System.out.println("loading "+ name + amount + image);
        productDetails.setText(name);
        price.setText(amount);
        productImage.setImage(image);

    }
}
