package application.controller;

import application.model.Position;
import application.model.TictacToeBoard;
import application.view.MainView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Controls the Tic-tac-toe application, handling user input and
 * connecting the model and view.
 *
 * @author JDT
 */
public class MainController {

   private TictacToeBoard tictactoeBoard;
   @FXML private Label directionsLabel;
   @FXML private Label xWinsLabel;
   @FXML private Label oWinsLabel;
   @FXML private Label drawsLabel;
   @FXML private Button r0c0Button;
   @FXML private Button r0c1Button;
   @FXML private Button r0c2Button;
   @FXML private Button r1c0Button;
   @FXML private Button r1c1Button;
   @FXML private Button r1c2Button;
   @FXML private Button r2c0Button;
   @FXML private Button r2c1Button;
   @FXML private Button r2c2Button;

   /**
    * Initializes the controller by creating the model and view,
    * passing labels and buttons to the view, and setting user data
    * on each board button.
    */
   public void initialize() {
      tictactoeBoard = new TictacToeBoard();
      MainView mainView = new MainView();

      mainView.setDirectionsLabel(directionsLabel);
      mainView.setXWinsLabel(xWinsLabel);
      mainView.setOWinsLabel(oWinsLabel);
      mainView.setDrawsLabel(drawsLabel);

      mainView.setButton(r0c0Button, 0, 0);
      mainView.setButton(r0c1Button, 0, 1);
      mainView.setButton(r0c2Button, 0, 2);
      mainView.setButton(r1c0Button, 1, 0);
      mainView.setButton(r1c1Button, 1, 1);
      mainView.setButton(r1c2Button, 1, 2);
      mainView.setButton(r2c0Button, 2, 0);
      mainView.setButton(r2c1Button, 2, 1);
      mainView.setButton(r2c2Button, 2, 2);

      tictactoeBoard.setMainView(mainView);

      r0c0Button.setUserData(new Position(0, 0));
      r0c1Button.setUserData(new Position(0, 1));
      r0c2Button.setUserData(new Position(0, 2));
      r1c0Button.setUserData(new Position(1, 0));
      r1c1Button.setUserData(new Position(1, 1));
      r1c2Button.setUserData(new Position(1, 2));
      r2c0Button.setUserData(new Position(2, 0));
      r2c1Button.setUserData(new Position(2, 1));
      r2c2Button.setUserData(new Position(2, 2));
   }

   /**
    * Handles a click on any of the nine board buttons.
    * Retrieves the button's Position and passes it to the model.
    * @param event the action event from the clicked button
    */
   public void gridButtonClicked(ActionEvent event) {
      Button button = (Button) event.getSource();
      Position position = (Position) button.getUserData();
      tictactoeBoard.putMarker(position);
   }

   /**
    * Handles a click on the New Game button, starting a new game.
    * @param event the action event from the New Game button
    */
   public void newGameButtonClicked(ActionEvent event) {
      tictactoeBoard.startNewGame();
   }
}