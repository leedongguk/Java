import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int A = in.nextInt();
		int B = in.nextInt();
		int C = in.nextInt();
		int D = 0;
		
		D = A*60 + B + C;
		A = D/60;
		B = D%60;
		
		if(A>=24) {		
			A = A - 24;
		}

		System.out.println(A + " " + B);
		
	}
}
