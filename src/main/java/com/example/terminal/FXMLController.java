package com.example.terminal;

import com.example.terminal.config.TerminalConfig;
import javafx.fxml.Initializable;
import javafx.scene.control.TabPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class FXMLController implements Initializable {

    public TabPane tabPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TerminalConfig darkConfig = new TerminalConfig();
        darkConfig.setBackgroundColor(Color.rgb(16, 16, 16));
        darkConfig.setForegroundColor(Color.rgb(240, 240, 240));
        darkConfig.setCursorColor(Color.rgb(255, 0, 0, 0.5));

        TerminalConfig cygwinConfig = new TerminalConfig();
        cygwinConfig.setWindowsTerminalStarter("C:\\cygwin64\\bin\\bash -i");
        cygwinConfig.setFontSize(14);

        TerminalConfig defaultConfig = new TerminalConfig();

        TerminalBuilder terminalBuilder = new TerminalBuilder(defaultConfig);
        TerminalTab terminal = terminalBuilder.newTerminal();

        tabPane.getTabs().add(terminal);

    }


}
