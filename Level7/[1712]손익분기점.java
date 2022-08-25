import java.util.Scanner;
import java.util.*;

public class Main {
	
	 public static void main(String[] args) {
		 
	      Scanner in =new Scanner(System.in);
	      int fC = in.nextInt();//fixed costs
	      int Pr = in.nextInt();//Production
	      int sale = in.nextInt();//sale

	      
	      if(Pr >= sale) {
	    	System.out.println(-1);
	      } 
	      else {
				System.out.println((fC / (sale - Pr)) + 1);
			}
      
	   }

	
}
