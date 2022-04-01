package fr.hugobaras;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class ComptableController {
    @FXML
    private CheckBox checkbox1;

    @FXML
    private CheckBox checkbox2;

    @FXML
    private CheckBox checkbox3;

    @FXML
    private ComboBox<String> comb;

    @FXML
    private ComboBox<String> comb1;

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
    private Label txt_qu_km;

    @FXML
    private Label txt_qu_nui;

    @FXML
    private Label txt_qu_repas;
    @FXML
    private Label libelle1;
    @FXML
    private Label libelle2;

    @FXML
    private Label libelle3;

    @FXML
    private Label montant1;

    @FXML
    private Label montant2;

    @FXML
    private Label montant3;

    @FXML
    private Label Date1;

    @FXML
    private Label Date2;

    @FXML
    private Label Date3;

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
        try {

            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement instruction = con.createStatement();
            ResultSet resultat = instruction.executeQuery("SELECT * FROM fraisforfait WHERE id = 'NUI'");
            while (resultat.next()) {
                int total_montant = resultat.getInt("ff_montant");
                String total_montant2 = Integer.toString(total_montant);
                txt_mu_nuit.setText(total_montant2);
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
                txt_mu_Repas.setText(total_montant2);
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
                txt_mu_km.setText(total_montant2);
                Common.mu_km = total_montant;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement instruction = con.createStatement();
            String requete = "SELECT ag_MATRICULE FROM agents WHERE ta_fk = '1'";
            ResultSet resultat = instruction.executeQuery(requete);
            while (resultat.next()) {
                String recup_mat = resultat.getString("ag_MATRICULE");
                comb.getItems().add(recup_mat);

            }
            resultat.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
    // txt_nom.setText(Common.nom + " " + Common.prenom);

    @FXML
    void combobox(ActionEvent event) {
        String date = new SimpleDateFormat("yyyy/MM").format(Calendar.getInstance().getTime());
        String mat_visiteur = comb.getSelectionModel().getSelectedItem();
        System.out.println(mat_visiteur);

        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {

            try {
                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                ResultSet resultat = instruction.executeQuery(
                        "SELECT id_fiche, qu_nuitee, qu_repas, qu_km FROM fiche WHERE date = '" + date
                                + "' and fk_matricule = '" + mat_visiteur + "'");
                while (resultat.next()) {
                    int id_fiche = resultat.getInt("id_fiche");
                    Common.id_fiche = id_fiche;
                    String qu_nuitee = resultat.getString("qu_nuitee");
                    String qu_repas = resultat.getString("qu_repas");
                    String qu_km = resultat.getString("qu_km");
                    txt_qu_nui.setText(qu_nuitee);
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
                    total_Repas.setText(qu_repas3);
                    total_km.setText(qu_km3);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            try {
                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                ResultSet resultat = instruction.executeQuery(
                        "SELECT af_date, af_libellé, af_montant FROM autresfrais WHERE fk_fiche = '" + Common.id_fiche
                                + "' ");
                if (resultat.next()) {
                    montant1.setText(resultat.getString("af_montant"));
                    Date1.setText(resultat.getString("af_date"));
                    libelle1.setText(resultat.getString("af_libellé"));
                }
                if (resultat.next()) {
                    montant2.setText(resultat.getString("af_montant"));
                    Date2.setText(resultat.getString("af_date"));
                    libelle2.setText(resultat.getString("af_libellé"));
                }
                if (resultat.next()) {
                    montant3.setText(resultat.getString("af_montant"));
                    Date3.setText(resultat.getString("af_date"));
                    libelle3.setText(resultat.getString("af_libellé"));

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

    @FXML
    void checkbox1(ActionEvent event) {
        if (checkbox1.isSelected()) {
            Common.etatfiche1 = 1;
        } else {
            Common.etatfiche1 = 2;
        }
    }

    @FXML
    void checkbox2(ActionEvent event) {
        if (checkbox1.isSelected()) {
            Common.etatfiche2 = 1;
        } else {
            Common.etatfiche2 = 2;
        }
    }

    @FXML
    void checkbox3(ActionEvent event) {
        if (checkbox1.isSelected()) {
            Common.etatfiche3 = 1;
        } else {
            Common.etatfiche3 = 2;
        }
    }

    @FXML
    void valider(ActionEvent event) {
        String date = new SimpleDateFormat("yyyy/MM").format(Calendar.getInstance().getTime());
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            try {
                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                // String requete = "SELECT date FROM fiche WHERE fk_nom = '" + Common.nom + "'
                // and fk_prenom = '" + Common.prenom + "'";
                String requete = "SELECT date FROM fiche  WHERE fk_matricule = '" + Common.matricule + "' ";
                ResultSet resultat = instruction.executeQuery(requete);
                while (resultat.next()) {
                    String recupdate = resultat.getString("date");
                    Common.recupdate = recupdate;
                }
                resultat.close();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
            if (date == Common.recupdate) {
                try {
                    Connection con = DriverManager.getConnection(dbURL, username, password);
                    Statement instruction = con.createStatement();
                    String st = "UPDATE fiche SET qu_nuitee = '" + Common.nuit
                            + "', qu_repas = '" + Common.repas
                            + "', qu_km = '" + Common.km
                            + "' WHERE fk_matricule = '" + Common.matricule
                            + "'and date = '" + date + "'";
                    // System.out.println(st);
                    instruction.executeUpdate(st);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                try {
                    Connection con = DriverManager.getConnection(dbURL, username, password);
                    Statement instruction = con.createStatement();
                    String st = "INSERT INTO fiche (fk_matricule, qu_nuitee, qu_repas, qu_km, date) VALUES ('" +
                            Common.matricule + "','" +
                            Common.nuit + "','" +
                            Common.repas + "','" +
                            Common.km + "','" +
                            date + "')";
                    // System.out.println(st);
                    instruction.executeUpdate(st);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
