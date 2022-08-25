import java.util.Scanner;

public class Main {
	
	 public static void main(String[] args) {
		 
	      Scanner in =new Scanner(System.in);
	      
	      int N = in.nextInt();
	      
	      for(int i=0;i<N;i++) {
		      
	    	  int A = in.nextInt();
		      int B = in.nextInt();
		      int C = in.nextInt();
		      
				if(C % A == 0) {
					System.out.println((A * 100) + (C / A));
	 
				} else {
					System.out.println(((C % A) * 100) + ((C / A) + 1));
				}
	    	  
	    	  
	      }
           


 
	   }

	
}
