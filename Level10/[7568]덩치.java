import java.util.Scanner;

public class Main {
	    public static void main(String[] args) {
	    	
	        Scanner in = new Scanner(System.in);
	 
	        int N = in.nextInt();
	        int[][] info = new int[N][2];
	        
	        for(int i =0; i < N; i++) {
	        	info[i][0] = in.nextInt();
	        	info[i][1] = in.nextInt();
	        }
	        
	        for(int i=0; i < N; i++) {
	        	int rank = 1;
	        	
	        	for(int j=0; j<N;j++) {
	        		
	        		if(info[i][0] < info[j][0] && info[i][1] < info[j][1]) {
	        			rank++;
	        		}
	        		
	        	}
	        	System.out.println(rank);
	        }
	        System.out.println();
	    }
	        
	    
}
