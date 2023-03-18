import java.util.Scanner;

public class Main {
	
	 public static void main(String[] args) {
		 
		 Scanner in = new Scanner(System.in);
		 
		 int a = in.nextInt();//총 가격
		 int n = in.nextInt();//물건의 갯수
		 int sum = 0;
		 int x = 0;
		 int y = 0;
		 
		 for(int i = 0; i<n;i++) {
			 x = in.nextInt();
			 y = in.nextInt();
			 sum += (x*y);
		 }
		 
		 if(a==sum) {
			 System.out.println("Yes");			 
		 }
		 else {
			 System.out.println("No");
		 }
	 }
	}
