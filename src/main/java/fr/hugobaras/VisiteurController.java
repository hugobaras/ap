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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class VisiteurController {
    @FXML
    private TextField date_visiteur1;

    @FXML
    private TextField date_visiteur2;

    @FXML
    private TextField date_visiteur3;

    @FXML
    private TextField libelle_visiteur1;

    @FXML
    private TextField libelle_visiteur2;

    @FXML
    private TextField libelle_visiteur3;

    @FXML
    private TextField montant_visiteur1;

    @FXML
    private TextField montant_visiteur2;

    @FXML
    private TextField montant_visiteur3;

    @FXML
    private Label total_Repas;

    @FXML
    private Label total_km;

    @FXML
    private Label total_nuitee;

    @FXML
    private TextField txt_Qu_Nuitee;

    @FXML
    private TextField txt_Repas;

    @FXML
    private TextField txt_km;

    @FXML
    private Label txt_mu_Repas;

    @FXML
    private Label txt_mu_km;

    @FXML
    private Label txt_mu_nuit;

    @FXML
    private Label txt_nom;

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
        txt_nom.setText(Common.nom + " " + Common.prenom);
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
                    Common.nuit = montant_nuitee;
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
                    Common.repas = montant_repas;
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
                    Common.km = montant_km;
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

    @FXML
    void soumettre(ActionEvent event) {
        String date1 = date_visiteur1.getText();
        String date2 = date_visiteur2.getText();
        String date3 = date_visiteur3.getText();
        String date = new SimpleDateFormat("yyyy/MM").format(Calendar.getInstance().getTime());
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            if (Common.nuit == null) {
            } else {
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
            if (date1 == null) {
            } else {
                try {
                    Connection con = DriverManager.getConnection(dbURL, username, password);
                    Statement instruction = con.createStatement();
                    String st = "INSERT INTO autresfrais (fk_matricule, af_date, af_libellé, af_montant, date_ajout, fk_eaf) VALUES ('" +
                            Common.matricule + "','" +
                            date1 + "','" +
                            libelle_visiteur1.getText() + "','" +
                            montant_visiteur1.getText() + "','" +
                            date + "','" +
                            0 + "')";
                    instruction.executeUpdate(st);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (date2 == null) {
            } else {
                try {
                    Connection con = DriverManager.getConnection(dbURL, username, password);
                    Statement instruction = con.createStatement();
                    String st = "INSERT INTO autresfrais (fk_matricule, af_date, af_libellé, af_montant, date_ajout, fk_eaf) VALUES ('" +
                            Common.matricule + "','" +
                            date2 + "','" +
                            libelle_visiteur2.getText() + "','" +
                            montant_visiteur2.getText() + "','" +
                            date + "','" +
                            0 + "')";
                    instruction.executeUpdate(st);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (date3 == null) {
            } else {
                try {
                    Connection con = DriverManager.getConnection(dbURL, username, password);
                    Statement instruction = con.createStatement();
                    String st = "INSERT INTO autresfrais (fk_matricule, af_date, af_libellé, af_montant, date_ajout, fk_eaf) VALUES ('" +
                            Common.matricule + "','" +
                            date3 + "','" +
                            libelle_visiteur3.getText() + "','" +
                            montant_visiteur3.getText() + "','" +
                            date + "','" +
                            0 + "')";
                    instruction.executeUpdate(st);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
