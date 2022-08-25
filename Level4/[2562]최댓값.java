import java.util.Scanner;

	public class Main {
	    public static void main(String[] args) {

	    	Scanner in = new Scanner(System.in);
	    	
	    	int max = 0;
	    	int temp = 0;
	    	for(int i=1;i<=9;i++) {
	    		
		        int A = in.nextInt();
	    	
		        if(A > max) {
		     
		        	max = A;
		            temp = i;
		        }
		     
	    	}
	        
	    	
	    	System.out.println(max);
	    	System.out.println(temp);

	    	
	    }
	}
