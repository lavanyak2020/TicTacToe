package com.tictactoe;
import java.util.*;

public class TicTacToe{
	Board board;
	Player playerX;
	Player playerO;
	public TicTacToe(){
		board = new Board();
		playerX = new Player("X");
		playerO = new Player("O");
	}
	
	public void startGame(){
		Scanner scan=new Scanner(System.in);
		boolean player1 = true;
		Player current = playerX;
		int x;
		int y;

		while(board.isBoardFull() != true){
			board.printBoard();
			
			System.out.print("Player "+current.getName()+": Enter position>");
			x = scan.nextInt();
			y = scan.nextInt();
			while(!board.occupyCell(current.getName(),x,y)){
				System.out.print("Entered Invalid\nEnter Valid:\n Player "+current.getName()+": Enter position>");
				x = scan.nextInt();
				y = scan.nextInt();
			}
			
			if(board.isResultWinning(x,y)){
				break;
			}

			player1 = !player1; 
			if(player1){
				current = playerX;
			}else{
				current = playerO;
			}
		}
		if(board.isBoardFull() != true){
			System.out.println("{^.^} => Player "+current.getName()+" won");
			
			
		}else{
			System.out.println("Tie");
		}
	}
	

}