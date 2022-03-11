package fr.hugobaras;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class Visiteur2Controller {
    @FXML
    private Label total_Repas;

    @FXML
    private Label total_km;

    @FXML
    private Label total_nuitee;

    @FXML
    private Label txt_mu_Repas;

    @FXML
    private Label txt_mu_km;

    @FXML
    private Label txt_mu_nuit;

    @FXML
    private Label txt_nom;

    @FXML
    private Label txt_qu_km;

    @FXML
    private Label txt_qu_nui;

    @FXML
    private Label txt_qu_repas;
    
    @FXML
    private ComboBox<?> comb;

    public void initialize() {
        txt_nom.setText(Common.nom + " " + Common.prenom);
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            try {
                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                ResultSet resultat = instruction.executeQuery("SELECT date FROM fiche");
                while (resultat.next()) {
                    String date = resultat.getString("date");
                    ObservableList<String> list = FXCollections.observableArrayList(date);
                  //  comb.setItems(list);
                
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    
    
    
    @FXML
    void combobox(ActionEvent event) {
       String s  =comb.getSelectionModel().getSelectedItem().toString();
    }

    @FXML
    void deconnect(ActionEvent event) throws IOException {
        App.setRoot("authentification");
    }

    @FXML
    void renseigner(ActionEvent event) throws IOException {
        App.setRoot("visiteur");
    }

}
