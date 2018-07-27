package ufrpe.deinfo.bcc.view.controller;

import java.awt.*;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainApp extends Application {

    private static Stage primaryStage;
    private static Parent root;
    private static MainApp instance;

    public static MainApp getInstance() {
        if(instance == null)
            instance = new MainApp();

        return instance;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage = primaryStage;

        primaryStage.setTitle("Oficina");
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/loginScreen.fxml"));
            primaryStage.setScene(new Scene(root, 362, 126));
            LoginScreen.setPrimaryStage(primaryStage);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCadastroClienteFisico() {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/cadastro/cadastrarClienteFisico.fxml"));
            primaryStage.setScene(new Scene(this.root, 876, 529));
            CadastrarClienteFisico.setPrimaryStage(primaryStage);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCadastroClienteJuridico() {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/cadastro/cadastrarClienteJuridico.fxml"));
            primaryStage.setScene(new Scene(this.root, 876, 529));
            CadastrarClienteJuridico.setPrimaryStage(primaryStage);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMenuAssistenteMecanico() {

    }

    public void showMenuMecanicoChefe() {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/menu/menuMecanicoChefe.fxml"));
            primaryStage.setScene(new Scene(this.root, 600, 400));
            MenuMecanicoChefe.setPrimaryStage(primaryStage);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void setPrimaryStage(Stage stage) {
        primaryStage = stage;
    }


    public void showIllegalArgumentPopup(IllegalArgumentException ex) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Illegal Argument");
        alert.setHeaderText(null);
        alert.setContentText(ex.getMessage());
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(primaryStage);
        alert.showAndWait();
    }

    public void showOperacaoRelizadaPopup() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText(null);
        alert.setContentText("Operação realizada com sucesso!");
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.initOwner(primaryStage);
        alert.showAndWait();
    }

    public void showCadastroCaminhao() {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/cadastro/cadastrarCaminhao.fxml"));
            primaryStage.setScene(new Scene(this.root, 440, 351));
            CadastrarCaminhao.setPrimaryStage(primaryStage);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}