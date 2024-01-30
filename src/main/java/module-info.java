module com.example.trabpraticosalinas {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;

    opens com.example.trabpraticosalinas to javafx.fxml;
    exports com.example.trabpraticosalinas;
}