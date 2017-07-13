package Pratice;

public  class Calculator implements BaiscCalculatorInterface,AdvancedCalcInterface {



	public int add(int i, int j) {
		return i+j;
		
	}

	public int Sub(int i, int j) {
		return i-j;
		
	}

	public int multi(int i, int j) {
		return i*j;
		
	}

	public int Div(int i, int j) {
		return i/j;
		
	}

	public double cosine(int a) {
		
		return Math.cos(a);
	}

}
