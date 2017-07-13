package Pratice;

public class Father extends GrandParent {
	int noOfacres=75;
	int noOfgold= 200;
	public void Land(){
		this.noOfacres =15;
		int area = this.noOfacres;
		System.out.println("Land for child "+area);
	}
	public void gold(){
		System.out.println("Grand Father gold"+this.noOfgold);
	}
}
