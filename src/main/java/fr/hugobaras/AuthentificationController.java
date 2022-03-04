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
            ResultSet resultat = instruction.executeQuery("SELECT * FROM agents");

            while (resultat.next()) {

                String login = txtLogin.getText();
                String pass = new String(txtPASSWORD.getText());
                int id = resultat.getInt("ta_fk");
                if (login.equals(resultat.getString("ag_login")) && pass.equals(resultat.getString("ag_password"))) {
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
