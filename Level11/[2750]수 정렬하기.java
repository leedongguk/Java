import java.util.Scanner;

public class Main {
	
	 public static void main(String[] args) {
		 
	      Scanner in =new Scanner(System.in);
	      
	      int N = in.nextInt();
	      int[] arr = new int[N];
	      
	      for(int i=0;i<N;i++) {
	    	  arr[i] = in.nextInt();
	      }
	      
	      for(int i = 0; i < arr.length - 1; i++) {
	    		for(int j = i + 1; j < arr.length; j++) {
	    	    
	    			if(arr[i] > arr[j]) {
	    				// 값 교환
	    				int temp = arr[j];
	    				arr[j] = arr[i];
	    				arr[i] = temp;
	    			}
	    		}
	    	}
	      
	      
	      for(int i=0;i<N;i++) {
	    	  System.out.println(arr[i]);
	      }
           


 
	   }

	
}
