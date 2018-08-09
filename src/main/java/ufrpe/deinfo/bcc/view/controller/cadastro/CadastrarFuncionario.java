package ufrpe.deinfo.bcc.view.controller.cadastro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ufrpe.deinfo.bcc.controller.ControladorFuncionario;
import ufrpe.deinfo.bcc.model.Funcionario;
import ufrpe.deinfo.bcc.view.controller.MainApp;

import java.util.ArrayList;
import java.util.List;

public class CadastrarFuncionario {

    @FXML
    private TextField nomeTF;

    @FXML
    private TextField codTF;

    @FXML
    private ComboBox<String> cargoComboBox;

    @FXML
    private TextField loginTF;

    @FXML
    private TextField pswdTF;

    @FXML
    private Button confirmarBtn;

    @FXML
    private Button voltarbtn;

    private ControladorFuncionario controladorFuncionario;
    private static Stage systemStage;
    private static MainApp mainApp;
    private static Funcionario funcionarioCorrente;

    public void initialize() {
        controladorFuncionario = ControladorFuncionario.getInstance();
        mainApp = MainApp.getInstance();

        List<String> cargoList = new ArrayList<>();
        cargoList.add("Mecanico Chefe");
        cargoList.add("Mecanico Assistente");

        ObservableList<String> cargoOBSL = FXCollections.observableArrayList(cargoList);
        cargoComboBox.setItems(cargoOBSL);
    }

    @FXML
    void confirmarOnAction(ActionEvent event) {
        String nome = nomeTF.getText();
        String cod = codTF.getText();
        String cargo = cargoComboBox.getValue();
        String login = loginTF.getText();
        String senha = pswdTF.getText();

        try {
            controladorFuncionario.criar(nome, cod, cargo, login, senha);
            mainApp.showOperacaoRelizadaPopup();
            voltarOnAction(new ActionEvent());
        } catch (IllegalArgumentException ex) {
            mainApp.showIllegalArgumentPopup(ex);
            return;
        }
    }

    @FXML
    void voltarOnAction(ActionEvent event) {
        MainApp.setPrimaryStage(systemStage);
        MainApp.setFuncionarioCorrente(funcionarioCorrente);
        mainApp.showMenuMecanicoChefe();
    }

    public static void setPrimaryStage(Stage stage) {systemStage = stage;}

    public static void setFuncionarioCorrente(Funcionario funcionarioCorrente) {
        CadastrarFuncionario.funcionarioCorrente = funcionarioCorrente;
    }
}
