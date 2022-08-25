import java.util.Scanner;

public class Main {
	
	 public static void main(String[] args) {
		 
	      Scanner in =new Scanner(System.in);
	      
	      int N = in.nextInt();
	      int i = 2;
	      
	      while(N!=1) {
	    	  
	    	  
	    	  if(N%i ==0) {
	    		  System.out.println(i);
	    		  N/=i;
	    	  }
	    	  else {
	    		  i++;
	    	  }
	    	  
	      }
	      
	   }

	
}
