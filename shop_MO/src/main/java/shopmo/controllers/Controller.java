package shopmo.controllers;

import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import models.user.LoginData;
import models.apiRequests.Post;
import models.StoreApi;
import shopmo.database.ConnectToDB;
import shopmo.utils.Loader;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private static String userName;
    private static String userImage;
    private static String tokenData;
    ConnectToDB dbCon = new ConnectToDB();
    @FXML
    private Button loginBtn;
    @FXML
    private Button register;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button gotoStore;



    @FXML
    private  void handleButtonClicks(javafx.event.ActionEvent mouseEvent){
        if(mouseEvent.getSource() == register){
            System.out.println("clicked");
            loadStage("/fxml/register.fxml", "Register");
        }

        loginBtn.setOnAction(event -> {
            try {
                if(login().equals("success") ){
                  loadStage("/fxml/home.fxml", "shopMO-dashboard");
                  Stage stage = (Stage)loginBtn.getScene().getWindow();
                  stage.close();
                  System.out.println("clicked");
                }else {
                   new Loader().loadStage("/fxml/alert.fxml", "Alert");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        gotoStore.setOnAction(event ->{
            try{
                Desktop.getDesktop().browse(new URL(StoreApi.baseUrl).toURI());
            }catch(IOException | URISyntaxException e){
                e.printStackTrace();
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private String login() throws IOException {
        String status = "success";
       // dbCon.connect();
        String email = username.getText();
        String pass = password.getText();

        String loginUrl = StoreApi.getLoginUrl();
        Post request = new Post();
        Gson gson = new Gson();

        //initiate json data
        String json = request.userLogin(email, pass);
        String res = request.post(loginUrl, json);

        LoginData data = gson.fromJson(res, LoginData.class);

        //Todo: connect this getter with the home controller
        if (data.getUser() != null) {
           userName = data.getUser().getName();
           userImage = data.getUser().getAvatar().getAvatarUrl();
           tokenData = data.getToken();
        }
        System.out.println(data.getSuccess()+" logged as "+ data.getUser());

        if(email.isEmpty() || pass.isEmpty() || !data.getSuccess()){
            status = "error";
        }
        return status;
    }

    public static String getUserName() {
        return userName;
    }

    public static String getUserImage() {
        return userImage;
    }

    public static String getTokenData() {
        return tokenData;
    }

    //Window Stage handler
    private void loadStage(String fxml, String title) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle(title);
            stage.initStyle(StageStyle.DECORATED);
            stage.getIcons().add(new Image("/images/favicon.ico"));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
