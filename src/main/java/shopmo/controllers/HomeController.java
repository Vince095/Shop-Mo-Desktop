package shopmo.controllers;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import models.apiRequests.Post;
import models.order.AdminInfo;
import models.user.allUsers.Users;
import shopmo.utils.Loader;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static models.StoreApi.getOrderUrl;
import static models.StoreApi.getUsersUrl;
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
    private Button dashBoardBtn;
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
                //dashBoardInfo();
                new Thread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("dashboard clicked");
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
        String res = request.getRequest(getOrderUrl(), getTokenData());
        AdminInfo data = gson.fromJson(res , AdminInfo.class);

        amount.setText("$"+ String.format("%.2f",data.getTotalAmount()));
        orderNo.setText(String.valueOf(data.getOrders().size()));

    }
    private void UsersInfo() throws IOException {

        String res = request.getRequest(getUsersUrl() , getTokenData());
        Users userData = gson.fromJson(res , Users.class);

        userNo.setText(String.valueOf(userData.getUsers().size()));


    }

}
