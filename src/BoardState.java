import java.util.*;

public class BoardState {
	
	private int row = 4;
	private int collum = 4;
	int[][] matrix = new int[collum][row];
	Random r = new Random();
	
	BoardState() {
		createBoard();
	}
	
	public void createRandomBoard() {
		matrix = new int[row][collum];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < collum; j++) {
				matrix[i][j] = r.nextInt(2);
			}
		}
	}
	public void createBoard() {
		matrix = new int[row][collum];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < collum; j++) {
				matrix[i][j] = 1;
				
			}
		}
	}
	
	public void createBoard(int row, int collum) {
		this.row = row;
		this.collum = collum;
		matrix = new int[row][collum];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < collum; j++) {
				matrix[i][j] = r.nextInt(2);
			}
		}
		
	}
	
	public void displayBoard() {		
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("[");
			for(int j = 0; j < matrix[0].length; j++) {
				System.out.print(" " + matrix[i][j]);
			}
			System.out.println(" ]");
		}
	}
	
	public void toggle(int x, int y) {
		matrix[x][y] = flip(matrix[x][y]);
		if (x > 0) {
			matrix[x-1][y] = flip(matrix[x-1][y]);
		}
		if (x < row-1) {
			matrix[x+1][y] = flip(matrix[x+1][y]);
		}
		if (y > 0) {
			matrix[x][y-1] = flip(matrix[x][y-1]);
		}
		if (y < collum-1) {
			matrix[x][y+1] = flip(matrix[x][y+1]);
		}
	}
	
	private  int flip(int i) {
		if (i == 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public int getRow() {
		return row;
	}
	
	 public void setRow(int a) {
		 if (a < 1) {
			 row = 1;
		 } else {
			 row = a; 
		 } 
	 }
	 
	public int getCollum() {
			return collum;
	}
		
	public void setCollum(int a) {
		if (a < 1) {
			collum = 1;
		} else {
			collum = a; 
			} 
	}
	
	public boolean checkIfResolved() {
		for (int i = 0; i < row; i++) {
			for (int j =0; j < collum; j++) {
				if (matrix[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void setCell(int row, int collum) {
		matrix[collum][row] = flip(matrix[collum][row]);
	}

}
