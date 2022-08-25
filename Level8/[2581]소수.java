import java.util.Scanner;

public class Main {
	
	 public static void main(String[] args) {
		 
	      Scanner in =new Scanner(System.in);
	      
	      int start = in.nextInt();
	      int N = in.nextInt();
	      int[] arr = new int[N];
	      int temp = 0;
	      int sum = 0;
	      int min = 10000;
	      for(int i=start;i<=N;i++) {
	    	  arr[i-start] = i;
	    	  sum += search(i);
	    	  
	    	  if(search(i)<=min && search(i) != 0) {
	    		  min = search(i);
	    	  }
	      }
	      
	      if(sum !=0) {
	      System.out.println(sum);
	      System.out.println(min);
	      }
	      else {
		      System.out.println(-1);  
	      }
	   }
	 
	 public static int search(int a) {
		 
		 int count = 0;
		 
         for (int j =2; j<=a; j++) {
             if (a % j ==0) {
                 count++;
             }
         }
         
         if(count == 1) {
        	 return a;
         }
         else {
        	 return 0;
         }
		 
	 }

	
}
