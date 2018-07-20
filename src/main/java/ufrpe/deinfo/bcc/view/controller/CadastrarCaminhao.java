package ufrpe.deinfo.bcc.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import ufrpe.deinfo.bcc.controller.ControladorCaminhao;
import ufrpe.deinfo.bcc.model.Cliente;

import java.time.LocalDate;

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
    private ChoiceBox<Integer> AnoChoiceBox;

    @FXML
    private DatePicker ultManDatePicker;

    @FXML
    private ComboBox<Cliente> donoComboBox;

    @FXML
    private Button cadastrarBttn;

    private static MainApp mainApp;

    private static ControladorCaminhao controladorCaminhao;

    public void initialize() {
        controladorCaminhao = ControladorCaminhao.getInstance();
        mainApp = MainApp.getInstance();
    }

    @FXML
    public void cadastrarBtnPressionado(ActionEvent actionEvent) {
        String modelo = modeloTextField.getText();
        String fabricante = fabricanteTextField.getText();
        String chassi = chassiTextField.getText();
        String placa = placaTextField.getText();
        int ano = AnoChoiceBox.getValue();
        Cliente dono = donoComboBox.getValue();
        LocalDate data = ultManDatePicker.getValue();

        if(data == null)
            controladorCaminhao.criar(chassi, placa, modelo, fabricante, ano, dono);
        else
            controladorCaminhao.criar(chassi, placa, modelo, fabricante, ano, dono, data);
    }
}
