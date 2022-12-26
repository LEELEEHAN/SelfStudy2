module com.example.selfstudy2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.selfstudy2 to javafx.fxml;
    exports com.example.selfstudy2;
}