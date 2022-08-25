import java.util.Scanner;

	public class Main {
	    public static void main(String[] args) {

	    	Scanner in = new Scanner(System.in);
	    	
	        int N = in.nextInt();
	        int[] map = new int[N];
	        
	        int max=-1000001;
	        int min=1000001;
	        
	        for(int i =0; i <N; i++) {
	        	map[i] = in.nextInt();
	        	
	        	if(map[i]>max) {
	        		max = map[i];
	        	}
	        	if(map[i]<min) {
	        		min = map[i];
	        	}	        	
	        	
	        }
	        
	        System.out.println(min + " " + max);
	    	
	    	
	    }
	}
