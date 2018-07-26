package ufrpe.deinfo.bcc.view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sun.applet.Main;
import ufrpe.deinfo.bcc.controller.ControladorCaminhao;
import ufrpe.deinfo.bcc.controller.ControladorCliente;
import ufrpe.deinfo.bcc.model.Caminhao;

import java.util.ArrayList;
import java.util.List;

public class CadastrarClienteFisico {

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
    private TextField cidadeTF1;

    @FXML
    private TextField bairroTF1;

    @FXML
    private TextField logradouroTF1;

    @FXML
    private TextField complTF1;

    @FXML
    private TextField numTF11;

    @FXML
    private TableView<Caminhao> escolhaCaminhoesTable;

    @FXML
    private TableView<Caminhao> caminhoesEscolhidosTable;

    @FXML
    private Button adicionarBttn;

    @FXML
    private Button removerBttn;

    @FXML
    private Button voltarBttn;

    @FXML
    private Button cadastrarBttn;

    @FXML
    private TableColumn<Caminhao, String> tableColumnFabricante;

    @FXML
    private TableColumn<Caminhao, String> tableColumnModelo;

    @FXML
    private TableColumn<Caminhao, String> tableColumnPlaca;

    @FXML
    private TextField cepTF;

    @FXML
    private ComboBox<String> ufComboBox;

    private final String[] listaUFs = {"AC","AL","AP","AM","BA","CE","DF","ES","GO",
            "MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
    private ControladorCaminhao controladorCaminhao;
    private ControladorCliente controladorCliente;

    public void initialize() {
        mainApp = MainApp.getInstance();
        controladorCaminhao = ControladorCaminhao.getInstance();
        controladorCliente = ControladorCliente.getInstance();

        List<String> ufsList = new ArrayList<>();
        for(int i = 0 ; i < listaUFs.length ; i++)
            ufsList.add(listaUFs[i]);

        ObservableList<String> ufOBSList = FXCollections.observableArrayList(ufsList);
        ufComboBox.setItems(ufOBSList);
    }

    @FXML
    void adicionarOnAction(ActionEvent event) {
        String nome = nomeTF.getText();
        String cpf = cpfTF.getText();
        String telefone = telTF.getText();
        String email = emailTF.getText();
        String cidade = cidadeTF1.getText();
        String bairro = bairroTF1.getText();
        String logradouro = logradouroTF1.getText();
        String numero = numTF11.getText();
        String complemento = complTF1.getText();
        String cep = cepTF.getText();
        String uf = ufComboBox.getValue();

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

    public static void setPrimaryStage(Stage stage) {
        systemStage = stage;
    }

}
