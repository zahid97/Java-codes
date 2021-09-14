package ticTaktoe;

public class Service {
 
	//To Print the table after each Step
	public static void printTable(char[][] matrix) {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				if(matrix[i][j] ==0)
					System.out.print(" - ");
				else
					System.out.print(" " +matrix[i][j] + " ");
			}
			System.out.println("");
		}
	}
	//To Modify the grid after each step
	public void modifyGrid(boolean isX,char[][] matrix,String input) {
		int inputRow = Integer.parseInt(input.split(" ")[0]) - 1;
		int inputColumn = Integer.parseInt(input.split(" ")[1]) -1;
		
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix.length;j++) {
				if(matrix[inputRow][inputColumn]==0) {
					if(isX) {
						matrix[inputRow][inputColumn] = 'X';
					}else {
						matrix[inputRow][inputColumn] = 'O';
					}
				}
				
			}
		}
		printTable(matrix);
	}
	//To check if the user has eneterd valid position
	public boolean checkGrid(char[][] matrix, String input) {
		int inputRow = Integer.parseInt(input.split(" ")[0]) - 1;
		int inputColumn = Integer.parseInt(input.split(" ")[1]) -1;
		
		if(matrix[inputRow][inputColumn] == 0)
			return true;
		
		return false;
	}
	//Winning Possibility After 4 steps
	public boolean checkForWinningPossibillity(char[][] matrix) {
		boolean hasWon = false;
		//checking horizontally
		for(int i=0;i<matrix.length;i++) {
			if(matrix[i][0]!=0) {
				char charPresent = matrix[i][0];
				for(int j=1;j<matrix.length;j++){
					if(charPresent == matrix[i][j])
						hasWon = true;
					else {
						hasWon = false;
						break;
					}	
				}	
				if(hasWon)
					break;
			}
		}
		//Left diagonally
		if(!hasWon) {
		for(int i=1;i<matrix.length;i++) {
			if(matrix[0][0]!=0) {
				char charPresent = matrix[0][0];
				if(charPresent == matrix[i][i])
					hasWon = true;
				else {
					hasWon = false;
					break;
				}
					
			}
		}
	}
		
		//right Diagonally
		if(!hasWon) {
		for(int i=1,j=matrix.length-2;i<matrix.length && j>=0;i++,j--) {
			if(matrix[0][2]!=0) {
				char charPresent = matrix[0][2];
				if(charPresent == matrix[i][j])
					hasWon = true;
				else {
					hasWon = false;
					break;
				}
					
			}
		}
	}	
		
		//vertically
		if(!hasWon) {
			for(int i=0;i<matrix.length;i++) {
				if(matrix[0][i]!=0) {
					char charPresent = matrix[0][i];
					for(int j=1;j<matrix.length;j++) {
						if(charPresent == matrix[j][i])
							hasWon = true;
						else {
							hasWon = false;
							break;
						}
							
					}
					if(hasWon)
						break;
				}
			}
		}
		return hasWon;
	}
	
	
}
