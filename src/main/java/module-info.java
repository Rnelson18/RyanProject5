module com.example.ryanproject5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;
    requires java.net.http;
    requires com.google.gson;

    opens com.example.ryanproject5 to javafx.fxml;
    exports com.example.ryanproject5;
}