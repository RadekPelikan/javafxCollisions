module com.example.collisiondemo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.collisiondemo to javafx.fxml;
    exports com.example.collisiondemo;
}