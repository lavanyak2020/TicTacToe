package com.tictactoe;
import java.util.*;
public class Board{
	String[][] boardValues = new String[3][3];
	Board(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				boardValues[i][j] = "_";
			}
		}
		
	}
	
	boolean occupyCell(String val,int posX,int posY){
		if(boardValues[posX][posY] == "_"){
			boardValues[posX][posY] = val;
			return true;
		}
		return false;
	}	
	boolean isBoardFull(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				if(boardValues[i][j] == "_"){
					return false;
				}
			}
		}
		return true;
	}
	void printBoard(){
		for(int i=0;i<3;i++){
			System.out.print("\t\t");
			for(int j=0;j<3;j++){
				System.out.print(boardValues[i][j]+" ");
			}
			System.out.println();
		}
	}
	boolean isResultWinning(int x,int y){
		if((x == 0 && y == 0) || (x == 2 && y == 2)){
			if(boardValues[0][0] == boardValues[1][1] && boardValues[1][1] == boardValues[2][2]){
				return true;
			}
			return false;
		}
		if((x == 0 && y==2) || (x==2 && y == 0)){
			if(boardValues[0][2] == boardValues[1][1] && boardValues[1][1] == boardValues[2][0]){
				return true;
			}
			return false;
		}
		if(boardValues[x][0] == boardValues[x][1] && boardValues[x][0] == boardValues[x][2]){
			return true;
		}
		if(boardValues[0][y] == boardValues[1][y] && boardValues[2][y] == boardValues[0][y]){
			return true;
		}
		return false;

	}
	
	
}




