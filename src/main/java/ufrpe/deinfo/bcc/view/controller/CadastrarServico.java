package ufrpe.deinfo.bcc.view.controller;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import ufrpe.deinfo.bcc.controller.*;
import ufrpe.deinfo.bcc.model.Caminhao;
import ufrpe.deinfo.bcc.model.Cliente;
import ufrpe.deinfo.bcc.model.Funcionario;
import ufrpe.deinfo.bcc.model.Peca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CadastrarServico {

    @FXML
    private ComboBox<String> caminhaoComboBox;

    @FXML
    private Text clienteRelacionadoTxt;

    @FXML
    private ComboBox<String> mecanicoComboBox;

    @FXML
    private TextField kilometragemTF;

    @FXML
    private DatePicker dataEntradaDatePicker;

    @FXML
    private DatePicker saindaEstimDatePicker;

    @FXML
    private TextArea descTA;

    @FXML
    private TableView<Peca> pecasDisponiveisTV;

    @FXML
    private TableColumn<Peca, String> refPecaDispTC;

    @FXML
    private TableColumn<Peca, Double> precoPecaDispTC;

    @FXML
    private TableColumn<Peca, Integer> estoqPecaDispTC;

    @FXML
    private TableView<Peca> pecasSelecionadasTV;

    @FXML
    private TableColumn<Peca, String> refPecaSelecTC;

    @FXML
    private TableColumn<Peca, Double> precoPecaSelecTC;

    @FXML
    private TableColumn<Peca, Integer> estoqPecaSelecTC;

    @FXML
    private Button removerBtn;

    @FXML
    private Button adicionarBtn;

    @FXML
    private Text custoTotaltxt;

    @FXML
    private Button voltarBtn;

    @FXML
    private Button confirmarBtn;

    @FXML
    private ComboBox<Integer> qtdAadcComboBox;

    private static Stage systemStage;
    private static ControladorPeca controladorPeca;
    private static ControladorCaminhao controladorCaminhao;
    private static ControladorCliente controladorCliente;
    private static ControladorFuncionario controladorFuncionario;
    private static ControladorServico controladorServico;
    private static MainApp mainApp;
    private static List<Peca> pecasSelecionadas;
    private static double custoTotal;

    public void initialize() {
        controladorPeca = ControladorPeca.getInstance();
        controladorCaminhao = ControladorCaminhao.getInstance();
        controladorCliente = ControladorCliente.getInstance();
        controladorFuncionario = ControladorFuncionario.getInstance();
        controladorCliente = ControladorCliente.getInstance();
        controladorServico = ControladorServico.getInstance();
        custoTotal = 0;

        mainApp = MainApp.getInstance();
        pecasSelecionadas = new ArrayList<>();




        refPecaDispTC.setCellValueFactory(new PropertyValueFactory<>("ref"));
        refPecaSelecTC.setCellValueFactory(new PropertyValueFactory<>("ref"));

        precoPecaDispTC.setCellValueFactory(new PropertyValueFactory<>("precoUnitario"));
        precoPecaSelecTC.setCellValueFactory(new PropertyValueFactory<>("precoUnitario"));

        estoqPecaDispTC.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        estoqPecaSelecTC.setCellValueFactory(new PropertyValueFactory<>("quantidade"));



        List<String> chassisList;
        chassisList = controladorCaminhao.listarChassis();

        ObservableList<String> chassisOBSL = FXCollections.observableArrayList(chassisList);
        caminhaoComboBox.setItems(chassisOBSL);




        List<String> mecanicoList;
        mecanicoList = controladorFuncionario.listarNomesPorCargo(controladorFuncionario.getCargoMecanicoChefe());

        ObservableList<String> mecanicoOBSL = FXCollections.observableArrayList(mecanicoList);
        mecanicoComboBox.setItems(mecanicoOBSL);




        List<Peca> pecaList;
        pecaList = controladorPeca.buscarTodasPecas();

        ObservableList<Peca> pecasOBSL = FXCollections.observableArrayList(pecaList);
        pecasDisponiveisTV.setItems(pecasOBSL);



        List<Peca> pecaListSelec = new ArrayList<>();

        ObservableList<Peca> pecasSelecOBSL = FXCollections.observableArrayList(pecaListSelec);
        pecasSelecionadasTV.setItems(pecasSelecOBSL);
    }

    @FXML
    void adicionarOnAction(ActionEvent event) {
        ObservableList<Peca> pecasSelecOBSL = pecasSelecionadasTV.getItems();
        Peca pecaSelected = pecasDisponiveisTV.getSelectionModel().getSelectedItem();

        pecasSelecOBSL.add(new Peca(pecaSelected.getRef(), pecaSelected.getDescricao(), pecaSelected.getPrecoUnitario(),
                qtdAadcComboBox.getValue()));
        controladorPeca.removerDoEstoque(pecaSelected, qtdAadcComboBox.getValue());
        pecasSelecionadas.add(pecaSelected);

        custoTotal = custoTotal + (pecaSelected.getPrecoUnitario()*qtdAadcComboBox.getValue());
        custoTotaltxt.setText(Double.toString(custoTotal));
    }

    @FXML
    void confirmarOnAction(ActionEvent event) {
        String chassi = caminhaoComboBox.getValue();
        String mecanico = mecanicoComboBox.getValue();
        String descricao = descTA.getText();

        Caminhao caminhao = controladorCaminhao.buscarPorChassi(chassi);
        Funcionario funcionario = controladorFuncionario.buscarPorNome(mecanico);
        long kilometragem = Long.parseLong(kilometragemTF.getText());

        LocalDate dataEntrada = dataEntradaDatePicker.getValue();
        LocalDate dataEstimadaSaida = saindaEstimDatePicker.getValue();


        try {
            controladorServico.criar(dataEntrada, dataEstimadaSaida, kilometragem, descricao, caminhao,
                    controladorCaminhao.buscarDono(caminhao), funcionario);
            mainApp.showOperacaoRelizadaPopup();
            voltarOnAction(new ActionEvent());
        } catch(IllegalArgumentException ex) {
            mainApp.showIllegalArgumentPopup(ex);
            return;
        }
    }

    @FXML
    void removerOnAction(ActionEvent event) {
        ObservableList<Peca> pecasDispOBSL = pecasDisponiveisTV.getItems();
        ObservableList<Peca> pecasSelecOBSL = pecasSelecionadasTV.getItems();
        Peca pecaSelected = pecasSelecionadasTV.getSelectionModel().getSelectedItem();

        pecasSelecOBSL.remove(pecaSelected);

        int indexofSelected = pecasDispOBSL.indexOf(pecaSelected);
        pecasDispOBSL.get(indexofSelected).adicionarAoEstoque(pecaSelected.getQuantidade());
        pecasSelecionadas.remove(pecaSelected);
        custoTotal = custoTotal - (pecaSelected.getPrecoUnitario()*pecaSelected.getQuantidade());
        custoTotaltxt.setText(Double.toString(custoTotal));
    }

    @FXML
    void voltarOnAction(ActionEvent event) {
        ObservableList<Peca> pecasDispOBSL = pecasDisponiveisTV.getItems();
        ObservableList<Peca> pecasSelecOBSL = pecasSelecionadasTV.getItems();

        for(Peca p : pecasSelecOBSL) {
            int indexof = pecasDispOBSL.indexOf(p);
            pecasDispOBSL.get(indexof).adicionarAoEstoque(p.getQuantidade());
        }
        MainApp.setPrimaryStage(systemStage);
        mainApp.showMenuMecanicoChefe();
    }

    @FXML
    void pecaDispMouseClicked(MouseEvent event) {
        Peca pecaSelected = pecasDisponiveisTV.getSelectionModel().getSelectedItem();
        if(pecaSelected == null)
            return;

        List<Integer> qtdPeca = new ArrayList<>();

        for(int i = 1 ; i <= pecaSelected.getQuantidade() ; i++)
            qtdPeca.add(i);

        ObservableList qtdPecaOBSL = FXCollections.observableArrayList(qtdPeca);
        qtdAadcComboBox.setItems(qtdPecaOBSL);
    }

    @FXML
    void caminhaoComboBoxOnAction(ActionEvent event) {
        String chassi = caminhaoComboBox.getValue();
        Caminhao caminhao = controladorCaminhao.buscarPorChassi(chassi);
        String nome = controladorCliente.nomePorCaminhao(caminhao);

        clienteRelacionadoTxt.setText(nome);
    }

    public static void setPrimaryStage(Stage stage) {systemStage = stage;}
}
