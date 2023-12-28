open module com.example.terminal {

    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.web;
    requires jdk.jsobject;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires pty4j;
    requires org.apache.commons.lang3;
    requires org.apache.commons.io;

    exports com.example.terminal;
    exports com.example.terminal.config;
    exports com.example.terminal.helper;

}
