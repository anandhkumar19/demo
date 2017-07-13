package Pratice;

import java.util.Scanner;

public class PassOrFail {
public static void main(String[] args) {
	@SuppressWarnings("resource")
	Scanner m = new Scanner(System.in);
	System.out.println("Enter the matk");
	int marks = m.nextInt();
	if(marks>=50){
		System.out.println("Pass");
	}
	else
		System.out.println("Fail");
}
}
