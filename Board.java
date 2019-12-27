
import java.util.*;
public class Board{
	String[][] boardValues = new String[3][3];
	Board(){
		initializeBoard();
	}
	private void initializeBoard(){
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				boardValues[i][j] = "_";
			}
		}
	}
	
	boolean occupyCell(String symbol,Coordinate coordinate){
		if(boardValues[coordinate.x][coordinate.y] == "_"){
			boardValues[coordinate.x][coordinate.y] = symbol;
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
	boolean isWinningMove(Coordinate point){
		
		return checkVertical(point) || checkHorizontal(point) || checkDiagonal(point);
		

	}
	private boolean checkDiagonal(Coordinate point){
		if(point.x == 1 && point.y == 1){
			return checkDiagonalD1() || checkDiagonalD2();
		}
		if((point.x == 0 && point.y == 0) || (point.x == 2 && point.y == 2)){
			return checkDiagonalD1();
		}
		if((point.x == 0 && point.y==2) || (point.x==2 && point.y == 0)){
			return checkDiagonalD2();
		}
		return false;
	}
	private boolean checkDiagonalD1(){
		if(boardValues[0][0] == boardValues[1][1] && boardValues[1][1] == boardValues[2][2]){
				return true;
		}
		return false;
	}
	private boolean checkDiagonalD2(){
		if(boardValues[0][2] == boardValues[1][1] && boardValues[1][1] == boardValues[2][0]){
				return true;
		}
			return false;
	}
	private boolean checkVertical(Coordinate point){
		if(boardValues[0][point.y] == boardValues[1][point.y] && boardValues[2][point.y] == boardValues[0][point.y]){
			return true;
		}
		return false;
	}
	private boolean checkHorizontal(Coordinate point){
		if(boardValues[point.x][0] == boardValues[point.x][1] && boardValues[point.x][0] == boardValues[point.x][2]){
			return true;
		}
		return false;
	}
	
	
}




