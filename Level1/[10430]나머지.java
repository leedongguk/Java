import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
    
		int A,B,C;
		
		Scanner An = new Scanner(System.in);
	
		A = An.nextInt();
		B = An.nextInt();
		C = An.nextInt();
		
		System.out.println((A+B)%C);
		System.out.println(((A%C) + (B%C))%C);
		System.out.println((A*B)%C);
		System.out.println(((A%C) * (B%C))%C );
		
	}
}
