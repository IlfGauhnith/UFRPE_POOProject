package ufrpe.deinfo.bcc.view.controller.cadastro;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ufrpe.deinfo.bcc.controller.ControladorCaminhao;
import ufrpe.deinfo.bcc.controller.ControladorCliente;
import ufrpe.deinfo.bcc.model.Cliente;
import ufrpe.deinfo.bcc.model.Funcionario;
import ufrpe.deinfo.bcc.view.controller.MainApp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastrarCaminhao {

    @FXML
    private TextField chassiTextField;

    @FXML
    private TextField placaTextField;

    @FXML
    private TextField fabricanteTextField;

    @FXML
    private TextField modeloTextField;

    @FXML
    private ComboBox<String> anoComboBox;

    @FXML
    private DatePicker ultManDatePicker;

    @FXML
    private ComboBox<String> donoComboBox;

    @FXML
    private Button cadastrarBttn;

    @FXML
    private Button voltarBttn;

    @FXML
    private TextField kilometragemTF;


    private static MainApp mainApp;

    private static ControladorCaminhao controladorCaminhao;
    private static ControladorCliente controladorCliente;
    private static Stage systemStage;
    private static Funcionario funcionarioCorrente;

    public void initialize() {
        controladorCaminhao = ControladorCaminhao.getInstance();
        mainApp = MainApp.getInstance();
        controladorCliente = ControladorCliente.getInstance();


        List<String> listAnos = new ArrayList<>();
        for(int i = 1900 ; i <= LocalDate.now().getYear() ; i++)
            listAnos.add(Integer.toString(i));

        ObservableList<String> anosOBSL = FXCollections.observableArrayList(listAnos);
        anoComboBox.setItems(anosOBSL);



        List<String> listClientes = new ArrayList<>();
        listClientes = controladorCliente.listarNomeClientes();

        ObservableList<String> clientesOBSL = FXCollections.observableArrayList(listClientes);
        donoComboBox.setItems(clientesOBSL);
    }

    @FXML
    public void cadastrarBtnPressionado(ActionEvent actionEvent) {
        String modelo = modeloTextField.getText();
        String fabricante = fabricanteTextField.getText();
        String chassi = chassiTextField.getText();
        String placa = placaTextField.getText();
        String ano = anoComboBox.getValue();
        String nomeDono = donoComboBox.getValue();
        LocalDate data = ultManDatePicker.getValue();
        long kilometragem = Long.parseLong(kilometragemTF.getText());

        try {
            if(data == null)
                controladorCaminhao.criar(chassi, placa, modelo, fabricante, Integer.parseInt(ano),
                        controladorCliente.buscarPorNome(nomeDono), kilometragem);
            else
                controladorCaminhao.criar(chassi, placa, modelo, fabricante, Integer.parseInt(ano),
                        controladorCliente.buscarPorNome(nomeDono), data, kilometragem);

            mainApp.showOperacaoRelizadaPopup();
            voltarBtnPressionado(new ActionEvent());
        } catch(IllegalArgumentException ex) {
            mainApp.showIllegalArgumentPopup(ex);
            return;
        }
    }

    @FXML
    void voltarBtnPressionado(ActionEvent event) {
        MainApp.setPrimaryStage(systemStage);
        MainApp.setFuncionarioCorrente(funcionarioCorrente);
        mainApp.showMenuMecanicoChefe();
    }

    public static void setPrimaryStage(Stage stage) {
        systemStage = stage;
    }

    public static void setFuncionarioCorrente(Funcionario funcionarioCorrente) {
        CadastrarCaminhao.funcionarioCorrente = funcionarioCorrente;
    }
}
