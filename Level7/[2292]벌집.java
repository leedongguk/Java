import java.util.Scanner;

public class Main {
	
	 public static void main(String[] args) {
		 
	      Scanner in =new Scanner(System.in);
	      int input = in.nextInt();//fixed costs
          int count = 1;
          int range = 2;
          
          if(input==1) {
        	  System.out.println(1);
          }
          else {
        	  
        	  while(range <= input){
        		  
        		  range = range + (6*count);
        		  count++;
        	  }
        	  System.out.println(count);
          }

      
	   }

	
}
