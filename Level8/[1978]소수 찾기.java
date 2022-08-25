import java.util.Scanner;

public class Main {
	
	 public static void main(String[] args) {
		 
	      Scanner in =new Scanner(System.in);
	      
	      int N = in.nextInt();
	      int[] arr = new int[N];
	      int temp = 0;
	      
	      for(int i=0;i<N;i++) {
	    	  arr[i] = in.nextInt();
	    	  temp += search(arr[i]);  
	      }
	      
	      System.out.println(temp);
           
	   }
	 
	 public static int search(int a) {
		 
		 int result = 0;
		 int count = 0;
		 
         for (int j =2; j<=a; j++) {
             if (a % j ==0) {
                 count++;
             }
         }
         
         if(count == 1) {
        	 result++;
         }
             
		 
		return result;
		 
	 }

	
}
