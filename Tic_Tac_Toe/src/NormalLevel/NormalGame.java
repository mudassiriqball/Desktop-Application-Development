/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NormalLevel;

import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author user
 */
public class NormalGame implements Initializable {

    @FXML
    private AnchorPane p1_dashBoard;
    @FXML
    private TextField player_1;
    @FXML
    private JFXComboBox<String> player_1_ComboBox;
    @FXML
    private Label p1_Sign;
    @FXML
    private AnchorPane p2_dashBoard;
    @FXML
    private TextField player_2;
    @FXML
    private JFXComboBox<String> player_2_ComboBox;
    @FXML
    private Label p2_Sign;
    @FXML
    private GridPane gridPane;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    @FXML
    private Button button5;
    @FXML
    private Button button6;
    @FXML
    private Button button7;
    @FXML
    private Button button8;
    @FXML
    private Button button9;
    @FXML
    private Button button10;
    @FXML
    private Button button11;
    @FXML
    private Button button12;
    @FXML
    private Button button13;
    @FXML
    private Button button14;
    @FXML
    private Button button15;
    @FXML
    private Button button16;
    @FXML
    private Label winner;
    @FXML
    private Label winnerAnounce;
    @FXML
    private Label drawLabel;
    @FXML
    private Label playerTurn;
    @FXML
    private GridPane restartGridPane;
    @FXML
    private AnchorPane startBtnPane;

    int count = 0;
    AudioClip audio = new AudioClip(this.getClass().getResource("Me&You.mp3").toString());

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> data = FXCollections.observableArrayList();
        data.add("O");
        data.add("X");
        data.add("T");
        data.add("F");

        player_1_ComboBox.setItems(data);
        player_2_ComboBox.setItems(data);
    }

    @FXML
    private void handle_startGameBtn(ActionEvent event) {
        audio.play();
        startBtnPane.setVisible(false);
        gridPane.setVisible(true);
        restartGridPane.setVisible(true);
        p1_dashBoard.setVisible(true);
        p2_dashBoard.setVisible(true);
    }

    @FXML
    private void handle_restartGameBtn(ActionEvent event) {
        count = 0;
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        button10.setText("");
        button11.setText("");
        button12.setText("");
        button13.setText("");
        button14.setText("");
        button15.setText("");
        button16.setText("");

        button1.setStyle("-fx-background-color: lightblue");
        button2.setStyle("-fx-background-color: lightblue");
        button3.setStyle("-fx-background-color: lightblue");
        button4.setStyle("-fx-background-color: lightblue");
        button5.setStyle("-fx-background-color: lightblue");
        button6.setStyle("-fx-background-color: lightblue");
        button7.setStyle("-fx-background-color: lightblue");
        button8.setStyle("-fx-background-color: lightblue");
        button9.setStyle("-fx-background-color: lightblue");
        button10.setStyle("-fx-background-color: lightblue");
        button11.setStyle("-fx-background-color: lightblue");
        button12.setStyle("-fx-background-color: lightblue");
        button13.setStyle("-fx-background-color: lightblue");
        button14.setStyle("-fx-background-color: lightblue");
        button15.setStyle("-fx-background-color: lightblue");
        button16.setStyle("-fx-background-color: lightblue");

        playerTurn.setText(player_1.getText() + "'s  Turn");
        playerTurn.setStyle("-fx-background-color: lime; -fx-text-fill: black");

        winner.setVisible(false);
        winnerAnounce.setVisible(false);
        drawLabel.setVisible(false);
    }

    @FXML
    private void handle_endGameBtn(ActionEvent event) {
        System.exit(-1);
    }

    @FXML
    private void handle_p1_textField(KeyEvent event) {
        player_1_ComboBox.setVisible(true);
    }

    @FXML
    private void handle_p2_textField(KeyEvent event) {
        player_2_ComboBox.setVisible(true);
    }

    @FXML
    private void handle_P1_comboBox(ActionEvent event) {
        if (player_1_ComboBox.getSelectionModel().getSelectedItem()
                != player_2_ComboBox.getSelectionModel().getSelectedItem()) {
            p1_Sign.setText(player_1_ComboBox.getSelectionModel().getSelectedItem());
            player_1_ComboBox.setDisable(true);
            p1_Sign.setVisible(true);
            p1_Sign.setStyle("-fx-background-color: lime");
            playerTurn.setText(player_1.getText() + "'s  Turn");
            playerTurn.setStyle("-fx-background-color: lime; -fx-text-fill: black");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("This Sign is selected by Player_2 (" + player_2.getText()
                    + ").\nPlease Select Someone Else.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handle_P2_comboBox(ActionEvent event) {
        if (player_1_ComboBox.getSelectionModel().getSelectedItem()
                != player_2_ComboBox.getSelectionModel().getSelectedItem()) {
            p2_Sign.setText(player_2_ComboBox.getSelectionModel().getSelectedItem());
            player_2_ComboBox.setDisable(true);
            p2_Sign.setVisible(true);
            p2_Sign.setStyle("-fx-background-color: yellow");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("This Sign is selected by Player_1 (" + player_1.getText()
                    + ").\nPlease Select Someone Else.");
            alert.showAndWait();
        }
    }

    @FXML
    private void handle_button1(ActionEvent event) {
        checkWinner(button1);
    }

    @FXML
    private void handle_button2(ActionEvent event) {
        checkWinner(button2);
    }

    @FXML
    private void handle_button3(ActionEvent event) {
        checkWinner(button3);
    }

    @FXML
    private void handle_button4(ActionEvent event) {
        checkWinner(button4);
    }

    @FXML
    private void handle_button5(ActionEvent event) {
        checkWinner(button5);
    }

    @FXML
    private void handle_button6(ActionEvent event) {
        checkWinner(button6);
    }

    @FXML
    private void handle_button7(ActionEvent event) {
        checkWinner(button7);
    }

    @FXML
    private void handle_button8(ActionEvent event) {
        checkWinner(button8);
    }

    @FXML
    private void handle_button9(ActionEvent event) {
        checkWinner(button9);
    }

    @FXML
    private void handle_button10(ActionEvent event) {
        checkWinner(button10);
    }

    @FXML
    private void handle_button11(ActionEvent event) {
        checkWinner(button11);
    }

    @FXML
    private void handle_button12(ActionEvent event) {
        checkWinner(button12);
    }

    @FXML
    private void handle_button13(ActionEvent event) {
        checkWinner(button13);
    }

    @FXML
    private void handle_button14(ActionEvent event) {
        checkWinner(button14);
    }

    @FXML
    private void handle_button15(ActionEvent event) {
        checkWinner(button15);
    }

    @FXML
    private void handle_button16(ActionEvent event) {
        checkWinner(button16);
    }

    private void checkWinner(Button button) {
        if (checkFields() == true) {
            if (count % 2 == 0) {
                if (!button.getText().equals(p1_Sign.getText()) && !button.getText().equals(p2_Sign.getText())) {
                    playerTurn.setText(player_2.getText() + "'s  Turn");
                    playerTurn.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                    button.setText(player_1_ComboBox.getSelectionModel().getSelectedItem());
                    button.setStyle("-fx-background-color: lime; -fx-text-fill: black");
                    count++;
                }
            } else {
                if (!button.getText().equals(p1_Sign.getText()) && !button.getText().equals(p2_Sign.getText())) {
                    playerTurn.setText(player_1.getText() + "'s  Turn");
                    playerTurn.setStyle("-fx-background-color: lime; -fx-text-fill: black");
                    button.setText(player_2_ComboBox.getSelectionModel().getSelectedItem());
                    button.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                    count++;
                }
            }

            // check foe winner of plyaer_1
            if (button1.getText() == button2.getText() && button2.getText() == button3.getText() && button3.getText() == button4.getText() && (button4.getText()).equals(player_1_ComboBox.getSelectionModel().getSelectedItem())
                    || button5.getText() == button6.getText() && button6.getText() == button7.getText() && button7.getText() == button8.getText() && (button8.getText()).equals(player_1_ComboBox.getSelectionModel().getSelectedItem())
                    || button9.getText() == button10.getText() && button10.getText() == button11.getText() && button11.getText() == button12.getText() && (button12.getText()).equals(player_1_ComboBox.getSelectionModel().getSelectedItem())
                    || button13.getText() == button14.getText() && button14.getText() == button15.getText() && button15.getText() == button16.getText() && (button16.getText()).equals(player_1_ComboBox.getSelectionModel().getSelectedItem())
                    || button1.getText() == button5.getText() && button5.getText() == button9.getText() && button9.getText() == button13.getText() && (button13.getText()).equals(player_1_ComboBox.getSelectionModel().getSelectedItem())
                    || button2.getText() == button6.getText() && button6.getText() == button10.getText() && button10.getText() == button14.getText() && (button14.getText()).equals(player_1_ComboBox.getSelectionModel().getSelectedItem())
                    || button3.getText() == button7.getText() && button7.getText() == button11.getText() && button11.getText() == button15.getText() && (button15.getText()).equals(player_1_ComboBox.getSelectionModel().getSelectedItem())
                    || button4.getText() == button8.getText() && button8.getText() == button12.getText() && button12.getText() == button16.getText() && (button16.getText()).equals(player_1_ComboBox.getSelectionModel().getSelectedItem())
                    || button1.getText() == button6.getText() && button6.getText() == button11.getText() && button11.getText() == button16.getText() && (button16.getText()).equals(player_1_ComboBox.getSelectionModel().getSelectedItem())
                    || button1.getText() == button7.getText() && button7.getText() == button10.getText() && button10.getText() == button13.getText() && (button13.getText()).equals(player_1_ComboBox.getSelectionModel().getSelectedItem())) {

                winner.setVisible(true);
                winner.setStyle("-fx-background-color: lime; -fx-text-fill: black");

                winnerAnounce.setVisible(true);
                winnerAnounce.setStyle("-fx-background-color: lime; -fx-text-fill: black");
                winnerAnounce.setText(player_1.getText());

                playerTurn.setText("Game Ended.");
                playerTurn.setStyle("-fx-font-size: 24");
                playerTurn.setStyle("-fx-background-color: #344E8C; -fx-text-fill: white");

//                setallBtnDisable();
            } // check foe winner of plyaer_2
            else if (button1.getText() == button2.getText() && button2.getText() == button3.getText() && button3.getText() == button4.getText() && (button4.getText()).equals(player_2_ComboBox.getSelectionModel().getSelectedItem())
                    || button5.getText() == button6.getText() && button6.getText() == button7.getText() && button7.getText() == button8.getText() && (button8.getText()).equals(player_2_ComboBox.getSelectionModel().getSelectedItem())
                    || button9.getText() == button10.getText() && button10.getText() == button11.getText() && button11.getText() == button12.getText() && (button12.getText()).equals(player_2_ComboBox.getSelectionModel().getSelectedItem())
                    || button13.getText() == button14.getText() && button14.getText() == button15.getText() && button15.getText() == button16.getText() && (button16.getText()).equals(player_2_ComboBox.getSelectionModel().getSelectedItem())
                    || button1.getText() == button5.getText() && button5.getText() == button9.getText() && button9.getText() == button13.getText() && (button13.getText()).equals(player_2_ComboBox.getSelectionModel().getSelectedItem())
                    || button2.getText() == button6.getText() && button6.getText() == button10.getText() && button10.getText() == button14.getText() && (button14.getText()).equals(player_2_ComboBox.getSelectionModel().getSelectedItem())
                    || button3.getText() == button7.getText() && button7.getText() == button11.getText() && button11.getText() == button15.getText() && (button15.getText()).equals(player_2_ComboBox.getSelectionModel().getSelectedItem())
                    || button4.getText() == button8.getText() && button8.getText() == button12.getText() && button12.getText() == button16.getText() && (button16.getText()).equals(player_2_ComboBox.getSelectionModel().getSelectedItem())
                    || button1.getText() == button6.getText() && button6.getText() == button11.getText() && button11.getText() == button16.getText() && (button16.getText()).equals(player_2_ComboBox.getSelectionModel().getSelectedItem())
                    || button1.getText() == button7.getText() && button7.getText() == button10.getText() && button10.getText() == button13.getText() && (button13.getText()).equals(player_2_ComboBox.getSelectionModel().getSelectedItem())) {

                winner.setVisible(true);
                winner.setStyle("-fx-background-color: yellow; -fx-text-fill: black");

                winnerAnounce.setVisible(true);
                winnerAnounce.setStyle("-fx-background-color: yellow; -fx-text-fill: black");
                winnerAnounce.setText(player_2.getText());

                playerTurn.setText("Game Ended.");
                playerTurn.setStyle("-fx-font-size: 24");
                playerTurn.setStyle("-fx-background-color: #344E8C; -fx-text-fill: white");

//                setallBtnDisable();
            } // Draw match:
            else if (count == 16) {
                drawLabel.setVisible(true);
            }
        }
    }

    private boolean checkFields() {
        boolean flag = true;
        if (player_1.getText().isEmpty() && player_2.getText().isEmpty()) {
            flag = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please First Enter Player_1 and Player_2 Name.");
            alert.showAndWait();
        } else if (player_1.getText().isEmpty()) {
            flag = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please First Enter the Player_1 Name.");
            alert.showAndWait();
        } else if (player_2.getText().isEmpty()) {
            flag = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please First Enter the Player_2 Name.");
            alert.showAndWait();
        } else if (!player_1.getText().isEmpty() && !player_2.getText().isEmpty()) {
            if (p1_Sign.getText().isEmpty() && p2_Sign.getText().isEmpty()) {
                flag = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Please First Select Player_1 and Player_2 Signs.");
                alert.showAndWait();
            } else if (p1_Sign.getText().isEmpty()) {
                flag = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Please First Select the Player_1 Sign.");
                alert.showAndWait();
            } else if (p2_Sign.getText().isEmpty()) {
                flag = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Please First Select the Player_2 Sign.");
                alert.showAndWait();
            }
        } else if (!player_1.getText().isEmpty() && p1_Sign.getText().isEmpty()) {
            flag = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please First Select the Player_1 Sign.");
            alert.showAndWait();
        } else if (!player_2.getText().isEmpty() && p2_Sign.getText().isEmpty()) {
            flag = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please First Select the Player_2 Sign.");
            alert.showAndWait();
        }
        return flag;
    }

    private void setallBtnDisable() {
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        button5.setDisable(true);
        button6.setDisable(true);
        button7.setDisable(true);
        button8.setDisable(true);
        button9.setDisable(true);
    }

    @FXML
    private void handle_GoBackButton(ActionEvent event) {
        try {
            audio.stop();
            Parent root = FXMLLoader.load(getClass().getResource("/tic_tac_toe/DashBoard.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in handle_GoBackButton: " + ex);
        }
    }

    @FXML
    private void handle_NextLevelButton(ActionEvent event) {
        try {
            audio.stop();
            Parent root = FXMLLoader.load(getClass().getResource("/HardLevel/HardGame.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error in handle_NextLevelButton: " + ex);
        }
    }

}
