import java.util.Scanner;

	public class Main {
	    public static void main(String[] args) {

	    	Scanner in = new Scanner(System.in);
	 
	    	int A = in.nextInt();
	    	int B = in.nextInt();
	    	int temp = 0;
	    	int[] map = new int[A];
	        int[] map2 = new int[A];
	    	
	    	for(int i = 1; i<=A;i++) {

	    		map[i-1] = in.nextInt();
	    		if(map[i-1] < B) {
	    			map2[temp] = map[i-1];
	    			temp++;
	    		}
	    	}
	    	
	    	for(int i = 0; i < temp; i++) {
	    		
	    		System.out.print(map2[i]+" ");
	    		
	    	}
	    	
	    }
	}
