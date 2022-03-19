package fr.hugobaras;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ComptableController {
    
    @FXML
    private TextField total_km;

    @FXML
    private TextField total_nuitee;

    @FXML
    private TextField total_repas;

    @FXML
    private TextField txt_MU_Nuitee;

    @FXML
    private TextField txt_MU_Repas;

    @FXML
    private TextField txt_MU_km;

    @FXML
    private TextField txt_qu_km;

    @FXML
    private TextField txt_qu_nuit;

    @FXML
    private TextField txt_qu_repas;
    
    public void initialize() {
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            try {

                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'NUI'");
                while (resultat.next()) {
                    int total_montant = resultat.getInt("ff_montant");
                    String total_montant2 = Integer.toString(total_montant);
                    txt_MU_Nuitee.setText(total_montant2);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        try {

            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement instruction = con.createStatement();
            ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'REP'");
            while (resultat.next()) {
                int total_montant = resultat.getInt("ff_montant");
                String total_montant2 = Integer.toString(total_montant);
                txt_MU_Repas.setText(total_montant2);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        try {

            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement instruction = con.createStatement();
            ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'KM'");
            while (resultat.next()) {
                int total_montant = resultat.getInt("ff_montant");
                String total_montant2 = Integer.toString(total_montant);
                txt_MU_km.setText(total_montant2);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
            //txt_nom.setText(Common.nom + " " + Common.prenom);
    }

    
    @FXML
    void deconnect(ActionEvent event) throws IOException {
        App.setRoot("authentification");
    }

    @FXML
    void consulter(ActionEvent event) throws IOException {
        App.setRoot("comptable_consult");
    }
}
