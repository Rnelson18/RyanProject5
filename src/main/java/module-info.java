module com.example.ryanproject5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires javafx.graphics;

    opens com.example.ryanproject5 to javafx.fxml;
    exports com.example.ryanproject5;
}