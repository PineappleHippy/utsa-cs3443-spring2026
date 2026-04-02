package application.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Represents the application view for the Tic-tac-toe game.
 *
 * @author JDT
 */
public class MainView {
   private Label directionsLabel;
   private Label xWinsLabel;
   private Label oWinsLabel;
   private Label drawsLabel;
   private Button[][] grid;

   /**
    * Constructs a MainView with an empty 3x3 button grid.
    */
   public MainView() {
      grid = new Button[3][3];
   }

   /**
    * Sets the directions label.
    * @param lbl the label to use
    */
   public void setDirectionsLabel (Label lbl){
      this.directionsLabel = lbl;
   }

   /**
    * Sets the X wins label.
    * @param lbl the label to use
    */
   public void setXWinsLabel (Label lbl){
      this.xWinsLabel = lbl;
   }

   /**
    * Sets the O wins label.
    * @param lbl the label to use
    */
   public void setOWinsLabel (Label lbl){
      this.oWinsLabel = lbl;
   }

   /**
    * Sets the draws label.
    * @param lbl the label to use
    */
   public void setDrawsLabel (Label lbl){
      this.drawsLabel = lbl;
   }

   /**
    * Sets a button in the grid at the given position.
    * @param b the button to set
    * @param row the row number
    * @param col the column number
    */
   public void setButton(Button b, int row, int col) {
      grid[row][col] = b;
   }

   /**
    * Displays the directions message.
    * @param str the message to display
    */
   public void displayDirections(String str) {
      directionsLabel.setText(str);
   }

   /**
    * Displays the number of X wins.
    * @param numWins the number of wins
    */
   public void displayXWins(int numWins) {
      xWinsLabel.setText("X wins: " + numWins);
   }

   /**
    * Displays the number of O wins.
    * @param numWins the number of wins
    */
   public void displayOWins(int numWins) {
      oWinsLabel.setText("O wins: " + numWins);
   }

   /**
    * Displays the number of draws.
    * @param numDraws the number of draws
    */
   public void displayDraws(int numDraws) {
      drawsLabel.setText("Draws: " + numDraws);
   }

   /**
    * Displays a marker on the button at the given position.
    * @param str the marker text
    * @param row the row number
    * @param col the column number
    */
   public void displayMarker(String str, int row, int col) {
      grid[row][col].setText(str);
   }

   /**
    * Changes the background color of a button at the given position.
    * @param str the color string
    * @param row the row number
    * @param col the column number
    */
   public void changeBackgroundColor(String str, int row, int col) {
      grid[row][col].setStyle("-fx-background-color: " + str + ";");
   }
}