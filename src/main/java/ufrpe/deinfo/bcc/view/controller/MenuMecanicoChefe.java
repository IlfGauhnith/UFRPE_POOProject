package ufrpe.deinfo.bcc.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class MenuMecanicoChefe {

    private static Stage systemStage;
    private static MainApp mainApp;

    @FXML
    private MenuItem cadastrarCaminhaoMenuItem;

    @FXML
    private MenuItem cadastrarPecaMenuItem;

    @FXML
    private MenuItem cadastrarServiçoMenuItem;

    @FXML
    private MenuItem cadastrarUsuarioMenuItem;

    @FXML
    private Menu menuCliente;

    @FXML
    private MenuItem cadastrarClienteFMenuItem;

    @FXML
    private MenuItem cadastrarClienteJMenuItem;

    @FXML
    private MenuItem relatorioCaminhaoMenuItem;

    @FXML
    private MenuItem relatorioClienteMenuItem;

    @FXML
    private MenuItem relatorioPecaMenuItem;

    @FXML
    private MenuItem relatorioServicoMenuItem;

    @FXML
    private MenuItem sobreSistemaMenuItem;

    @FXML
    private MenuItem sistemaTrocarMenuItem;

    @FXML
    private MenuItem sistemaSairMenuItem;

    public void initialize() {
        mainApp = MainApp.getInstance();
    }

    public static void setPrimaryStage(Stage stage) {
        systemStage = stage;
    }

    @FXML
    void cadastrarCaminhaoOnAction(ActionEvent event) {
        MainApp.setPrimaryStage(systemStage);
        mainApp.showCadastroCaminhao();
    }

    @FXML
    void cadastrarClienteFOnAction(ActionEvent event) {
        MainApp.setPrimaryStage(systemStage);
        mainApp.showCadastroClienteFisico();
    }

    @FXML
    void cadastrarClienteJOnAction(ActionEvent event) {
        MainApp.setPrimaryStage(systemStage);
        mainApp.showCadastroClienteJuridico();
    }

    @FXML
    void cadastrarFuncionarioOnAction(ActionEvent event) {
        MainApp.setPrimaryStage(systemStage);
        mainApp.showCadastroFuncionario();
    }

    @FXML
    void cadastrarPecaOnAction(ActionEvent event) {
        MainApp.setPrimaryStage(systemStage);
        mainApp.showCadastroPeca();
    }

    @FXML
    void cadastrarServicoOnAction(ActionEvent event) {
        MainApp.setPrimaryStage(systemStage);
        mainApp.showCadastroServico();
    }

    @FXML
    void relatorioCaminhaoOnAction(ActionEvent event) {

    }

    @FXML
    void relatorioClienteOnAction(ActionEvent event) {

    }

    @FXML
    void relatorioPecaOnAction(ActionEvent event) {

    }

    @FXML
    void relatorioServicoOnAction(ActionEvent event) {

    }

    @FXML
    void sairOnAction(ActionEvent event) {
        systemStage.close();
    }

    @FXML
    void sobreSistemaOnAction(ActionEvent event) {

    }

    @FXML
    void trocarUsuarioOnAction(ActionEvent event) {
        MainApp.setPrimaryStage(systemStage);
        mainApp.showLoginScreen();
    }

}
