package shopmo.controllers;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.apiRequests.Post;
import models.order.AdminInfo;
import models.products.all.Products;
import models.products.soldOut.OutOfStock;
import models.user.allUsers.Users;
import shopmo.controllers.fragments.ProductCard;
import shopmo.utils.Loader;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static models.StoreApi.*;
import static shopmo.controllers.Controller.*;

public class HomeController implements Initializable {

    @FXML
    private Button logoutBtn;
    @FXML
    private Label user;
    @FXML
    private ImageView avatar;
    @FXML
    private Pane dashboard;
    @FXML
    private Pane productPane;
    @FXML
    private HBox cardLayout;
    @FXML
    private Button dashBoardBtn;
    @FXML
    private Button productBtn;
    @FXML
    private Label amount;
    @FXML
    private Label productNo;
    @FXML
    private Label orderNo;
    @FXML
    private Label userNo;
    @FXML
    private Label stockNo;
    @FXML
    private Label cart;

    Post request = new Post();
    Gson gson = new Gson();

    @FXML
    private void handleButtons(){
        logoutBtn.setOnAction(event -> {
            new Loader().loadStage("/fxml/login.fxml" , "login");
            Stage stage = (Stage)logoutBtn.getScene().getWindow();
            stage.close();
        });
        dashBoardBtn.setOnAction(event ->{
            try {
                dashboard.setVisible(true);
                productPane.setVisible(false);
                //dashBoardInfo();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("dashboard clicked");
        });
        productBtn.setOnAction(e -> {
            productPane.setVisible(true);
            dashboard.setVisible(false);
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources){
        user.setText(getUserName());
        Image image = new Image(getUserImage());
        if(image.isError()){
            System.out.println("An error occurred "+ getUserImage());
            image = new Image("/images/avater.png");
        }else{
            System.out.println("loaded "+ getUserImage());
        }
        try {
            dashBoardInfo();
        } catch (IOException e) {
            e.printStackTrace();
        }
        avatar.setImage(image);
    }

    private void dashBoardInfo() throws IOException {

        UsersInfo();
        try{
            productsInfo();
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stockInfo();
        String res = request.getRequest(getOrderUrl(), getTokenData());
        AdminInfo data = gson.fromJson(res , AdminInfo.class);

        amount.setText("$"+ String.format("%.2f",data.getTotalAmount()));
        orderNo.setText(String.valueOf(data.getOrders().size()));
        cart.setText(String.valueOf(data.getOrders().size()));

    }
    private void UsersInfo() throws IOException {

        String res = request.getRequest(getUsersUrl() , getTokenData());
        Users userData = gson.fromJson(res , Users.class);

        userNo.setText(String.valueOf(userData.getUsers().size()));


    }
    private void stockInfo() throws IOException {

        String res = request.getRequest(getStockUrl() , getTokenData());
        OutOfStock stock = gson.fromJson(res , OutOfStock.class);

        stockNo.setText(String.valueOf(stock.getSoldOut().size()));
    }

    private void productsInfo() throws IOException {

        String json = request.getRequest(getProductsUrl(), getTokenData());
        Products productData = gson.fromJson(json, Products.class);

        productNo.setText(String.valueOf(productData.getProductsCount()));

        try {
            for(int i =0; i<= productData.getProductsList().size(); i++){

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/fragments/productCard.fxml"));
                HBox cardBox = loader.load();
                ProductCard productCard = loader.getController();

               String product_name =  productData.getProductsList().get(i).getProductName();
               double product_amount = productData.getProductsList().get(i).getPrice();
               String product_image = productData.getProductsList().get(i).getImages().get(0).getImageUrl();

               String productValue = String.format("$" + "%.2f",product_amount);
               Image productImage = new Image(product_image);

                productCard.setProductData(product_name, productValue, productImage);
                cardLayout.getChildren().add(cardBox);
                cardLayout.setSpacing(10);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

}
