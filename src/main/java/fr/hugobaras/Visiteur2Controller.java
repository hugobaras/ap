package fr.hugobaras;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Visiteur2Controller {

    @FXML
    void deconnect(ActionEvent event) throws IOException {
        App.setRoot("authentification");
    }

    @FXML
    void renseigner(ActionEvent event) throws IOException {
        App.setRoot("visiteur");
    }

}
