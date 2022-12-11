/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package numberguessing;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hamid Raza
 */
public class GameController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private final Random r = new Random();
    private int randomNumber, guessCount = 10;
    
    @FXML
    private TextField guessingField;   
    @FXML
    private Label guessLabel;
    @FXML
    private ImageView upArrow;
    @FXML
    private ImageView downArrow;
    @FXML
    private ImageView win;
    @FXML
    private ImageView lose;
    
    @FXML
    private void handleBackAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Stage stage2 = new Stage();
        Scene scene = new Scene(root);
        stage2.setTitle("Number Guessing Game");
        stage2.setScene(scene);
        stage2.show();
    }
    
    @FXML
    private void handleSubmitAction(ActionEvent event) {
        if(Integer.parseInt(guessingField.getText()) == randomNumber){
            downArrow.setVisible(false);
            upArrow.setVisible(false);
            win.setVisible(true);
            lose.setVisible(false);
            guessLabel.setVisible(false);
        } else if(Integer.parseInt(guessingField.getText()) > randomNumber){
            downArrow.setVisible(true);
            upArrow.setVisible(false);
            win.setVisible(false);
            if(guessCount == 01){
            guessLabel.setText(null);
            downArrow.setVisible(false);
            upArrow.setVisible(false);
            win.setVisible(false);
            lose.setVisible(true);
            } else {
            guessCount--;
            guessLabel.setText(guessCount + "  Guesses Left!");      
            }
            
        } else if(Integer.parseInt(guessingField.getText()) < randomNumber){
            downArrow.setVisible(false);
            upArrow.setVisible(true);
            win.setVisible(false);
            lose.setVisible(false);
            if(guessCount == 01){
            guessLabel.setText(null);
            downArrow.setVisible(false);
            upArrow.setVisible(false);
            win.setVisible(false);
            lose.setVisible(true);
            } else {
            guessCount--;
            guessLabel.setText(guessCount + "  Guesses Left!");
            }

        }
    }
    
    @FXML
    private void handleTryAction(ActionEvent event) throws IOException {
        guessingField.setText(null);
        guessLabel.setText(null);
        downArrow.setVisible(false);
        upArrow.setVisible(false);
        win.setVisible(false);
        lose.setVisible(false);
        handleSubmitAction(event);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        randomNumber = r.nextInt(100);
        System.out.println(randomNumber);
        downArrow.setVisible(false);
        upArrow.setVisible(false);
        win.setVisible(false);
        lose.setVisible(false);
    }    
    
}
