package ufrpe.deinfo.bcc.view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ufrpe.deinfo.bcc.controller.ControladorCliente;
import ufrpe.deinfo.bcc.controller.ControladorEndereco;

import java.util.ArrayList;
import java.util.List;

public class CadastrarClienteJuridico {

    @FXML
    private TextField RazaoSocialTF;

    @FXML
    private TextField cnpjTF;

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
    private Button voltarBttn;

    @FXML
    private Button cadastrarBttn;

    @FXML
    private TextField cepTF;

    @FXML
    private ComboBox<String> ufComboBox;

    private MainApp mainApp;
    private ControladorCliente controladorCliente;
    private ControladorEndereco controladorEndereco;
    private final String[] listaUFs = {"AC","AL","AP","AM","BA","CE","DF","ES","GO",
            "MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
    private static Stage systemStage;

    public void initialize() {
        mainApp = MainApp.getInstance();
        controladorEndereco = ControladorEndereco.getInstance();
        controladorCliente = ControladorCliente.getInstance();

        List<String> ufsList = new ArrayList<>();
        for(int i = 0 ; i < listaUFs.length ; i++)
            ufsList.add(listaUFs[i]);

        ObservableList<String> ufOBSList = FXCollections.observableArrayList(ufsList);
        ufComboBox.setItems(ufOBSList);
    }

    @FXML
    void cadastrarOnAction(ActionEvent event) {
        String razaoSocial = RazaoSocialTF.getText();
        String cnpj = cnpjTF.getText();
        String telefone = telTF.getText();
        String email = emailTF.getText();
        String cidade = cidadeTF1.getText();
        String bairro = bairroTF1.getText();
        String logradouro = logradouroTF1.getText();
        String numero = numTF11.getText();
        String complemento = complTF1.getText();
        String cep = cepTF.getText();
        String uf = ufComboBox.getValue();

        try {
            controladorEndereco.criarEndereco("Brasil", uf, cidade, bairro, logradouro, numero, complemento,
                    cep);
        } catch (IllegalArgumentException ex) {
            mainApp.showIllegalArgumentPopup(ex);
            return;
        }

        try {
            controladorCliente.criarClienteJuridico(controladorEndereco.buscarPorCep(cep), email,
                    telefone, razaoSocial, cnpj);
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
        mainApp.showMenuMecanicoChefe();
    }

    public static void setPrimaryStage(Stage stage) {
        systemStage = stage;
    }

}
