package ufrpe.deinfo.bcc.view.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sun.applet.Main;
import ufrpe.deinfo.bcc.controller.ControladorFuncionario;
import ufrpe.deinfo.bcc.controller.ControladorPeca;

import java.util.ArrayList;
import java.util.List;

public class CadastrarPeca {

    @FXML
    private TextField refTF;

    @FXML
    private TextField precoUnitTF;

    @FXML
    private ComboBox<Integer> qtdComboBox;

    @FXML
    private TextArea descrTA;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button confirmarBtn;

    private static Stage systemStage;
    private static MainApp mainApp;
    private static ControladorPeca controladorPeca;

    public void initialize() {
        mainApp = MainApp.getInstance();
        controladorPeca = ControladorPeca.getInstance();

        List<Integer> qtdList = new ArrayList<>();

        for(int i = 0 ; i < 100 ; i++) {
            qtdList.add(i);
        }

        ObservableList<Integer> qtdOBSL = FXCollections.observableArrayList(qtdList);
        qtdComboBox.setItems(qtdOBSL);
    }

    @FXML
    void confirmarOnAction(ActionEvent event) {
        String ref = refTF.getText();
        double precoUnit = Double.parseDouble(precoUnitTF.getText());
        int qtd = qtdComboBox.getValue();
        String desc = descrTA.getText();

        try {
            controladorPeca.criar(ref, desc, precoUnit, qtd);
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
        mainApp.showMenuMecanicoChefe();
    }

    public static void setPrimaryStage(Stage stage) {systemStage = stage;}
}
