package Pratice;

public class Cat extends dog{
public void catSound(){
	System.out.println("Cat sound meow");
}
public void catNolegs(){
	this.noOfLegs = 4;
	int noOflegs=this.noOfLegs;
	System.out.println("Cat has "+noOflegs+" legs");
}
}
