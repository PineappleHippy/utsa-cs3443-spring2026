package application.model;

/**
 * Represents a position on the Tic-tac-toe board.
 *
 * @author JDT
 */
public class Position {
   private int rowNum;
   private int colNum;

   /**
    * Constructs a Position with the given row and column.
    * @param rowNum the row number
    * @param colNum the column number
    */
   public Position(int rowNum, int colNum){
      this.rowNum = rowNum;
      this.colNum = colNum;

   }

   /**
    * Returns the row number of this position.
    * @return the row number
    */
   public int getRowNum() {
      return rowNum;
   }

   /**
    * Returns the column number of this position.
    * @return the column number
    */
   public int getColNum() {
      return colNum;
   }
}
