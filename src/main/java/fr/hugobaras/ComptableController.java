package fr.hugobaras;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class ComptableController {

    @FXML
    private ComboBox<String> comb;

    @FXML
    private ComboBox<String> comb1;

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
                // String requete = "SELECT date FROM fiche WHERE fk_nom = '" + Common.nom + "'
                // and fk_prenom = '" + Common.prenom + "'";
                String requete = "SELECT ag_nom, ag_prenom, ag_MATRICULE FROM agents WHERE ta_fk = '1'";
                ResultSet resultat = instruction.executeQuery(requete);
                ResultSetMetaData result = resultat.getMetaData();
                int nbCol = result.getColumnCount();
                while (resultat.next()) {
                    String recup_nom = resultat.getString("ag_nom");
                    String recup_prenom = resultat.getString("ag_prenom");
                    String recup_mat = resultat.getString("ag_MATRICULE");
                    String nom_prenom = recup_nom + ' ' + recup_prenom;
                    comb.getItems().add(nom_prenom);
                    Common.mat_visiteur = recup_mat;

                }
                resultat.close();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
            try {
                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                // String requete = "SELECT date FROM fiche WHERE fk_nom = '" + Common.nom + "'
                // and fk_prenom = '" + Common.prenom + "'";
                String requete = "SELECT date FROM fiche  WHERE fk_matricule = '" + Common.mat_visiteur + "' ";
                ResultSet resultat = instruction.executeQuery(requete);
                ResultSetMetaData result = resultat.getMetaData();
                int nbCol = result.getColumnCount();
                while (resultat.next()) {
                    String recupdate = resultat.getString("date");
                    comb1.getItems().add(recupdate);
                }
                resultat.close();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
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
        try {

            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement instruction = con.createStatement();
            ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'NUI'");
            while (resultat.next()) {
                int total_montant = resultat.getInt("ff_montant");
                String total_montant2 = Integer.toString(total_montant);
                txt_MU_Nuitee.setText(total_montant2);
                Common.mu_nuit = total_montant;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {

            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement instruction = con.createStatement();
            ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'REP'");
            while (resultat.next()) {
                int total_montant = resultat.getInt("ff_montant");
                String total_montant2 = Integer.toString(total_montant);
                txt_MU_Repas.setText(total_montant2);
                Common.mu_repas = total_montant;
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
                Common.mu_km = total_montant;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // txt_nom.setText(Common.nom + " " + Common.prenom);
    }

    @FXML
    void combobox(ActionEvent event) {
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            try {
                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                String requete = "SELECT ag_nom FROM agents";
                ResultSet resultat = instruction.executeQuery(requete);
                while (resultat.next()) {
                    String valeur1 = comb.getSelectionModel().getSelectedItem();
                    Common.valeur1 = valeur1;
                }
                resultat.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @FXML
    void combobox1(ActionEvent event) {
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            try {
                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                String requete = "SELECT date FROM fiche WHERE fk_matricule = '"+ Common.valeur1 +"'";
                ResultSet resultat = instruction.executeQuery(requete);
                while (resultat.next()) {
                    String valeur = comb.getSelectionModel().getSelectedItem();
                    Common.valeur = valeur;
                }
                resultat.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            try {
                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                ResultSet resultat = instruction.executeQuery(
                        "SELECT qu_nuitee, qu_repas, qu_km FROM fiche WHERE date = '" + Common.valeur + "'");
                while (resultat.next()) {

                    String qu_nuitee = resultat.getString("qu_nuitee");
                    String qu_repas = resultat.getString("qu_repas");
                    String qu_km = resultat.getString("qu_km");
                    txt_qu_nuit.setText(qu_nuitee);
                    txt_qu_repas.setText(qu_repas);
                    txt_qu_km.setText(qu_km);
                    int qu_nuitee2 = Integer.parseInt(qu_nuitee);
                    int qu_repas2 = Integer.parseInt(qu_repas);
                    int qu_km2 = Integer.parseInt(qu_km);
                    qu_nuitee2 = qu_nuitee2 * Common.mu_nuit;
                    qu_repas2 = qu_repas2 * Common.mu_repas;
                    qu_km2 = qu_km2 * Common.mu_km;
                    String qu_nuitee3 = Integer.toString(qu_nuitee2);
                    String qu_repas3 = Integer.toString(qu_repas2);
                    String qu_km3 = Integer.toString(qu_km2);
                    total_nuitee.setText(qu_nuitee3);
                    total_repas.setText(qu_repas3);
                    total_km.setText(qu_km3);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
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
