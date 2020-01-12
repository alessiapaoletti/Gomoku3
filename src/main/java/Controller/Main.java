package Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        startLogin(primaryStage);
//        URL myFxmlURL = ClassLoader.getSystemResource("LoginView.fxml");
//        Parent root = FXMLLoader.load(myFxmlURL);
//        primaryStage.setTitle("Login section");
//        primaryStage.setScene(new Scene(root, 500, 450));
//        primaryStage.show();

    }

    public static void startLogin(Stage primaryStage) throws IOException {
        URL myFxmlURL = ClassLoader.getSystemResource("LoginView.fxml");
        Parent root = FXMLLoader.load(myFxmlURL);
        primaryStage.setTitle("Login section");
        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.show();
    }


    public static void main(String[] args) { launch(args);}


}
