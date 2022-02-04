module fr.hugobaras {
    requires javafx.controls;
    requires javafx.fxml;

    opens fr.hugobaras to javafx.fxml;
    exports fr.hugobaras;
}
