import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		   Scanner in = new Scanner(System.in);
		   
		   int N = in.nextInt();
		   int sum =0;
		   String number = in.next();
		   
		   
		   for(int i=0;i<N;i++) {
			   
			   char a = number.charAt(i);
			   sum += Character.getNumericValue(a);
			   
		   }
		   
		   System.out.print(sum);
		   
	   }

}
