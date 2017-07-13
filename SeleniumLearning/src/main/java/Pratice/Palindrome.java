package Pratice;

public class Palindrome {
public static void main(String[] args) {
	String str1 ="madam";
	String str2="";
	
	int length =str1.length();
	for(int i=length-1;i>=0;i--){
		str2 = str2 +str1.charAt(i);
		//System.out.println(str2);
	}
	if(str1.equals(str2)){
		System.out.println(str1 + " is palindrome");
	}
	else
		System.out.println(str1 + " is not palindrome");	
}
}
