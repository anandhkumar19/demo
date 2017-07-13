package Pratice;

public class PrivateExample {
String name;
private int marks;
  public void viewStudentMark1(){
   this.marks = 77;
   int mark = this.marks;
   this.name="Anandh";
	String name=this.name;
	//return mark;
	System.out.println(name+"mark is"+mark);
}
  protected  int viewStudentMark2(){
	   this.marks = 98;
	   int mark = this.marks;
	   this.name="Aravindh";
		//String name=this.name;
		return mark;
		//System.out.println(name+"mark is"+mark);
}
}
