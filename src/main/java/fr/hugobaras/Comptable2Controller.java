package fr.hugobaras;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class Comptable2Controller {

   @FXML
   void deconnect(ActionEvent event) throws IOException {
      App.setRoot("authentification");
   }

   @FXML
   void verifier(ActionEvent event) throws IOException {
      App.setRoot("comptable");
   }
}
