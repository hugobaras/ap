package fr.hugobaras;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ComptableController {

    @FXML
    void deconnect(ActionEvent event) throws IOException {
        App.setRoot("authentification");
    }

    @FXML
    void consulter(ActionEvent event) throws IOException {
        App.setRoot("comptable_consult");
    }
}