package ticTaktoe;

import java.util.Scanner;

public class Dirver {

	public static void main(String[] args) {
		Service service = new Service();
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int gridRow = 3, gridColumn = 3;
		char[][] gridMatrix = new char[gridRow][gridColumn]; 
		boolean isX = true;
		String player1 = sc.nextLine();
		String player2 = sc.nextLine();
		boolean hasWon = false; 
		
		
		service.printTable(gridMatrix);
		
		for(int i=0;i<gridRow*gridColumn;i++) {
			String input = sc.nextLine();
			if(Integer.parseInt(input.split(" ")[0]) > gridRow || Integer.parseInt(input.split(" ")[1]) > gridColumn) {
				System.out.println("Invalid input");
				i--;
				continue;
			}
			if(service.checkGrid(gridMatrix,input)) {
				service.modifyGrid(isX,gridMatrix,input);
				if(i>=4) {
					hasWon = service.checkForWinningPossibillity(gridMatrix);
					if(hasWon) {
						if(isX)
							System.out.println("Congratulations !! " +player1.split(" ")[1] + " has won");
						else
							System.out.println("Congratulations !! " +player2.split(" ")[1] + " has won");
						break;
					}
				}
				isX = !isX;
			}else {
				System.out.println("Invalid input");
				i--;
			}
			
		}
		if(!hasWon)
			System.out.println("Game is draw");
		
	}

}
