module com.example.milkteaproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.milkteaproject to javafx.fxml;
    exports com.example.milkteaproject;
}