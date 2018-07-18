package ufrpe.deinfo.bcc.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;

public class System extends Application {
    private static System instance;
    private Stage primaryStage;
    private Pane rootScene;

    private void System() {

    }

    public static System getInstance() {
        if(instance == null)
            instance = new System();

        return instance;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        instance = this;
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("");
        this.rootScene = new Pane();

        Scene scene = new Scene(this.rootScene);
        this.primaryStage.setScene(scene);
        this.primaryStage.show();
        openCadastramentoCaminhaoScreen();
    }

    private void openCadastramentoCaminhaoScreen() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(System.class.getResource("cadastrarCaminhao.fxml"));
            Pane pane = loader.load();
            this.rootScene.getChildren().add(pane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
