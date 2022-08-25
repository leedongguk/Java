import java.util.Scanner;

public class Main {

	   public static void main(String[] args) {

		   Scanner in = new Scanner(System.in);
		   
		   
		   int N = in.nextInt();
		   
		   
		   for(int i=0;i<N;i++) {
			
		   int input = in.nextInt();
		   float sum = 0;
		   float avg = 0;
		   int[] score = new int[input];
		   
		     for(int j=0;j<input;j++) {
		    	 
		       score[j] = in.nextInt(); 
		       sum += score[j];   
		       
		     }
		     
		     avg = sum / input;
		     
		     int stack = 0;
		     for(int z=0;z<input;z++) {
		    	 
		    	 if(score[z] > avg) {
		    		 stack++;
		    	 }
		    	 
		     }
		   
		     System.out.printf("%.3f%%\n", ((float)stack/input)*100);
			   
		   }//first for
		 
		
		   
	   }
}
