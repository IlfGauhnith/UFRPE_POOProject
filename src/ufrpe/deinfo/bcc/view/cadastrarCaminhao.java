package ufrpe.deinfo.bcc.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import ufrpe.deinfo.bcc.controller.ControladorCaminhao;
import ufrpe.deinfo.bcc.model.Cliente;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class cadastrarCaminhao {

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

    private static ControladorCaminhao controladorCaminhao = ControladorCaminhao.getInstance();

    public void initialize() {
        ObservableList<Integer> anos = FXCollections.observableArrayList();

        for(int i = 1950 ; i <= 2019 ; i++)
            anos.add(i);


        AnoChoiceBox = new ChoiceBox<Integer>();
        AnoChoiceBox.setItems(anos);

        ObservableList<Cliente> clientes = FXCollections.observableArrayList();


    }

    @FXML
    public void cadastrarBtnPressionado(ActionEvent actionEvent) {
        String chassi = chassiTextField.getText();
        String placa = placaTextField.getText();
        String fabricante = fabricanteTextField.getText();
        String model = modeloTextField.getText();
        int ano = AnoChoiceBox.getValue();
        LocalDate data = ultManDatePicker.getConverter().fromString("dd-mm-yyyy");
        Cliente dono = donoComboBox.getValue();

        if(data == null)
            controladorCaminhao.criar(chassi, placa, model, fabricante, ano, dono);
        else
            controladorCaminhao.criar(chassi, placa, model, fabricante, ano, dono, data);

    }
}
