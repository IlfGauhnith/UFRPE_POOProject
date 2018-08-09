package ufrpe.deinfo.bcc.view.controller.cadastro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import sun.applet.Main;
import ufrpe.deinfo.bcc.controller.ControladorCaminhao;
import ufrpe.deinfo.bcc.controller.ControladorCliente;
import ufrpe.deinfo.bcc.controller.ControladorEndereco;
import ufrpe.deinfo.bcc.model.Caminhao;
import ufrpe.deinfo.bcc.model.Funcionario;
import ufrpe.deinfo.bcc.view.controller.MainApp;

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
    private Button voltarBttn;

    @FXML
    private Button cadastrarBttn;

    @FXML
    private TextField cepTF;

    @FXML
    private ComboBox<String> ufComboBox;

    private final String[] listaUFs = {"AC","AL","AP","AM","BA","CE","DF","ES","GO",
            "MA","MT","MS","MG","PA","PB","PR","PE","PI","RJ","RN","RS","RO","RR","SC","SP","SE","TO"};
    private ControladorCliente controladorCliente;
    private ControladorEndereco controladorEndereco;
    private static Funcionario funcionarioCorrente;

    public void initialize() {
        mainApp = MainApp.getInstance();
        controladorCliente = ControladorCliente.getInstance();
        controladorEndereco = ControladorEndereco.getInstance();



        List<String> ufsList = new ArrayList<>();
        for(int i = 0 ; i < listaUFs.length ; i++)
            ufsList.add(listaUFs[i]);

        ObservableList<String> ufOBSList = FXCollections.observableArrayList(ufsList);
        ufComboBox.setItems(ufOBSList);
    }

    @FXML
    void cadastrarOnAction(ActionEvent event) {
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

        try {
            controladorEndereco.criarEndereco("Brasil", uf, cidade, bairro, logradouro, numero, complemento,
                    cep);
        } catch (IllegalArgumentException ex) {
            mainApp.showIllegalArgumentPopup(ex);
            return;
        }

        try {
            controladorCliente.criarClienteFisico(controladorEndereco.buscarPorCep(cep), email,
                    telefone, nome, cpf);
            mainApp.showOperacaoRelizadaPopup();
            voltarOnAction(new ActionEvent());
        } catch(IllegalArgumentException ex) {
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

    public static void setPrimaryStage(Stage stage) {
        systemStage = stage;
    }

    public static void setFuncionarioCorrente(Funcionario funcionarioCorrente) {
        CadastrarClienteFisico.funcionarioCorrente = funcionarioCorrente;
    }
}
