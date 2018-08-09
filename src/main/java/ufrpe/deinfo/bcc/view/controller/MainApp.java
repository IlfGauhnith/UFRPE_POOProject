package ufrpe.deinfo.bcc.view.controller;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ufrpe.deinfo.bcc.data.DataTetsINIT;
import ufrpe.deinfo.bcc.model.Funcionario;
import ufrpe.deinfo.bcc.view.controller.cadastro.*;
import ufrpe.deinfo.bcc.view.controller.menu.MenuMecanicoAssistente;
import ufrpe.deinfo.bcc.view.controller.menu.MenuMecanicoChefe;
import ufrpe.deinfo.bcc.view.controller.relatorio.RelatorioServico;

public class MainApp extends Application {

    private static Stage primaryStage;
    private static Parent root;
    private static MainApp instance;
    private static DataTetsINIT dataInit;
    private static Funcionario funcionarioCorrente;

    public static MainApp getInstance() {
        if(instance == null)
            instance = new MainApp();

        return instance;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage = primaryStage;
        dataInit = DataTetsINIT.getInstance();
        dataInit.initData();
        primaryStage.setTitle("Oficina");
        MainApp.setPrimaryStage(primaryStage);
        showLoginScreen();
    }

    public void showLoginScreen() {
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
            primaryStage.setScene(new Scene(this.root, 461, 529));
            CadastrarClienteFisico.setPrimaryStage(primaryStage);
            CadastrarClienteFisico.setFuncionarioCorrente(funcionarioCorrente);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCadastroClienteJuridico() {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/cadastro/cadastrarClienteJuridico.fxml"));
            primaryStage.setScene(new Scene(this.root, 461, 529));
            CadastrarClienteJuridico.setPrimaryStage(primaryStage);
            CadastrarClienteJuridico.setFuncionarioCorrente(funcionarioCorrente);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMenuAssistenteMecanico() {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/menu/menuMecanicoAssistente.fxml"));
            primaryStage.setScene(new Scene(this.root, 600, 400));
            MenuMecanicoAssistente.setPrimaryStage(primaryStage);
            MenuMecanicoAssistente.setFuncionarioCorrente(funcionarioCorrente);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMenuMecanicoChefe() {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/menu/menuMecanicoChefe.fxml"));
            primaryStage.setScene(new Scene(this.root, 600, 400));
            MenuMecanicoChefe.setPrimaryStage(primaryStage);
            MenuMecanicoChefe.setFuncionarioCorrente(funcionarioCorrente);
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
            CadastrarCaminhao.setFuncionarioCorrente(funcionarioCorrente);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCadastroFuncionario() {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/cadastro/cadastrarFuncionario.fxml"));
            primaryStage.setScene(new Scene(this.root, 463, 251));
            CadastrarFuncionario.setPrimaryStage(primaryStage);
            CadastrarFuncionario.setFuncionarioCorrente(funcionarioCorrente);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCadastroPeca() {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/cadastro/cadastrarPeca.fxml"));
            primaryStage.setScene(new Scene(this.root, 458, 435));
            CadastrarPeca.setPrimaryStage(primaryStage);
            CadastrarPeca.setFuncionarioCorrente(funcionarioCorrente);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCadastroServico() {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/cadastro/cadastrarServico.fxml"));
            primaryStage.setScene(new Scene(this.root, 528, 586));
            CadastrarServico.setPrimaryStage(primaryStage);
            CadastrarServico.setFuncionarioCorrente(funcionarioCorrente);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showRelatorioServico() {
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("view/relatorio/relatorioServico.fxml"));
            primaryStage.setScene(new Scene(this.root, 1039, 539));
            RelatorioServico.setPrimaryStage(primaryStage);
            RelatorioServico.setFuncionarioCorrente(funcionarioCorrente);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Funcionario getFuncionarioCorrente() {
        return funcionarioCorrente;
    }

    public static void setFuncionarioCorrente(Funcionario funcionarioCorrente) {
        MainApp.funcionarioCorrente = funcionarioCorrente;
    }

    public static void main(String[] args) {
        launch(args);
    }
}