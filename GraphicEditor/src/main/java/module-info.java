module com.program.graphiceditor {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.program.graphiceditor to javafx.fxml;
    exports com.program.graphiceditor;
}