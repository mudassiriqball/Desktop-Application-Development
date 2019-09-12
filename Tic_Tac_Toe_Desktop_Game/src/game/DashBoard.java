package game;

import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;

/**
 *
 * @author user
 */
public class DashBoard implements Initializable {

    @FXML
    private Label dashBoardLabel;
    @FXML
    private AnchorPane firstDashBoard;
    @FXML
    private AnchorPane secondDashBoard;

    // For music:
    @FXML
    private AnchorPane musicPane;
    @FXML
    private MediaView mediaView;
    @FXML
    private MediaView smal_mediaView;
    @FXML
    private JFXToggleButton sound;
    @FXML
    private RadioButton english;
    @FXML
    private RadioButton urdu;
    @FXML
    private RadioButton punjabi;
    @FXML
    private RadioButton rap;
    @FXML
    private JFXToggleButton stopResume;
    @FXML
    private JFXToggleButton changSong;

    // For player_1 & player_2(for input name and color):
    @FXML
    private JFXTextField player1;
    @FXML
    private JFXTextField player2;
    @FXML
    private JFXColorPicker player1Color;
    @FXML
    private JFXColorPicker player2Color;
    @FXML
    private Label p1_Label; //to show player1_color;
    @FXML
    private Label p2_Label;//to show player1_color;

    // For winner (show name and color stc):
    @FXML
    private Label winnerColor;
    @FXML
    private AnchorPane winnerPane;
    @FXML
    private Label winnerLabel;

    // For Easy Level of Game:
    @FXML
    private GridPane easylGamePanel;
    @FXML
    private Button easyButton1;
    @FXML
    private Button easyButton2;
    @FXML
    private Button easyButton3;
    @FXML
    private Button easyButton4;
    @FXML
    private Button easyButton5;
    @FXML
    private Button easyButton6;
    @FXML
    private Button easyButton7;
    @FXML
    private Button easyButton8;
    @FXML
    private Button easyButton9;

    // For Normal Level of Game:
    @FXML
    private GridPane normalGamePanel;
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

    // For Hard Level of Game:
    @FXML
    private GridPane hardGamePanel;
    @FXML
    private Button hardButton1;
    @FXML
    private Button hardButton2;
    @FXML
    private Button hardButton3;
    @FXML
    private Button hardButton4;
    @FXML
    private Button hardButton6;
    @FXML
    private Button hardButton7;
    @FXML
    private Button hardButton8;
    @FXML
    private Button hardButton9;
    @FXML
    private Button hardButton11;
    @FXML
    private Button hardButton12;
    @FXML
    private Button hardButton13;
    @FXML
    private Button hardButton14;
    @FXML
    private Button hardButton16;
    @FXML
    private Button hardButton17;
    @FXML
    private Button hardButton18;
    @FXML
    private Button hardButton19;
    @FXML
    private Button hardButton5;
    @FXML
    private Button hardButton21;
    @FXML
    private Button hardButton10;
    @FXML
    private Button hardButton15;
    @FXML
    private Button hardButton20;
    @FXML
    private Button hardButton22;
    @FXML
    private Button hardButton23;
    @FXML
    private Button hardButton24;
    @FXML
    private Button hardButton25;

    //
    @FXML
    private Button goBackToGame;

    String str, str1;
    String path, path1;
    Media media, media1;
    MediaPlayer player, mPlayer1;
    AudioClip buttonSound, winnerSound, warningSound, simpleBtnSound;
    String color1, color2;
    int gameLevel = 0;
    int count = 0;
    boolean win = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonSound = new AudioClip(this.getClass().getResource("button_press.mp3").toString());
        winnerSound = new AudioClip(this.getClass().getResource("winner_sound.mp3").toString());
        warningSound = new AudioClip(this.getClass().getResource("warning_sound.wav").toString());
        simpleBtnSound = new AudioClip(this.getClass().getResource("button_sound.wav").toString());

        path = new File("src/Videos/me_you_feat.mp4").getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        player = new MediaPlayer(media);
        mediaView.setMediaPlayer(player);
        player.play();
        if (sound.isSelected()) {
            player.setMute(true);
        }

        path1 = new File("src/Videos/me_you_feat.mp4").getAbsolutePath();
        media1 = new Media(new File(path1).toURI().toString());
        mPlayer1 = new MediaPlayer(media1);
        smal_mediaView.setMediaPlayer(mPlayer1);
        mPlayer1.play();
        mPlayer1.setMute(true);
    }

    @FXML
    private void handle_EasyLevel(ActionEvent event) {
        simpleBtnSound.play();
        newGame = false;
        if (checkFields() == true) {
            if (gameLevel != 1) {
                restartGame();
            }
            gameLevel = 1;
            p1_Label.setText(player1.getText());
            p1_Label.setStyle("-fx-background-color: '" + color1 + "'; -fx-border-color: white; -fx-border-width: 5");

            p2_Label.setText(player2.getText());
            p2_Label.setStyle("-fx-background-color: '" + color2 + "'; -fx-border-color: white; -fx-border-width: 5");

            dashBoardLabel.setVisible(false);
            firstDashBoard.setVisible(false);
            musicPane.setVisible(false);

            secondDashBoard.setVisible(true);
            winnerPane.setVisible(false);

            easylGamePanel.setVisible(true);
            normalGamePanel.setVisible(false);
            hardGamePanel.setVisible(false);
        }
    }

    @FXML
    private void handle_NormalLevel(ActionEvent event) {
        simpleBtnSound.play();
        newGame = false;
        if (checkFields() == true) {
            if (gameLevel != 2) {
                restartGame();
            }
            gameLevel = 2;
            p1_Label.setText(player1.getText());
            p1_Label.setStyle("-fx-background-color: '" + color1 + "'; -fx-border-color: white; -fx-border-width: 5");

            p2_Label.setText(player2.getText());
            p2_Label.setStyle("-fx-background-color: '" + color2 + "'; -fx-border-color: white; -fx-border-width: 5");

            dashBoardLabel.setVisible(false);
            firstDashBoard.setVisible(false);
            musicPane.setVisible(false);

            secondDashBoard.setVisible(true);
            winnerPane.setVisible(false);

            easylGamePanel.setVisible(false);
            normalGamePanel.setVisible(true);
            hardGamePanel.setVisible(false);
        }
    }

    @FXML
    private void handle_HardLevel(ActionEvent event) {
        simpleBtnSound.play();
        newGame = false;
        if (checkFields() == true) {
            if (gameLevel != 3) {
                restartGame();
            }

            gameLevel = 3;
            p1_Label.setText(player1.getText());
            p1_Label.setStyle("-fx-background-color: '" + color1 + "'; -fx-border-color: white; -fx-border-width: 5");

            p2_Label.setText(player2.getText());
            p2_Label.setStyle("-fx-background-color: '" + color2 + "'; -fx-border-color: white; -fx-border-width: 5");

            dashBoardLabel.setVisible(false);
            firstDashBoard.setVisible(false);
            musicPane.setVisible(false);

            secondDashBoard.setVisible(true);
            winnerPane.setVisible(false);

            easylGamePanel.setVisible(false);
            normalGamePanel.setVisible(false);
            hardGamePanel.setVisible(true);
        }
    }

    private boolean checkFields() {
        color1 = Integer.toHexString(player1Color.getValue().hashCode()).substring(0, 6);
        color2 = Integer.toHexString(player2Color.getValue().hashCode()).substring(0, 6);

        boolean flag = true;
        if (player1.getText().isEmpty() && player2.getText().isEmpty()) {
            warningSound.play();
            flag = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please First Enter Player_1 and Player_2 Name.");
            alert.showAndWait();
        } else if (player1.getText().isEmpty()) {
            warningSound.play();
            flag = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please First Enter the Player_1 Name.");
            alert.showAndWait();
        } else if (player2.getText().isEmpty()) {
            warningSound.play();
            flag = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please First Enter the Player_2 Name.");
            alert.showAndWait();
        } else if (!player1.getText().isEmpty() && !player2.getText().isEmpty()) {
            if (color1.equals("#ffffff") && color2.equals("#ffffff")) {
                warningSound.play();
                flag = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Please First Select Player_1 and Player_2 Signs.");
                alert.showAndWait();
            } else if (color1.equals("#ffffff")) {
                warningSound.play();
                flag = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Please First Select the Player_1 Sign.");
                alert.showAndWait();
            } else if (color2.equals("#ffffff")) {
                warningSound.play();
                flag = false;
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Please First Select the Player_2 Sign.");
                alert.showAndWait();
            }
        } else if (!player1.getText().isEmpty() && color1.equals("#ffffff")) {
            warningSound.play();
            flag = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please First Select the Player_1 Sign.");
            alert.showAndWait();
        } else if (!player2.getText().isEmpty() && color2.equals("#ffffff")) {
            warningSound.play();
            flag = false;
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Please First Select the Player_2 Sign.");
            alert.showAndWait();
        }
        return flag;
    }
    boolean newGame = true;

    private void restartGame() {
        count = 0;
        winnerPane.setVisible(false);
        win = false;
        if (newGame == true) {
            String ss = player1.getText();
            player1.setText(player2.getText());
            player2.setText(ss);

            Color col = player1Color.getValue();
            player1Color.setValue(player2Color.getValue());
            player2Color.setValue(col);
            
            color1 = Integer.toHexString(player1Color.getValue().hashCode()).substring(0, 6);
            color2 = Integer.toHexString(player2Color.getValue().hashCode()).substring(0, 6);

            p1_Label.setText(player1.getText());
            p1_Label.setStyle("-fx-background-color: '" + color1 + "'; -fx-border-color: white; -fx-border-width: 5");

            p2_Label.setText(player2.getText());
            p2_Label.setStyle("-fx-background-color: '" + color2 + "'; -fx-border-color: white; -fx-border-width: 5");
        }

        switch (gameLevel) {
            case 1:
                easyButton1.setText("");
                easyButton2.setText("");
                easyButton3.setText("");
                easyButton4.setText("");
                easyButton5.setText("");
                easyButton6.setText("");
                easyButton7.setText("");
                easyButton8.setText("");
                easyButton9.setText("");
                easyButton1.setStyle("-fx-background-color: white");
                easyButton2.setStyle("-fx-background-color: white");
                easyButton3.setStyle("-fx-background-color: white");
                easyButton4.setStyle("-fx-background-color: white");
                easyButton5.setStyle("-fx-background-color: white");
                easyButton6.setStyle("-fx-background-color: white");
                easyButton7.setStyle("-fx-background-color: white");
                easyButton8.setStyle("-fx-background-color: white");
                easyButton9.setStyle("-fx-background-color: white");
                break;
            case 2:

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
                button1.setStyle("-fx-background-color: white");
                button2.setStyle("-fx-background-color: white");
                button3.setStyle("-fx-background-color: white");
                button4.setStyle("-fx-background-color: white");
                button5.setStyle("-fx-background-color: white");
                button6.setStyle("-fx-background-color: white");
                button7.setStyle("-fx-background-color: white");
                button8.setStyle("-fx-background-color: white");
                button9.setStyle("-fx-background-color: white");
                button10.setStyle("-fx-background-color: white");
                button11.setStyle("-fx-background-color: white");
                button12.setStyle("-fx-background-color: white");
                button13.setStyle("-fx-background-color: white");
                button14.setStyle("-fx-background-color: white");
                button15.setStyle("-fx-background-color: white");
                button16.setStyle("-fx-background-color: white");
                break;
            case 3:
                hardButton1.setText("");
                hardButton2.setText("");
                hardButton3.setText("");
                hardButton4.setText("");
                hardButton5.setText("");
                hardButton6.setText("");
                hardButton7.setText("");
                hardButton8.setText("");
                hardButton9.setText("");
                hardButton10.setText("");
                hardButton11.setText("");
                hardButton12.setText("");
                hardButton13.setText("");
                hardButton14.setText("");
                hardButton15.setText("");
                hardButton16.setText("");
                hardButton17.setText("");
                hardButton18.setText("");
                hardButton19.setText("");
                hardButton20.setText("");
                hardButton21.setText("");
                hardButton22.setText("");
                hardButton23.setText("");
                hardButton24.setText("");
                hardButton25.setText("");
                hardButton1.setStyle("-fx-background-color: white");
                hardButton2.setStyle("-fx-background-color: white");
                hardButton3.setStyle("-fx-background-color: white");
                hardButton4.setStyle("-fx-background-color: white");
                hardButton5.setStyle("-fx-background-color: white");
                hardButton6.setStyle("-fx-background-color: white");
                hardButton7.setStyle("-fx-background-color: white");
                hardButton8.setStyle("-fx-background-color: white");
                hardButton9.setStyle("-fx-background-color: white");
                hardButton10.setStyle("-fx-background-color: white");
                hardButton11.setStyle("-fx-background-color: white");
                hardButton12.setStyle("-fx-background-color: white");
                hardButton13.setStyle("-fx-background-color: white");
                hardButton14.setStyle("-fx-background-color: white");
                hardButton15.setStyle("-fx-background-color: white");
                hardButton16.setStyle("-fx-background-color: white");
                hardButton17.setStyle("-fx-background-color: white");
                hardButton18.setStyle("-fx-background-color: white");
                hardButton19.setStyle("-fx-background-color: white");
                hardButton20.setStyle("-fx-background-color: white");
                hardButton21.setStyle("-fx-background-color: white");
                hardButton22.setStyle("-fx-background-color: white");
                hardButton23.setStyle("-fx-background-color: white");
                hardButton24.setStyle("-fx-background-color: white");
                hardButton25.setStyle("-fx-background-color: white");
                break;
            default:
                break;
        }
    }

/////////////////////////////////////////////////////////////////////////////////
//                                                                             //
//                                                                             //
//                                                                             //
//                          Easy Lavel                                       //
//                                                                             //    
//                                                                             //
/////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void handle_easyButton1(ActionEvent event) {
        buttonSound.play();
        checkWinner(easyButton1);
    }

    @FXML
    private void handle_easyButton2(ActionEvent event) {
        buttonSound.play();
        checkWinner(easyButton2);
    }

    @FXML
    private void handle_easyButton3(ActionEvent event) {
        buttonSound.play();
        checkWinner(easyButton3);
    }

    @FXML
    private void handle_easyButton4(ActionEvent event) {
        buttonSound.play();
        checkWinner(easyButton4);
    }

    @FXML
    private void handle_easyButton5(ActionEvent event) {
        buttonSound.play();
        checkWinner(easyButton5);
    }

    @FXML
    private void handle_easyButton6(ActionEvent event) {
        buttonSound.play();
        checkWinner(easyButton6);
    }

    @FXML
    private void handle_easyButton7(ActionEvent event) {
        buttonSound.play();
        checkWinner(easyButton7);
    }

    @FXML
    private void handle_easyButton8(ActionEvent event) {
        buttonSound.play();
        checkWinner(easyButton8);
    }

    @FXML
    private void handle_easyButton9(ActionEvent event) {
        buttonSound.play();
        checkWinner(easyButton9);
    }
/////////////////////////////////////////////////////////////////////////////////
//                                                                             //
//                                                                             //
//                                                                             //
//                          Normal Lavel                                       //
//                                                                             //    
//                                                                             //
/////////////////////////////////////////////////////////////////////////////////

    @FXML
    private void handle_button1(ActionEvent event) {
        buttonSound.play();
        checkWinner(button1);
    }

    @FXML
    private void handle_button2(ActionEvent event) {
        buttonSound.play();
        checkWinner(button2);
    }

    @FXML
    private void handle_button3(ActionEvent event) {
        buttonSound.play();
        checkWinner(button3);
    }

    @FXML
    private void handle_button4(ActionEvent event) {
        buttonSound.play();
        checkWinner(button4);
    }

    @FXML
    private void handle_button5(ActionEvent event) {
        buttonSound.play();
        checkWinner(button5);
    }

    @FXML
    private void handle_button6(ActionEvent event) {
        buttonSound.play();
        checkWinner(button6);
    }

    @FXML
    private void handle_button7(ActionEvent event) {
        buttonSound.play();
        checkWinner(button7);
    }

    @FXML
    private void handle_button8(ActionEvent event) {
        buttonSound.play();
        checkWinner(button8);
    }

    @FXML
    private void handle_button9(ActionEvent event) {
        buttonSound.play();
        checkWinner(button9);
    }

    @FXML
    private void handle_button10(ActionEvent event) {
        buttonSound.play();
        checkWinner(button10);
    }

    @FXML
    private void handle_button11(ActionEvent event) {
        buttonSound.play();
        checkWinner(button11);
    }

    @FXML
    private void handle_button12(ActionEvent event) {
        buttonSound.play();
        checkWinner(button12);
    }

    @FXML
    private void handle_button13(ActionEvent event) {
        buttonSound.play();
        checkWinner(button13);
    }

    @FXML
    private void handle_button14(ActionEvent event) {
        buttonSound.play();
        checkWinner(button14);
    }

    @FXML
    private void handle_button15(ActionEvent event) {
        buttonSound.play();
        checkWinner(button15);
    }

    @FXML
    private void handle_button16(ActionEvent event) {
        buttonSound.play();
        checkWinner(button16);
    }
/////////////////////////////////////////////////////////////////////////////////
//                                                                             //
//                                                                             //
//                                                                             //
//                          Hard Lavel                                         //
//                                                                             //    
//                                                                             //
/////////////////////////////////////////////////////////////////////////////////

    @FXML
    private void handle_hardButton1(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton1);
    }

    @FXML
    private void handle_hardButton2(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton2);
    }

    @FXML
    private void handle_hardButton3(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton3);
    }

    @FXML
    private void handle_hardButton4(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton4);
    }

    @FXML
    private void handle_hardButton6(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton6);
    }

    @FXML
    private void handle_hardButton7(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton7);
    }

    @FXML
    private void handle_hardButton8(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton8);
    }

    @FXML
    private void handle_hardButton9(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton9);
    }

    @FXML
    private void handle_hardButton11(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton11);
    }

    @FXML
    private void handle_hardButton12(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton12);
    }

    @FXML
    private void handle_hardButton13(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton13);
    }

    @FXML
    private void handle_hardButton14(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton14);
    }

    @FXML
    private void handle_hardButton16(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton16);
    }

    @FXML
    private void handle_hardButton17(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton17);
    }

    @FXML
    private void handle_hardButton18(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton18);
    }

    @FXML
    private void handle_hardButton19(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton19);
    }

    @FXML
    private void handle_hardButton5(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton5);
    }

    @FXML
    private void handle_hardButton21(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton21);
    }

    @FXML
    private void handle_hardButton10(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton10);
    }

    @FXML
    private void handle_hardButton15(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton15);
    }

    @FXML
    private void handle_hardButton20(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton20);
    }

    @FXML
    private void handle_hardButton22(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton22);
    }

    @FXML
    private void handle_hardButton23(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton23);
    }

    @FXML
    private void handle_hardButton24(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton24);
    }

    @FXML
    private void handle_hardButton25(ActionEvent event) {
        buttonSound.play();
        checkWinner(hardButton25);
    }

/////////////////////////////////////////////////////////////////////////////////
//                                                                             //
//                                                                             //
//                                                                             //
//                          Check Winner                                       //
//                                                                             //    
//                                                                             //
/////////////////////////////////////////////////////////////////////////////////
    private void checkWinner(Button button) {
        if (checkFields() == true) {
            if (count % 2 == 0) {
                if (!button.getText().equals("O") && !button.getText().equals("X") && win == false) {
                    button.setText("O");
                    button.setStyle("-fx-background-color: '" + color1 + "'; -fx-text-fill: '" + color1 + "'");
                    count++;
                }
            } else {
                if (!button.getText().equals("O") && !button.getText().equals("X") && win == false) {
                    button.setText("X");
                    button.setStyle("-fx-background-color: '" + color2 + "'; -fx-text-fill: '" + color2 + "'");
                    count++;
                }
            }

            if (checkWinPlayer() == 1) {
                winnerSound.play(4);
                winnerPane.setVisible(true);
                winnerLabel.setText("Winner");
                winnerColor.setText(player1.getText());
                winnerColor.setStyle("-fx-background-color: '" + color1 + "'; -fx-text-fill: black");
                win = true;
            } else if (checkWinPlayer() == 2) {
                winnerSound.play(4);
                winnerPane.setVisible(true);
                winnerLabel.setText("Winner");
                winnerColor.setText(player2.getText());
                winnerColor.setStyle("-fx-background-color: '" + color2 + "'; -fx-text-fill: black");
                win = true;
            } // Draw match:
            else if (gameLevel == 1 && count == 9) {
                winnerPane.setVisible(true);
                winnerLabel.setText(" ");
                winnerColor.setText("Match Draw.");
                winnerColor.setStyle("-fx-background-color: white; -fx-text-fill: red");
            } else if (gameLevel == 2 && count == 16) {
                winnerPane.setVisible(true);
                winnerLabel.setText(" ");
                winnerColor.setText("Match Draw.");
                winnerColor.setStyle("-fx-background-color: white; -fx-text-fill: red");
            } else if (gameLevel == 3 && count == 25) {
                winnerPane.setVisible(true);
                winnerLabel.setText(" ");
                winnerColor.setText("Match Draw.");
                winnerColor.setStyle("-fx-background-color: white; -fx-text-fill: red");
            }
        }
    }

    private int checkWinPlayer() {
        switch (gameLevel) {
            case 1:// Check winner for Easy Level
                // Check winner of Easy Level for Player_1:
                if (easyButton1.getText().equals(easyButton2.getText()) && easyButton2.getText().equals(easyButton3.getText()) && (easyButton3.getText()).equals("O")
                        || easyButton4.getText().equals(easyButton5.getText()) && easyButton5.getText().equals(easyButton6.getText()) && (easyButton6.getText()).equals("O")
                        || easyButton7.getText().equals(easyButton8.getText()) && easyButton8.getText().equals(easyButton9.getText()) && (easyButton9.getText()).equals("O")
                        || easyButton1.getText().equals(easyButton4.getText()) && easyButton4.getText().equals(easyButton7.getText()) && (easyButton7.getText()).equals("O")
                        || easyButton2.getText().equals(easyButton5.getText()) && easyButton5.getText().equals(easyButton8.getText()) && (easyButton8.getText()).equals("O")
                        || easyButton3.getText().equals(easyButton6.getText()) && easyButton6.getText().equals(easyButton9.getText()) && (easyButton9.getText()).equals("O")
                        || easyButton1.getText().equals(easyButton5.getText()) && easyButton5.getText().equals(easyButton9.getText()) && (easyButton9.getText()).equals("O")
                        || easyButton3.getText().equals(easyButton5.getText()) && easyButton5.getText().equals(easyButton7.getText()) && (easyButton7.getText()).equals("O")) {
                    return 1;
                } // Check winner of Easy Level for Player_2:
                else if (easyButton1.getText().equals(easyButton2.getText()) && easyButton2.getText().equals(easyButton3.getText()) && (easyButton3.getText()).equals("X")
                        || easyButton4.getText().equals(easyButton5.getText()) && easyButton5.getText().equals(easyButton6.getText()) && (easyButton6.getText()).equals("X")
                        || easyButton7.getText().equals(easyButton8.getText()) && easyButton8.getText().equals(easyButton9.getText()) && (easyButton9.getText()).equals("X")
                        || easyButton1.getText().equals(easyButton4.getText()) && easyButton4.getText().equals(easyButton7.getText()) && (easyButton7.getText()).equals("X")
                        || easyButton2.getText().equals(easyButton5.getText()) && easyButton5.getText().equals(easyButton8.getText()) && (easyButton8.getText()).equals("X")
                        || easyButton3.getText().equals(easyButton6.getText()) && easyButton6.getText().equals(easyButton9.getText()) && (easyButton9.getText()).equals("X")
                        || easyButton1.getText().equals(easyButton5.getText()) && easyButton5.getText().equals(easyButton9.getText()) && (easyButton9.getText()).equals("X")
                        || easyButton3.getText().equals(easyButton5.getText()) && easyButton5.getText().equals(easyButton7.getText()) && (easyButton7.getText()).equals("X")) {
                    return 2;
                }
                break;
            case 2:// Check winner for Normal Level
                if (button1.getText().equals(button2.getText()) && button2.getText().equals(button3.getText()) && button3.getText() == button4.getText() && (button4.getText()).equals("O")
                        || button5.getText() == button6.getText() && button6.getText() == button7.getText() && button7.getText() == button8.getText() && (button8.getText()).equals("O")
                        || button9.getText() == button10.getText() && button10.getText() == button11.getText() && button11.getText() == button12.getText() && (button12.getText()).equals("O")
                        || button13.getText() == button14.getText() && button14.getText() == button15.getText() && button15.getText() == button16.getText() && (button16.getText()).equals("O")
                        || button1.getText() == button5.getText() && button5.getText() == button9.getText() && button9.getText() == button13.getText() && (button13.getText()).equals("O")
                        || button2.getText().equals(button6.getText()) && button6.getText() == button10.getText() && button10.getText() == button14.getText() && (button14.getText()).equals("O")
                        || button3.getText() == button7.getText() && button7.getText() == button11.getText() && button11.getText() == button15.getText() && (button15.getText()).equals("O")
                        || button4.getText() == button8.getText() && button8.getText() == button12.getText() && button12.getText() == button16.getText() && (button16.getText()).equals("O")
                        || button1.getText().equals(button6.getText()) && button6.getText() == button11.getText() && button11.getText() == button16.getText() && (button16.getText()).equals("O")
                        || button1.getText().equals(button7.getText()) && button7.getText() == button10.getText() && button10.getText() == button13.getText() && (button13.getText()).equals("O")) {
                    return 1;
                } // check foe winner of plyaer_2
                else if (button1.getText().equals(button2.getText()) && button2.getText().equals(button3.getText()) && button3.getText().equals(button4.getText()) && (button4.getText()).equals("X")
                        || button5.getText().equals(button6.getText()) && button6.getText().equals(button7.getText()) && button7.getText().equals(button8.getText()) && (button8.getText()).equals("X")
                        || button9.getText().equals(button10.getText()) && button10.getText().equals(button11.getText()) && button11.getText().equals(button12.getText()) && (button12.getText()).equals("X")
                        || button13.getText().equals(button14.getText()) && button14.getText().equals(button15.getText()) && button15.getText().equals(button16.getText()) && (button16.getText()).equals("X")
                        || button1.getText().equals(button5.getText()) && button5.getText().equals(button9.getText()) && button9.getText().equals(button13.getText()) && (button13.getText()).equals("X")
                        || button2.getText().equals(button6.getText()) && button6.getText().equals(button10.getText()) && button10.getText().equals(button14.getText()) && (button14.getText()).equals("X")
                        || button3.getText().equals(button7.getText()) && button7.getText().equals(button11.getText()) && button11.getText().equals(button15.getText()) && (button15.getText()).equals("X")
                        || button4.getText().equals(button8.getText()) && button8.getText().equals(button12.getText()) && button12.getText().equals(button16.getText()) && (button16.getText()).equals("X")
                        || button1.getText().equals(button6.getText()) && button6.getText().equals(button11.getText()) && button11.getText().equals(button16.getText()) && (button16.getText()).equals("X")
                        || button1.getText().equals(button7.getText()) && button7.getText().equals(button10.getText()) && button10.getText().equals(button13.getText()) && (button13.getText()).equals("X")) {
                    return 2;
                }
                break;
            case 3: // Check winner for Hard Level:
                if (hardButton1.getText() == hardButton2.getText() && hardButton2.getText() == hardButton3.getText() && hardButton3.getText() == hardButton4.getText() && hardButton4.getText() == hardButton5.getText() && (hardButton5.getText()).equals("O")
                        || hardButton6.getText() == hardButton7.getText() && hardButton7.getText() == hardButton8.getText() && hardButton8.getText() == hardButton9.getText() && hardButton9.getText() == hardButton10.getText() && (hardButton10.getText()).equals("O")
                        || hardButton11.getText() == hardButton12.getText() && hardButton12.getText() == hardButton13.getText() && hardButton13.getText() == hardButton14.getText() && hardButton14.getText() == hardButton15.getText() && (hardButton15.getText()).equals("O")
                        || hardButton16.getText() == hardButton17.getText() && hardButton17.getText() == hardButton18.getText() && hardButton18.getText() == hardButton19.getText() && hardButton19.getText() == hardButton20.getText() && (hardButton20.getText()).equals("O")
                        || hardButton21.getText() == hardButton23.getText() && hardButton22.getText() == hardButton23.getText() && hardButton23.getText() == hardButton24.getText() && hardButton24.getText() == hardButton25.getText() && (hardButton25.getText()).equals("O")
                        || hardButton1.getText() == hardButton6.getText() && hardButton6.getText() == hardButton11.getText() && hardButton11.getText() == hardButton16.getText() && hardButton16.getText() == hardButton21.getText() && (hardButton21.getText()).equals("O")
                        || hardButton2.getText() == hardButton7.getText() && hardButton7.getText() == hardButton12.getText() && hardButton12.getText() == hardButton17.getText() && hardButton17.getText() == hardButton22.getText() && (hardButton22.getText()).equals("O")
                        || hardButton3.getText() == hardButton8.getText() && hardButton8.getText() == hardButton13.getText() && hardButton13.getText() == hardButton18.getText() && hardButton18.getText() == hardButton23.getText() && (hardButton23.getText()).equals("O")
                        || hardButton4.getText() == hardButton9.getText() && hardButton9.getText() == hardButton14.getText() && hardButton14.getText() == hardButton19.getText() && hardButton19.getText() == hardButton24.getText() && (hardButton24.getText()).equals("O")
                        || hardButton5.getText() == hardButton10.getText() && hardButton10.getText() == hardButton15.getText() && hardButton15.getText() == hardButton20.getText() && hardButton20.getText() == hardButton25.getText() && (hardButton25.getText()).equals("O")
                        || hardButton1.getText() == hardButton7.getText() && hardButton7.getText() == hardButton13.getText() && hardButton13.getText() == hardButton19.getText() && hardButton19.getText() == hardButton25.getText() && (hardButton25.getText()).equals("O")
                        || hardButton5.getText() == hardButton9.getText() && hardButton9.getText() == hardButton13.getText() && hardButton13.getText() == hardButton17.getText() && hardButton17.getText() == hardButton21.getText() && (hardButton21.getText()).equals("O")) {
                    return 1;
                } // check for winner of plyaer_2
                else if (hardButton1.getText() == hardButton2.getText() && hardButton2.getText() == hardButton3.getText() && hardButton3.getText() == hardButton4.getText() && hardButton4.getText() == hardButton5.getText() && (hardButton5.getText()).equals("X")
                        || hardButton6.getText() == hardButton7.getText() && hardButton7.getText() == hardButton8.getText() && hardButton8.getText() == hardButton9.getText() && hardButton9.getText() == hardButton10.getText() && (hardButton10.getText()).equals("X")
                        || hardButton11.getText() == hardButton12.getText() && hardButton12.getText() == hardButton13.getText() && hardButton13.getText() == hardButton14.getText() && hardButton14.getText() == hardButton15.getText() && (hardButton15.getText()).equals("X")
                        || hardButton16.getText() == hardButton17.getText() && hardButton17.getText() == hardButton18.getText() && hardButton18.getText() == hardButton19.getText() && hardButton19.getText() == hardButton20.getText() && (hardButton20.getText()).equals("X")
                        || hardButton21.getText() == hardButton23.getText() && hardButton22.getText() == hardButton23.getText() && hardButton23.getText() == hardButton24.getText() && hardButton24.getText() == hardButton25.getText() && (hardButton25.getText()).equals("X")
                        || hardButton1.getText() == hardButton6.getText() && hardButton6.getText() == hardButton11.getText() && hardButton11.getText() == hardButton16.getText() && hardButton16.getText() == hardButton21.getText() && (hardButton21.getText()).equals("X")
                        || hardButton2.getText() == hardButton7.getText() && hardButton7.getText() == hardButton12.getText() && hardButton12.getText() == hardButton17.getText() && hardButton17.getText() == hardButton22.getText() && (hardButton22.getText()).equals("X")
                        || hardButton3.getText() == hardButton8.getText() && hardButton8.getText() == hardButton13.getText() && hardButton13.getText() == hardButton18.getText() && hardButton18.getText() == hardButton23.getText() && (hardButton23.getText()).equals("X")
                        || hardButton4.getText() == hardButton9.getText() && hardButton9.getText() == hardButton14.getText() && hardButton14.getText() == hardButton19.getText() && hardButton19.getText() == hardButton24.getText() && (hardButton24.getText()).equals("X")
                        || hardButton5.getText() == hardButton10.getText() && hardButton10.getText() == hardButton15.getText() && hardButton15.getText() == hardButton20.getText() && hardButton20.getText() == hardButton25.getText() && (hardButton25.getText()).equals("X")
                        || hardButton1.getText() == hardButton7.getText() && hardButton7.getText() == hardButton13.getText() && hardButton13.getText() == hardButton19.getText() && hardButton19.getText() == hardButton25.getText() && (hardButton25.getText()).equals("X")
                        || hardButton5.getText() == hardButton9.getText() && hardButton9.getText() == hardButton13.getText() && hardButton13.getText() == hardButton17.getText() && hardButton17.getText() == hardButton21.getText() && (hardButton21.getText()).equals("X")) {
                    return 2;
                }
                break;
            default:
                break;
        }
        return 0;
    }

    /////////////////////////////////////////////////////////////////////////////////
    //                                                                             //
    //                                                                             //
    //                                                                             //
    //                          Sounds                                             //
    //                                                                             //    
    //    The functions below trhis are handles all the sounds                    //
    //          and music file throug the scene builder                            //                                       //
    /////////////////////////////////////////////////////////////////////////////////
    @FXML
    private void handle_sound(ActionEvent event) {
        simpleBtnSound.play();
        if (sound.isSelected()) {
            player.setMute(true);
        } else {
            player.setMute(false);
        }
    }

    @FXML
    private void handle_stopResume(ActionEvent event) {
        simpleBtnSound.play();
        if (stopResume.isSelected()) {
            player.pause();
            mPlayer1.pause();
        } else {
            player.play();
            if (sound.isSelected()) {
                player.setMute(true);
            }
            mPlayer1.play();
            mPlayer1.setMute(true);
        }
    }

    @FXML
    private void englishSong(ActionEvent event) {
        stopResume.setSelected(false);
        simpleBtnSound.play();
        urdu.setSelected(false);
        punjabi.setSelected(false);
        rap.setSelected(false);

        str = "src/Videos/me_you_feat.mp4";
        playMedia(str);
    }

    @FXML
    private void urduSong(ActionEvent event) {
        stopResume.setSelected(false);
        simpleBtnSound.play();
        english.setSelected(false);
        punjabi.setSelected(false);
        rap.setSelected(false);

        str = "src/Videos/mery_nam_zero.mp4";
        playMedia(str);
    }

    @FXML
    private void punjabiSong(ActionEvent event) {
        stopResume.setSelected(false);
        simpleBtnSound.play();
        english.setSelected(false);
        urdu.setSelected(false);
        rap.setSelected(false);

        str = "src/Videos/kia_bat_hy.mp4";
        playMedia(str);
    }

    @FXML
    private void rapSong(ActionEvent event) {
        stopResume.setSelected(false);
        simpleBtnSound.play();
        english.setSelected(false);
        urdu.setSelected(false);
        punjabi.setSelected(false);

        str = "src/Videos/real_slim_shady.mp4";
        playMedia(str);
    }

    @FXML
    private void handle_changSong(ActionEvent event) {
        stopResume.setSelected(false);
        simpleBtnSound.play();
        if (english.isSelected()) {
            if (changSong.isSelected()) {
                str = "src/Videos/me_you_feat.mp4";
            } else {
                str = "src/Videos/me_you_feat.mp4";
            }
        } else if (urdu.isSelected()) { // Urdu
            if (changSong.isSelected()) {
                str = "src/Videos/kalabaz_dil.mp4";
            } else {
                str = "src/Videos/mery_nam_zero.mp4";
            }
        } else if (rap.isSelected()) {  // Rap
            if (changSong.isSelected()) {
                str = "src/Videos/real_slim_shady.mp4";
            } else {
                str = "src/Videos/real_slim_shady.mp4";
            }
        } else if (punjabi.isSelected()) {
            if (changSong.isSelected()) {
                str = "src/Videos/kia_bat_hy.mp4";
            } else {
                str = "src/Videos/kia_bat_hy.mp4";
            }
        } else {
            str = "src/Videos/me_you_feat.mp4";
        }
        playMedia(str);
//        playSmallMedia();
    }

    private void playMedia(String str) {
        player.stop();
        path = new File(str).getAbsolutePath();
        media = new Media(new File(path).toURI().toString());
        player = new MediaPlayer(media);
        mediaView.setMediaPlayer(player);
        player.play();
        if (sound.isSelected()) {
            player.setMute(true);
        }

        mPlayer1.stop();
        path1 = new File(str).getAbsolutePath();
        media1 = new Media(new File(path1).toURI().toString());
        mPlayer1 = new MediaPlayer(media1);
        smal_mediaView.setMediaPlayer(mPlayer1);
        mPlayer1.play();
        mPlayer1.setMute(true);
    }
//
//    private void playSmallMedia() {
//        smal_mediaView.setMediaPlayer(player);
//        player.play();if (sound.isSelected()) {player.setMute(true);}
//    }

    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////
    @FXML
    private void handle_setMusic(ActionEvent event) {
        simpleBtnSound.play();
        goBackToGame.setVisible(true);
        musicPane.setVisible(true);

        easylGamePanel.setVisible(false);
        normalGamePanel.setVisible(false);
        hardGamePanel.setVisible(false);
    }

    @FXML
    private void handle_goBack(ActionEvent event) {
        simpleBtnSound.play();
        dashBoardLabel.setVisible(true);
        firstDashBoard.setVisible(true);
        musicPane.setVisible(true);

        secondDashBoard.setVisible(false);
        easylGamePanel.setVisible(false);
        normalGamePanel.setVisible(false);
        hardGamePanel.setVisible(false);
    }

    @FXML
    private void handleRestartGame(ActionEvent event) {
        simpleBtnSound.play();
        newGame = true;
        restartGame();
    }

    @FXML
    private void handle_goBackToGame(ActionEvent event) {
        simpleBtnSound.play();
        goBackToGame.setVisible(false);
        musicPane.setVisible(false);
        firstDashBoard.setVisible(false);
        secondDashBoard.setVisible(true);
        switch (gameLevel) {
            case 1:
                easylGamePanel.setVisible(true);
                break;
            case 2:
                normalGamePanel.setVisible(true);
                break;
            case 3:
                hardGamePanel.setVisible(true);
                break;
            default:
                break;
        }
    }

    //This method is used to change the color of buttons while user chang the coilor during the run time.
    @FXML
    private void handle_p1Color(ActionEvent event) {

    }

    //This method is used to change the color of buttons while user chang the coilor during the run time.
    @FXML
    private void handle_p2Color(ActionEvent event) {
        reColorButtons();
    }

    //This method is used to rename the player name:
    @FXML
    private void handle_p1Name(ActionEvent event) {
        reColorButtons();
    }

    //This method is used to rename the player name:
    @FXML
    private void handle_p2Name(ActionEvent event) {
    }

    // This method handles exit(quite) te game:
    @FXML
    private void handle_ExitGame(ActionEvent event) {
        System.exit(-1);
    }

    private void reColorButtons() {
        color1 = Integer.toHexString(player1Color.getValue().hashCode()).substring(0, 6);
        color2 = Integer.toHexString(player2Color.getValue().hashCode()).substring(0, 6);
        switch (gameLevel) {

            case 1://For easy level of the game:
                if (easyButton1.getText().equals("O")) {
                    easyButton1.setStyle("-fx-background-color: '" + color1);
                } else if (easyButton1.getText().equals("O")) {
                    easyButton1.setStyle("-fx-background-color: '" + color2);
                }
                if (easyButton2.getText().equals("O")) {
                    easyButton2.setStyle("-fx-background-color: '" + color1);
                } else if (easyButton2.getText().equals("O")) {
                    easyButton2.setStyle("-fx-background-color: '" + color2);
                }
                if (easyButton3.getText().equals("O")) {
                    easyButton3.setStyle("-fx-background-color: '" + color1);
                } else if (easyButton3.getText().equals("O")) {
                    easyButton3.setStyle("-fx-background-color: '" + color2);
                }
                if (easyButton4.getText().equals("O")) {
                    easyButton4.setStyle("-fx-background-color: '" + color1);
                } else if (easyButton4.getText().equals("O")) {
                    easyButton4.setStyle("-fx-background-color: '" + color2);
                }
                if (easyButton5.getText().equals("O")) {
                    easyButton5.setStyle("-fx-background-color: '" + color1);
                } else if (easyButton5.getText().equals("O")) {
                    easyButton5.setStyle("-fx-background-color: '" + color2);
                }
                if (easyButton6.getText().equals("O")) {
                    easyButton6.setStyle("-fx-background-color: '" + color1);
                } else if (easyButton6.getText().equals("O")) {
                    easyButton6.setStyle("-fx-background-color: '" + color2);
                }
                if (easyButton7.getText().equals("O")) {
                    easyButton7.setStyle("-fx-background-color: '" + color1);
                } else if (easyButton7.getText().equals("O")) {
                    easyButton7.setStyle("-fx-background-color: '" + color2);
                }
                if (easyButton8.getText().equals("O")) {
                    easyButton8.setStyle("-fx-background-color: '" + color1);
                } else if (easyButton8.getText().equals("O")) {
                    easyButton8.setStyle("-fx-background-color: '" + color2);
                }
                if (easyButton9.getText().equals("O")) {
                    easyButton9.setStyle("-fx-background-color: '" + color1);
                } else if (easyButton9.getText().equals("O")) {
                    easyButton9.setStyle("-fx-background-color: '" + color2);
                }
                break;
            case 2://for normal level of the game:
                break;
            case 3://For hard level of the game:
                break;
            default:
                break;
        }
    }
}
