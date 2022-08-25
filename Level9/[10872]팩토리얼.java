import java.util.Scanner;

public class Main {
	
	 public static void main(String[] args) {
		 
	      Scanner in =new Scanner(System.in);
	      
	      int N = in.nextInt();
	      
	      System.out.println(factorial(N));
	      
	   }
	 
	 public static int factorial(int a) {
		 
		 if(a<=1) return 1;
		 
		 return a * factorial(a-1);
	 }

	
}
