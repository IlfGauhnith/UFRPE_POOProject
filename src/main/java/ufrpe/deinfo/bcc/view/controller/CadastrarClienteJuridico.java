package ufrpe.deinfo.bcc.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CadastrarClienteJuridico {

    private static MainApp mainApp;
    private static Stage systemStage;

    @FXML
    private TextField nomeTF;

    @FXML
    private TextField cpfTF;

    @FXML
    private TextField emailTF;

    @FXML
    private TextField telTF;

    @FXML
    private TextField nomeTF1;

    @FXML
    private TextField cpfTF1;

    @FXML
    private TextField emailTF1;

    @FXML
    private TextField telTF1;

    @FXML
    private TextField telTF11;

    @FXML
    private TextField telTF111;

    @FXML
    private TableView<?> escolhaCaminhoesTable;

    @FXML
    private TableView<?> caminhoesEscolhidosTable;

    @FXML
    private Button adicionarBttn;

    @FXML
    private Button removerBttn;

    @FXML
    private Button voltarBttn;

    @FXML
    private Button cadastrarBttn;

    public void initialize() {
        mainApp = MainApp.getInstance();
    }

    public static void setPrimaryStage(Stage stage) {
        systemStage = stage;
    }

    @FXML
    void adicionarOnAction(ActionEvent event) {

    }

    @FXML
    void cadastrarOnAction(ActionEvent event) {

    }

    @FXML
    void removerOnAction(ActionEvent event) {

    }

    @FXML
    void voltarOnAction(ActionEvent event) {
        MainApp.setPrimaryStage(systemStage);
        mainApp.showMenuMecanicoChefe();
    }

}
