module com.example.trabpraticosalinas {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.trabpraticosalinas to javafx.fxml;
    exports com.example.trabpraticosalinas;
}