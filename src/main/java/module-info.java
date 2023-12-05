module com.example.projettp9 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.projettp9 to javafx.fxml;
    exports com.example.projettp9;
}