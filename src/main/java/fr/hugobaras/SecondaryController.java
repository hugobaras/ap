package fr.hugobaras;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SecondaryController {
   @FXML
   private Button SecondaryButton;
   @FXML
   private Label text;

   @FXML
   private void changecolor() throws IOException {
      App.setRoot("primary");

   }

}
