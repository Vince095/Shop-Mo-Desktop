package shopmo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import models.apiRequests.Post;
import shopmo.database.ConnectToDB;

import java.io.IOException;

public class Main extends Application {
    ConnectToDB con = new ConnectToDB();
    private String url = "http://shop-mo.herokuapp.com/api/v1/login";
    private String email = "vincent_thejane1@outlook.com";
    private String password = "thejane123";

    public void login(Stage primaryStage) throws IOException {
        //con.connect();
        //post login request

        Post req = new Post();
        String json = req.userLogin(email, password);
        System.out.println(req.userLogin(email,password));
        String res = req.post(url , json);
        System.out.println(res);

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        primaryStage.setTitle("ShopMO");
        primaryStage.getIcons().add(new Image("images/favicon.ico"));
        primaryStage.setScene(new Scene(root, 640, 520));
        primaryStage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
       login(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
