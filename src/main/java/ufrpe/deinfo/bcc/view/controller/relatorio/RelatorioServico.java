package ufrpe.deinfo.bcc.view.controller.relatorio;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Callback;
import sun.applet.Main;
import ufrpe.deinfo.bcc.controller.ControladorServico;
import ufrpe.deinfo.bcc.model.*;
import ufrpe.deinfo.bcc.view.controller.MainApp;

import java.time.LocalDate;
import java.util.List;

public class RelatorioServico {

    @FXML
    private TableView<Servico> servicoTV;

    @FXML
    private TableColumn<Servico, String> chassiTC;

    @FXML
    private TableColumn<Servico, String> placaTC;

    @FXML
    private TableColumn<Servico, Long> kilometragemTC;

    @FXML
    private TableColumn<Servico, LocalDate> entradaTC;

    @FXML
    private TableColumn<Servico, LocalDate> saidaEstimadaTC;

    @FXML
    private TableColumn<Servico, LocalDate> saidaTecTC;

    @FXML
    private TableColumn<Servico, String> nomeClienteTC;

    @FXML
    private TableColumn<Servico, String> cpfCnpjTC;

    @FXML
    private TableColumn<Servico, String> mecanicoTC;

    @FXML
    private TableColumn<Servico, Double> custoTotalTC;

    @FXML
    private TableView<Peca> pecasTV;

    @FXML
    private TableColumn<Peca, String> refPecaTC;

    @FXML
    private TableColumn<Peca, Integer> qtdPecaTC;

    @FXML
    private TableColumn<Peca, Double> precoTC;

    @FXML
    private Button confirmarbtn;

    @FXML
    private Button voltarbtn;

    @FXML
    private TextArea descTextArea;

    private static Stage systemStage;
    private static MainApp mainApp;
    private ControladorServico controladorServico;
    private static Funcionario funcionarioCorrente;

    public void initialize() {
        mainApp = MainApp.getInstance();
        controladorServico = ControladorServico.getInstance();


        //Início de configuração da tableview de serviço

        chassiTC.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Servico, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Servico, String> param) {
                return new SimpleStringProperty(param.getValue().getCaminhao().getChassi());
            }
        });

        placaTC.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Servico, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Servico, String> param) {
                return new SimpleStringProperty(param.getValue().getCaminhao().getPlaca());
            }
        });

        kilometragemTC.setCellValueFactory(new PropertyValueFactory<>("kilometragem"));
        entradaTC.setCellValueFactory(new PropertyValueFactory<>("dataEntrada"));
        saidaEstimadaTC.setCellValueFactory(new PropertyValueFactory<>("dataSaidaEstimada"));
        saidaTecTC.setCellValueFactory(new PropertyValueFactory<>("dataSaidaTecnica"));

        nomeClienteTC.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Servico, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Servico, String> param) {
                if(param.getValue().getCliente() instanceof ClienteFisico)
                    return new SimpleStringProperty(((ClienteFisico) param.getValue().getCliente()).getNome());

                else if(param.getValue().getCliente() instanceof ClienteJuridico)
                    return new SimpleStringProperty(((ClienteJuridico) param.getValue().getCliente()).getRazaoSocial());

                return null;
            }
        });

        cpfCnpjTC.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Servico, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Servico, String> param) {
                if(param.getValue().getCliente() instanceof ClienteFisico)
                    return new SimpleStringProperty(((ClienteFisico) param.getValue().getCliente()).getCpf());

                else if(param.getValue().getCliente() instanceof  ClienteJuridico)
                    return new SimpleStringProperty(((ClienteJuridico) param.getValue().getCliente()).getCnpj());

                return null;
            }
        });

        mecanicoTC.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Servico, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Servico, String> param) {
                return new SimpleStringProperty(param.getValue().getMecanicoResponsavel().getNome());
            }
        });

        custoTotalTC.setCellValueFactory(new PropertyValueFactory<>("custoTotal"));

        //Fim da configuração da tableview de serviço




        refPecaTC.setCellValueFactory(new PropertyValueFactory<>("ref"));
        qtdPecaTC.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        precoTC.setCellValueFactory(new PropertyValueFactory<>("precoUnitario"));


        List<Servico> servicoList = controladorServico.buscarTodosServicos();
        ObservableList servicoOBSL = FXCollections.observableArrayList(servicoList);
        servicoTV.setItems(servicoOBSL);
    }

    @FXML
    void confirmarOnAction(ActionEvent event) {
        voltarOnAction(new ActionEvent());
    }

    @FXML
    void voltarOnAction(ActionEvent event) {
        MainApp.setPrimaryStage(systemStage);
        MainApp.setFuncionarioCorrente(funcionarioCorrente);
        mainApp.showMenuMecanicoChefe();
//        if(funcionarioCorrente.getCargo().equals("Mecanico Chefe"))
//            mainApp.showMenuMecanicoChefe();
//        else
//            mainApp.showMenuAssistenteMecanico();
    }

    public static void setPrimaryStage(Stage stage) {systemStage = stage;}

    @FXML
    public void servicoTVMouseClicked(MouseEvent mouseEvent) {
        Servico servico = servicoTV.getSelectionModel().getSelectedItem();

        List<Peca> pecaList = servico.getRelacaoPecas();
        ObservableList pecasOBSL = FXCollections.observableArrayList(pecaList);
        pecasTV.setItems(pecasOBSL);
        descTextArea.setText(servico.getDescricaoServico());
    }

    public static Funcionario getFuncionarioCorrente() {
        return funcionarioCorrente;
    }

    public static void setFuncionarioCorrente(Funcionario funcionarioCorrente) {
        RelatorioServico.funcionarioCorrente = funcionarioCorrente;
    }
}
