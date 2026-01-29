
/**
 * Utility class containing methods for simulating Conway's Game of Life.
 *
 * <p>The grid is represented using a rectangular 2D boolean array where
 * {@code true} means the cell is alive and {@code false} means the cell is dead.</p>
 *
 * <p>This implementation provides generation updates, coordinate lookup of living
 * cells, and simple console-print helpers for debugging.</p>
 */
public class GameOfLife {

	/**
	 * Generates the next generation of the Game of Life grid.
	 *
	 * <p>The provided 2D boolean array represents the current generation, where
	 * {@code true} indicates a living cell and {@code false} indicates an empty cell.
	 * This method applies the Game of Life rules to each cell and returns a new
	 * 2D boolean array of the same dimensions representing the next generation.</p>
	 *
	 * @param oldGen the current generation grid
	 * @return a new 2D boolean array representing the next generation
	 */
	public static boolean[][] createGeneration(boolean[][] oldGen) {
		boolean[][] newGen = new boolean [oldGen.length][oldGen[0].length];		
		for (int r = 0; r < oldGen.length; r++) {
			for (int c = 0; c < oldGen[0].length; c++) {
				int adjLife = checkNeighborCount(r, c, oldGen);
				if (oldGen[r][c]) {		// cell has life
					newGen[r][c] = (adjLife == 2 || adjLife == 3) ? true : false;
				}
				else {					// cell does not have life
					newGen[r][c] = (adjLife == 3) ? true : false;

				}	}	}	
		return newGen;
	}

	/**
	 * Finds the coordinates of all living cells in the current generation.
	 *
	 * <p>The returned array contains one row per living cell. Each row has exactly
	 * two values: the row index and column index of that cell in the original grid.</p>
	 *
	 * <p>Example: {@code [ [0, 2], [1, 3], [4, 0] ]}</p>
	 *
	 * @param currGen the current generation grid
	 * @return a 2D integer array containing the coordinates of all living cells
	 */
	public static int[][] findLivingCellLocations(boolean[][] currGen) {
		int arrCol = currGen[0].length; // passed array number of columns
		int arrRow = currGen.length; // passed array number of rows

		int myRow, myCol, livingCount = 0; // Array traversal variables & livingLocation size

		// counts how many living cells there are
		for (myRow = 0; myRow < arrRow; myRow++) {
			for (myCol = 0; myCol < arrCol; myCol++) {
				livingCount += (currGen[myRow][myCol]) ? 1 : 0;
			}	}

		int[][] livingLocation = new int[livingCount][2];
		int currRow = 0;

		// fills in the coordinates to the n row 2 column int array
		for (myRow = 0; myRow < arrRow; myRow++) {
			for (myCol = 0; myCol < arrCol; myCol++) {
				if (currGen[myRow][myCol]) {
					livingLocation[currRow][0] = myRow;
					livingLocation[currRow][1] = myCol;
					currRow++;

				}	}	}

		return livingLocation;
	}

	/**
	 * Counts the number of living neighboring cells around a specific cell.
	 *
	 * <p>Neighbors are the 8 surrounding squares (horizontal, vertical, and diagonal).
	 * This method safely handles edge cells by ignoring neighbors that would fall
	 * outside the bounds of the grid.</p>
	 *
	 * @param row the row index of the cell being evaluated
	 * @param col the column index of the cell being evaluated
	 * @param oldGen the grid representing the current generation
	 * @return the number of living neighboring cells (0 through 8)
	 */
	public static int checkNeighborCount(/*int[] liveCell,*/ int row, int col, boolean[][] oldGen) {
		int liveNeighbors = 0;
		/*
		int row = liveCell[0];
		int col = liveCell[1];
		 */

		int r,c;		
		for (r = -1; r <= 1; r++) {
			if ((row == 0) && (r == -1)) continue;							// checks if cell is on top edge
			if ((row == oldGen.length - 1) && (r == 1)) continue;			// checks if cell is on bottom edge

			for (c = -1; c <= 1; c++) {
				if ((col == 0) && (c == -1)) continue;						// checks if cell is on left edge
				if ((col == oldGen[0].length - 1) && (c == 1)) continue;	// checks if cell is on right edge
				if ((r == 0) && (c == 0)) continue;							// checks if cell is is the base cell

				if (oldGen[row +r][col + c]) liveNeighbors++;				// increase the living neighbors count

			}
		}
		return liveNeighbors; // returns the total number of living neighbors
	}

	/**
	 * Prints the Game of Life grid to standard output using 1s and 0s.
	 *
	 * <p>Living cells are displayed as {@code 1} and dead cells as {@code 0}.
	 * This method is intended for debugging and visualization purposes only
	 * and does not modify the original array.</p>
	 *
	 * @param myArr the grid to be printed
	 */
	public static void printGrid(boolean[][] myArr) {
		int arrCol = myArr[0].length;
		int arrRow = myArr.length;

		int[][] gameArr = new int[arrRow][arrCol];

		int myRow, myCol;

		// loop fills in and prints a visual grid with integers for ease of use.
		for (myRow = 0; myRow < arrRow; myRow++) {
			for (myCol = 0; myCol < arrCol; myCol++) {
				// fill current square with 1 or 0
				gameArr[myRow][myCol] = (myArr[myRow][myCol]) ? 1 : 0;

				// print current square
				System.out.print(gameArr[myRow][myCol] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Prints the coordinates of all living cells in the grid.
	 *
	 * <p>The method displays the total number of living cells followed by their
	 * (row, column) coordinates, one per line.</p>
	 *
	 * @param tempArr the grid to analyze
	 */
	public static void printCoordinates(boolean[][] tempArr) {
		int[][] lifeLocations = GameOfLife.findLivingCellLocations(tempArr);
		System.out.printf("%d Live Cells\n", lifeLocations.length);
		for (int[] j : lifeLocations) System.out.printf("(%d , %d)\n", j[0], j[1]);
	}

	/**
	 * Prints a formatted header for a simulation round.
	 *
	 * <p>The header includes a horizontal divider line, the round number, and
	 * spacing to clearly separate generations in the console output.</p>
	 *
	 * <p>This method is intended for display purposes only and does not affect
	 * the simulation state.</p>
	 *
	 * @param round the current simulation round number to display
	 */
	public static void roundHeader(int round, int numRounds, int divLength) {
		System.out.println();
		System.out.println("───────────────");
		System.out.println("Round: " + round + "/" + numRounds);
		System.out.println("───────────────");
		System.out.println();
	}
}
