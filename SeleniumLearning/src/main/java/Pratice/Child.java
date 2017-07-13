package Pratice;

public class Child extends Father {


public void Land(int area){
	
	System.out.println("child area"+area);
}
public static void main(String[] args) {
	Child c= new Child();
	c.Land(37);
}
}
