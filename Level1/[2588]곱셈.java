import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    
		int A,B;
		
		Scanner An = new Scanner(System.in);
	
		A = An.nextInt();
		B = An.nextInt();
		
		System.out.println(A*(B%10));
		System.out.println( (A*(B%100 - B%10)) / 10);
		System.out.println( A * (B - (B%100))/100);
		System.out.println( A*B);
	}
}
