
public class Player{
	private String name;
	private String symbol;
	public Player(String name,String symbol){
		this.name = name;
		this.symbol = symbol;
	}
	String getName(){
		return name;
	}
	String getSymbol(){
		return symbol;
	}

	void setSymbol(String symbol){
		this.symbol = symbol;
	}
}