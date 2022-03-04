package fr.hugobaras;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class VisiteurController {
    @FXML
    private Label total_nuitee;

    @FXML
    private TextField txt_Repas;

    @FXML
    private TextField txt_km;

    @FXML
    private Label txt_mu_nuit;

    @FXML
    private TextField txt_Qu_Nuitee;

    @FXML
    private Label txt_mu_Repas;

    @FXML
    private Label txt_mu_km;

    @FXML
    private Label total_Repas;

    @FXML
    private Label total_km;

    @FXML
    private TextField txt_nom;

    @FXML
    void deconnect(ActionEvent event) throws IOException {
        App.setRoot("authentification");
    }

    @FXML
    void consulter(ActionEvent event) throws IOException {
        App.setRoot("visiteur _consult");
    }

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
                    txt_mu_nuit.setText(total_montant2);
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
                txt_mu_Repas.setText(total_montant2);
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
                txt_mu_km.setText(total_montant2);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @FXML
    void txt_Qu_Nuitee(KeyEvent event) {
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
                    String montant_nuitee = txt_Qu_Nuitee.getText();
                    int montant_nuitee2 = Integer.parseInt(montant_nuitee);
                    montant_nuitee2 = montant_nuitee2 * total_montant;
                    String montant_nuitee3 = Integer.toString(montant_nuitee2);
                    total_nuitee.setText(montant_nuitee3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    void txt_Repas(KeyEvent event) {
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            try {

                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'REP'");
                while (resultat.next()) {
                    int total_montant = resultat.getInt("ff_montant");
                    String montant_repas = txt_Repas.getText();
                    int montant_repas2 = Integer.parseInt(montant_repas);
                    montant_repas2 = montant_repas2 * total_montant;
                    String montant_repas3 = Integer.toString(montant_repas2);
                    total_Repas.setText(montant_repas3);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    void txt_KM(KeyEvent event) {
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            try {

                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'KM'");
                while (resultat.next()) {
                    int total_montant = resultat.getInt("ff_montant");
                    String montant_km = txt_km.getText();
                    int montant_km2 = Integer.parseInt(montant_km);
                    montant_km2 = montant_km2 * total_montant;
                    String montant_km3 = Integer.toString(montant_km2);
                    total_km.setText(montant_km3);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}