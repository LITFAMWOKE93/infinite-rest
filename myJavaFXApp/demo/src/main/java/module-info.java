module javaFXModule 
{
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens src.appPackage to javafx.fxml;
    exports src.appPackage;
}