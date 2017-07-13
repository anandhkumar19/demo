package Pratice;

public class GrandParent {
int noOfacres=100;
int noOfgold= 300;
public void Land(){
	this.noOfacres =35;
	int area = this.noOfacres;
	System.out.println("Land for father "+area);
}
public void gold(){
	System.out.println("Grand Father gold"+this.noOfgold);
}
}
