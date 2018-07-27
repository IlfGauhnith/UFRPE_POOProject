package ufrpe.deinfo.bcc.view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ufrpe.deinfo.bcc.controller.ControladorCaminhao;
import ufrpe.deinfo.bcc.model.Cliente;

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
    private ComboBox<Cliente> donoComboBox;

    @FXML
    private Button cadastrarBttn;

    @FXML
    private Button voltarBttn;

    @FXML
    private TextField kilometragemTF;


    private static MainApp mainApp;

    private static ControladorCaminhao controladorCaminhao;
    private static Stage systemStage;

    public void initialize() {
        controladorCaminhao = ControladorCaminhao.getInstance();
        mainApp = MainApp.getInstance();



        List<String> listAnos = new ArrayList<>();
        for(int i = 1900 ; i <= LocalDate.now().getYear() ; i++)
            listAnos.add(Integer.toString(i));

        ObservableList<String> anosOBSL = FXCollections.observableArrayList(listAnos);
        anoComboBox.setItems(anosOBSL);
    }

    @FXML
    public void cadastrarBtnPressionado(ActionEvent actionEvent) {
        String modelo = modeloTextField.getText();
        String fabricante = fabricanteTextField.getText();
        String chassi = chassiTextField.getText();
        String placa = placaTextField.getText();
        String ano = anoComboBox.getValue();
        Cliente dono = donoComboBox.getValue();
        LocalDate data = ultManDatePicker.getValue();
        long kilometragem = Long.parseLong(kilometragemTF.getText());

        try {
            if(data == null)
                controladorCaminhao.criar(chassi, placa, modelo, fabricante, Integer.parseInt(ano),
                        dono, kilometragem);
            else
                controladorCaminhao.criar(chassi, placa, modelo, fabricante, Integer.parseInt(ano),
                        dono, data, kilometragem);

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
        mainApp.showMenuMecanicoChefe();
    }

    public static void setPrimaryStage(Stage stage) {
        systemStage = stage;
    }
}
