import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		   Scanner in = new Scanner(System.in);
		   
		   int N = in.nextInt();
		   
		     for(int i =0; i<N;i++) {
			
		      int temp = in.nextInt();
			  String sc  = in.next(); 
		      
		      for(int j=0;j<sc.length();j++) {
		    	  
		         for(int z=0;z<temp;z++) {
		        	 char a = sc.charAt(j);
		        	 System.out.print(a);
		         }
		    	  
		      }
		      System.out.print("\n");
			   
		   }
		       
		   
		   
	   }

}
