import java.util.*;

/**
 * Demonstrates the Game of Life simulation by initializing a test grid,
 * printing the starting state, and advancing the simulation by one generation.
 *
 * <p>This class is intended as a simple driver for debugging/verification and
 * console output, not as a full user interface.</p>
 */

public class Driver {
	/**
	 * Entry point for the program.
	 *
	 * <p>Creates an initial Game of Life grid, prints the grid and the living cell
	 * coordinates, then advances the grid by one generation and prints the results.</p>
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// This initializes the Test Array
		boolean[][] myArr = new boolean[][] { 
			{ true, false, false, false, true, false }, 
			{ false, false, false, false, true, true }, 
			{ false, true, true, false, false, false },
			{ false, true, false, false, true, false }, 
			{ false, true, false, true, false, false },
			{ false, false, false, false, false, false }
		};

		int round = 1;
		int numRounds = 3;

		System.out.println("Start the Life Cycle");
		System.out.print("Please enter the number of Life Cycles you would like to view: ");
		numRounds = sc.nextInt();


		while (round <= numRounds) {
			GameOfLife.roundHeader(round, numRounds, myArr[0].length*2);
			if (round > 1) myArr = GameOfLife.createGeneration(myArr);
			GameOfLife.printGrid(myArr);
			System.out.println();
			GameOfLife.printCoordinates(myArr);
			int[][] pulse = GameOfLife.findLivingCellLocations(myArr);
			if (pulse.length == 0) {
				System.out.println("Population Decimated.\nGAME OVER");
				break;
			}
			round++;
		}
		sc.close();
	}

}