/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic_tac_toe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class DashBoard implements Initializable {
    AudioClip audio = new AudioClip(this.getClass().getResource("aaa.mp3").toString());
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        audio.play();
    }

    @FXML
    private void handle_NormalLevel(ActionEvent event) {
        try {
            audio.stop();
            Parent root = FXMLLoader.load(getClass().getResource("/NormalLevel/NormalGame.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in Restart Button: " + ex);
        }

    }

    @FXML
    private void handle_HardLevel(ActionEvent event) {
        try {
            audio.stop();
            Parent root = FXMLLoader.load(getClass().getResource("/HardLevel/HardGame.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in handle_HardLevel: " + ex);
        }
    }

    @FXML
    private void handle_EasyLevel(ActionEvent event) {
        try {
            audio.stop();
            Parent root = FXMLLoader.load(getClass().getResource("/EasyLevel/EasyGame.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in easy-level Button: " + ex);
        }
    }
}
