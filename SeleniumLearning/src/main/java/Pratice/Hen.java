package Pratice;

public class Hen extends Cat{
	public void henSound(){
		System.out.println("Hen sound karkoo");
	}
	public void henNolegs(){
		this.noOfLegs = 2;
		int noOflegs=this.noOfLegs;
		System.out.println("Hen has "+noOflegs+" legs");
	}
	public static void main(String[] args) {
		Hen h = new Hen();
		h.bark();
		h.dogNoOfLegs();
		h.catNolegs();
		h.catSound();
		h.henNolegs();
		h.henSound();
	}
}
