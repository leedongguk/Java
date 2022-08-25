import java.util.Scanner;
import java.util.Arrays;

public class Main {

	   public static void main(String[] args) {

		   Scanner in = new Scanner(System.in);
		   
		   
		   int N = in.nextInt();
		   
		   char[] OX = new char[80];
		   int[] sum = new int[N];
		   
		   for(int i=0; i<N;i++) {
			
			   String scanner = in.next();
			   int stack = 0;
			   
			   for(int j=0;j<scanner.length();j++) {
				   OX[j] = scanner.charAt(j);
				
				   if(OX[j]=='O') {
					   ++stack;
					   sum[i] += stack;
				   }
				   else if(OX[j]=='X') {
					   stack = 0;
				   }
				   
			   }
			   
		   }
		   
		   for(int z =0;z<N;z++) {
			   System.out.println(sum[z]);
		   }
		   
		   
	   }
}
