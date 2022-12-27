module com.example.selfstudy2 {
    requires spring.context;
    requires spring.beans;


    opens com.example.selfstudy2 to javafx.fxml;
    exports com.example.selfstudy2;
}