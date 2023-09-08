import java.util.Scanner;

public class Main {
	
	 public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 
		 int count;
		 boolean[] a = new boolean[30]; //배열
		 
		 for(int i=0;i<28;i++) {
			 count = in.nextInt();
			 a[count-1]= true;
		 }
		 
		 for(int i=0;i<30;i++) {
			 if(a[i]!=true) {
				 System.out.println(i+1);
			 }
		 }
		 
	
		 

	 }
	}
