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
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


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
    private ComboBox<String> comb;

    public void initialize() {
        txt_nom.setText(Common.nom + " " + Common.prenom);
    }

    @FXML
    void combobox(MouseEvent event) {
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";
        {
            try {
                Connection con = DriverManager.getConnection(dbURL, username, password);
                Statement instruction = con.createStatement();
                String requete = "SELECT date FROM fiche";
                ResultSet resultat = instruction.executeQuery(requete);
                ResultSetMetaData result = resultat.getMetaData();
                int nbCol = result.getColumnCount();
                while (resultat.next()) {
                    String recupdate = resultat.getString("date");
                    Object[] obj = new Object[1];
                    obj[0] = recupdate;
                    comb.getItems().add(recupdate);

                }
                resultat.close();
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
    void renseigner(ActionEvent event) throws IOException {
        App.setRoot("visiteur");
    }

}
