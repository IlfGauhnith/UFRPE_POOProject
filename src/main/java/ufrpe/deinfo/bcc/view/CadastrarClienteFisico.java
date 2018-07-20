package ufrpe.deinfo.bcc.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ufrpe.deinfo.bcc.controller.ControladorCaminhao;
import ufrpe.deinfo.bcc.model.Caminhao;

import java.util.ArrayList;
import java.util.List;

public class CadastrarClienteFisico {

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

    private ControladorCaminhao controladorCaminhao;


    public void initialize() {
        tableColumnFabricante.setCellFactory(new PropertyValueFactory("Fabricante"));
        tableColumnModelo.setCellFactory(new PropertyValueFactory("Modelo"));
        tableColumnPlaca.setCellFactory(new PropertyValueFactory("Placa"));
        controladorCaminhao = ControladorCaminhao.getInstance();

        escolhaCaminhoesTable.setItems(listaTodosCaminhoes());

    }

    private ObservableList<Caminhao> listaTodosCaminhoes() {
        return FXCollections.observableArrayList(controladorCaminhao.buscarTodosCaminhoes());
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

    }

}
