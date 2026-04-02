package application.model;

import application.view.MainView;

/**
 * Represents the Tic-tac-toe board and implements the game logic.
 *
 * @author JDT
 */
public class TictacToeBoard {
   private Marker[][] board;
   private MainView mainView;
   private Marker startMarker;
   private Marker currentMarker;
   private int xWins;
   private int oWins;
   private int draws;
   private boolean gameOver;

   /**
    * Constructs a new TictacToeBoard with an empty 3x3 grid.
    */
   public TictacToeBoard() {
      board = new Marker[3][3];
      startMarker = Marker.X;
      currentMarker = startMarker;
      xWins = 0;
      oWins = 0;
      draws = 0;
   }

   /**
    * Sets the MainView instance for updating the UI.
    * @param mainView the MainView to use
    */
   public void setMainView(MainView mainView) {
      this.mainView = mainView;
      mainView.displayXWins(xWins);
      mainView.displayOWins(oWins);
      mainView.displayDraws(draws);
      clearBoard();
      mainView.displayDirections("Ready Player " + currentMarker);

   }

   /**
    * Places the current player's marker at the given position if valid,
    * then checks for a win or draw and updates the view accordingly.
    * @param position the position to place the marker
    */
   public void putMarker(Position position) {
      if(gameOver) return;
      if(board[position.getRowNum()][position.getColNum()] != null) {
         return;
      }
      board[position.getRowNum()][position.getColNum()] = currentMarker;
      mainView.displayMarker(currentMarker.toString(), position.getRowNum(), position.getColNum());

      Position[] winner = winningPositions(currentMarker);
      if(winner != null) {
         gameOver = true;
         if(currentMarker == Marker.X) {
            xWins++;
            mainView.displayXWins(xWins);
         } else {
            oWins++;
            mainView.displayOWins(oWins);
         }
         mainView.displayDirections(currentMarker + " wins!");
         for(Position p : winner) {
            mainView.changeBackgroundColor("red", p.getRowNum(), p.getColNum());
         }
      } else if(isBoardFull()) {
         draws++;
         mainView.displayDraws(draws);
         mainView.displayDirections("The game is a draw");
      } else {
         currentMarker = (currentMarker == Marker.O) ? Marker.X : Marker.O;
         mainView.displayDirections("Ready Player " + currentMarker);
      }
   }

   /**
    * Determines if the given marker has a winning row, column, or diagonal.
    * @param marker the marker to check
    * @return a 3-element array of winning Positions, or null if no winner
    */
   private Position[] winningPositions (Marker marker){
      for (int r = 0; r < 3; r++) {
         if (board[r][0] == marker && board[r][1] == marker && board[r][2] == marker) {
            return new Position[] { new Position(r, 0), new Position(r, 1), new Position(r, 2) };
         }
      }

      for (int c = 0; c < 3; c++){
         if (board[0][c] == marker && board[1][c] == marker && board[2][c] == marker) {
            return new Position[] { new Position(0, c), new Position(1, c), new Position(2, c) };
         }
      }

      if (board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) {
         return new Position[] { new Position(0, 0), new Position(1, 1), new Position(2, 2) };
      }
      else if (board[0][2] == marker && board[1][1] == marker && board[2][0] == marker) {
         return new Position[] { new Position(0, 2), new Position(1, 1), new Position(2, 0) };
      }

      return null;
   }

   /**
    * Starts a new game by clearing the board and alternating the starting player.
    */
   public void startNewGame(){
      clearBoard();
      startMarker = (startMarker == Marker.O) ? Marker.X : Marker.O;
      currentMarker = startMarker;
      mainView.displayDirections("Ready Player " + currentMarker);
      gameOver = false;
   }

   /**
    * Clears the board and resets all button colors and text in the view.
    */
   private void clearBoard() {
      for(int r = 0; r < 3; r++) {
         for(int c = 0; c < 3; c++) {
            board[r][c] = null;
            mainView.displayMarker("", r, c);
            mainView.changeBackgroundColor("lightgray", r, c);
         }
      }
   }

   /**
    * Checks if all cells on the board are filled.
    * @return true if the board is full, false otherwise
    */
   private boolean isBoardFull() {
      for (int r = 0; r < 3; r++) {
         for (int c = 0; c < 3; c++) {
            if (board[r][c] == null) {
               return false;
            }
         }
      }
      gameOver = true;
      return true;
   }
}