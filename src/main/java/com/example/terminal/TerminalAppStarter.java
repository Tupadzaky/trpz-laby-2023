package com.example.terminal;

import com.example.terminal.helper.ThreadHelper;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.InputStream;


public class TerminalAppStarter extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        InputStream sceneStream = TerminalAppStarter.class.getResourceAsStream("/fxml/Terminal_Scene.fxml");
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(sceneStream);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(TerminalAppStarter.class.getResource("/styles/Styles.css").toExternalForm());

        stage.setTitle("Terminal");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        ThreadHelper.stopExecutorService();
        Platform.exit();
        System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
