package ufrpe.deinfo.bcc.view.controller.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import sun.applet.Main;
import ufrpe.deinfo.bcc.model.Funcionario;
import ufrpe.deinfo.bcc.view.controller.MainApp;

public class MenuMecanicoAssistente {

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

    private static Funcionario funcionarioCorrente;
    private static Stage systemStage;
    private static MainApp mainApp;

    public void initialize() {
        mainApp = MainApp.getInstance();
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
        MainApp.setPrimaryStage(systemStage);
        MainApp.setFuncionarioCorrente(funcionarioCorrente);
        mainApp.showRelatorioServico();
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

    public static void setPrimaryStage(Stage stage) {systemStage = stage;}

    public static Funcionario getFuncionarioCorrente() {
        return funcionarioCorrente;
    }

    public static void setFuncionarioCorrente(Funcionario funcionarioCorrente) {
        MenuMecanicoAssistente.funcionarioCorrente = funcionarioCorrente;
    }
}
