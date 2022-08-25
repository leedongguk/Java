import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		   Scanner in = new Scanner(System.in);
		   
		   int[] compare = new int[2];
		   int[] compare2 = new int[2];
		   
		   for(int i=0;i<2;i++) {
			   compare[i] = in.nextInt();
		       compare2[i] = trade(compare[i]);
		   }

		   System.out.println(Math.max(compare2[0], compare2[1]));
	   }

	static int trade(int input) {
		
		int trade = 0;
		int a ,b,c;
		
		b = input % 10; //1의 자리 수		
		a = input % 100 - b; // 10의 자리 수
		c= input - (b + a);
		
		trade = (b*100) + a + (c/100);
		
		return trade;
	}
	
	
}
