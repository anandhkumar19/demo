package Pratice;

public class TwenthCentury  {
	int noOffilm;
	String MovieType;
	
	public TwenthCentury(int count){
		this.noOffilm =count;
		System.out.println("Single Paramater");
		System.out.println("No of film produced"+count);
	}
	
	public TwenthCentury(int count, String type){
		this.MovieType=type;
		this.noOffilm = count;
		System.out.println("Double Paramater");
		System.out.println("No of film produced"+count);
		System.out.println(" film produced "+type);
	}
	
public static void main(String[] args) {
	TwenthCentury tc = new TwenthCentury(500);
	TwenthCentury tc1 = new TwenthCentury(500, "3D");
	
}
}
