import java.util.*;

public class TicTacToe{
	private Board board;
	private Player playerX;
	private Player playerO;
	public TicTacToe(){
		board = new Board();
		playerX = new Player("player1","X");
		playerO = new Player("player2","O");
	}

	private Coordinate getInputFromPlayer(Player player){
		Scanner scan=new Scanner(System.in);
		System.out.print("Player "+player.getName()+": Enter position>");
		Coordinate point = new Coordinate();
		point.x = scan.nextInt();
		point.y = scan.nextInt();
		while(!board.occupyCell(player.getSymbol(),point)){
			System.out.print("Entered Invalid\nEnter Valid:\n Player "+player.getName()+": Enter position>");
			point.x = scan.nextInt();
			point.y = scan.nextInt();
		}
		return point;
	}
	private Player changePlayerTurn(Player currentPlayer){
		if(currentPlayer == playerX){
			return playerO;
		}
		return playerX;
	}
	
	public void startGame(){
		Player currentPlayer = playerX;
		Coordinate point;
		while(board.isBoardFull() != true){
			board.printBoard();
			
			point = getInputFromPlayer(currentPlayer);
			if(board.isWinningMove(point)){
				break;
			}
			currentPlayer = changePlayerTurn(currentPlayer);
		}
		if(board.isBoardFull() != true){
			System.out.println("{^.^} => Player "+currentPlayer.getName()+" won");
			
			
		}else{
			System.out.println("{^.^} ==== Tie ==== {^.^}");
		}
	}
	

}