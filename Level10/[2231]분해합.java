import java.util.Scanner;

public class Main {
	    public static void main(String[] args) {
	    	
	        Scanner in = new Scanner(System.in);
	 
	        int N = in.nextInt();
	        int result = 0;
	        
	        
	       for(int i =0;i<N;i++) {
	    	   int num = i;
	    	   int sum = 0;
	    	   
	    	   while(num !=0) {
	    		   sum += num % 10;
	    		   num = num / 10;
	    	   }
	    	   
	    	   if(sum + i ==N) {
	    		   result = i;
	    		   break;
	    	   }
	    	   
	    	   
	       }
	        System.out.println(result);
	    }
	        
	    
}
