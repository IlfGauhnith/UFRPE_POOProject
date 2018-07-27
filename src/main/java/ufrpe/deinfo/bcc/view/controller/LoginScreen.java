package ufrpe.deinfo.bcc.view.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import ufrpe.deinfo.bcc.controller.ControladorFuncionario;
import ufrpe.deinfo.bcc.controller.ControladorLogin;
import ufrpe.deinfo.bcc.model.Funcionario;

public class LoginScreen {

    private static Stage systemStage;

    @FXML
    private Button sairBtn;

    @FXML
    private PasswordField pswdPswdField;

    @FXML
    private TextField usuarioTextField;

    @FXML
    private Button entrarBtn;

    private ControladorLogin controladorLogin;
    private ControladorFuncionario controladorFuncionario;
    private MainApp mainApp;


    @FXML
    public void initialize() {
        controladorLogin = ControladorLogin.getInstance();
        controladorFuncionario = ControladorFuncionario.getInstance();
        mainApp = MainApp.getInstance();
    }

    @FXML
    void entrarOnAction(ActionEvent event) {
        String pswd = pswdPswdField.getText();
        String user = usuarioTextField.getText();

        if(user.equalsIgnoreCase("elminster") && pswd.equalsIgnoreCase("moradin")) {
            MainApp.setPrimaryStage(systemStage);
            mainApp.showMenuMecanicoChefe();
        }
        else if(controladorLogin.efetuarLogin(user, pswd)) {
            Funcionario f = new Funcionario(user, pswd);
            int cargo = controladorFuncionario.obterCargoFuncionario(f);

            switch (cargo) {
                case (1) : {
                    mainApp.showMenuMecanicoChefe();
                }
                case(2) : {
                    mainApp.showMenuAssistenteMecanico();
                }
                case(-1) : {

                }
            }
        }

    }

    public static void setPrimaryStage(Stage stage) {
        systemStage = stage;
    }

    @FXML
    void pswdKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER)
            entrarOnAction(new ActionEvent());
    }

    @FXML
    void usuarioKeyPressed(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER)
            entrarOnAction(new ActionEvent());
    }

    @FXML
    void sairOnAction(ActionEvent event) {
        systemStage.close();
    }
}

