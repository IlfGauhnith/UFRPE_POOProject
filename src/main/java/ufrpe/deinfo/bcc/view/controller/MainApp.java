package ufrpe.deinfo.bcc.view.controller;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;
    private Pane root;
    private static MainApp instance;

    public static MainApp getInstance() {
        if(instance == null)
            instance = new MainApp();

        return instance;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Oficina");


        showLoginScreen();
    }



    public void showMenuAssistenteMecanico() {

    }

    public void showMenuMecanicoChefe() {
        try {
            // Carrega o menuMecaninoChefe.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("menuMecanicoChefe.fxml"));
            Pane pane = loader.load();
            root.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLoginScreen() {

        String resourcePath = "/ufrpe/deinfo/bcc/view/loginScreen.fxml";
        URL location = getClass().getResource(resourcePath);
        try {
            FXMLLoader loader = new FXMLLoader(location);
            Pane pane = null;
            pane = loader.load();
            root.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}