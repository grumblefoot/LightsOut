import java.util.*;

/**
 *@author Rowan W Osmon version 1.0 
* This class runs the game.
*/
public class Run {
	static Scanner s = new Scanner(System.in);
	static int row = 0;
	static int column = 0;
	static BoardState m = new BoardState();

	public static void main(String[] args) {
		run();
		//chaseLights();
	}
	
	private static int getRow() {
		System.out.println("Enter the row number");
		if (s.hasNextInt()) {
			int i = s.nextInt();
			if (i < 0 || i > m.getRow()) {
				System.out.println("Input out of range!");
				return getRow();
			} else {
				return i;	
			}
		} else {
			System.out.println("Not a valid input!");
			
		}
		String junk = s.next();
		return getRow();
	}
	
	private static int getColumn() {
		System.out.println("Enter the column number");
		if (s.hasNextInt()) {
			int i = s.nextInt();
			if (i < 0 || i > m.getCollum()) {
				System.out.println("Input out of range!");
				return getColumn();
			} else {
				return i;	
			}
		} else {
			System.out.println("Not a valid input!");
			
		}
		String junk = s.next();
		return getColumn();
	}
	
	private static void cellSelect() {
		row = getRow();
		column = getColumn();
		m.toggle(row,column);
	}
	
	private static void run() {		
		m.displayBoard();
		while (m.checkIfResolved() == false) {
			cellSelect();
			System.out.println("");
			m.displayBoard();
		}
		System.out.println("You win!");
		s.close();
	}
	
	private static void chaseLights() {
		m.displayBoard();
		System.out.println("");
		while (m.checkIfResolved() == false) {
			for (int i = 0; i < m.getRow()-1; i++) {
				for (int j = 0; j < m.getCollum(); j++) {
					if (m.matrix[i][j] == 1) {
						m.toggle(i+1, j);
						m.displayBoard();
						System.out.println("");
					}
				}
			}
			int[] key = new int[] {1,0,0,0,1};
			int[] lock = new int[] {0,0,0,1,1};
			for (int i = 0; i < key.length; i++) {
				if (m.matrix[4][i] != key[i]) {
					break;
				}
			
			}
			
			
		}
	}
}
