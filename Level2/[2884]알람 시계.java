import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int A = in.nextInt();
		int B = in.nextInt();
		
		if(B<45) {
			
			A = A - 1;
		    if(A<0) {
		    	A = 23;
		    }
			B = (B - 45) + 60;
			System.out.print(A + " " + B);
		
		}
		else{
			System.out.print(A + " " + (B - 45));
		}					
	}
}
