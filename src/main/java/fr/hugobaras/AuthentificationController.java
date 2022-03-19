package fr.hugobaras;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AuthentificationController {

    @FXML
    private TextField txtLogin;

    @FXML
    private TextField txtPASSWORD;

    @FXML
    public void connexion(ActionEvent event) throws IOException {
        String dbURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "9vdkawcA_";

        try {
            Connection con = DriverManager.getConnection(dbURL, username, password);
            Statement instruction = con.createStatement();
            ResultSet resultat = instruction
                    .executeQuery("SELECT ag_login, ag_nom, ag_prenom, ta_fk, ag_password, ag_MATRICULE FROM agents");

            while (resultat.next()) {

                String login = txtLogin.getText();
                String pass = new String(txtPASSWORD.getText());
                int id = resultat.getInt("ta_fk");
                String nom = resultat.getString("ag_nom");
                String prenom = resultat.getString("ag_prenom");
                int matricule = resultat.getInt("ag_MATRICULE");

                if (login.equals(resultat.getString("ag_login")) && pass.equals(resultat.getString("ag_password"))) {
                    Common.nom = nom;
                    Common.prenom = prenom;
                    Common.matricule = matricule;
                    if (id < 2) {
                        App.setRoot("visiteur");
                    } else {
                        App.setRoot("comptable");
                    }

                }

            }
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
