package Pratice;

import java.util.Scanner;

public class Switch {
public static void main(String[] args) {
	@SuppressWarnings("resource")
	Scanner days = new Scanner(System.in);
    System.out.println("enter the day");
    int n = days.nextInt();
    switch (n) {
	case 1:
		System.out.println("It is monday");
		break;
	case 2:
		System.out.println("It is tuesday");
		break;
	case 3:
		System.out.println("It is wednesday");
		break;
	case 4:
		System.out.println("It is Thursday");
		break;
	case 5:
		System.out.println("It is Friday");
		break;
	case 6:
		System.out.println("It is saturday");
		break;
	case 7:
		System.out.println("It is Sunday");
		break;
	default:
		System.out.println("Only seven days in week");
		break;
	}
}
}
