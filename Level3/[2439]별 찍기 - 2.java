import java.util.Scanner;

	public class Main {
	    public static void main(String[] args) {

	    	Scanner in = new Scanner(System.in);
	    	
	    	int A = in.nextInt();

	    	for(int i = 1; i<=A;i++) {

	    		for(int j = 1; j <= A-i; j++) {
	    			System.out.print(" ");
	    		}
	    		for(int z = 1; z <= i; z++) {
	    			System.out.print("*");
	    		}	
	    		System.out.print("\n");
	    	}
	    }
	}
