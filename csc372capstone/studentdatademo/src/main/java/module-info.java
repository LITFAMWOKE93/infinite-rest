module csc.cap {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    opens csc.cap to javafx.fxml;
    exports csc.cap;
}