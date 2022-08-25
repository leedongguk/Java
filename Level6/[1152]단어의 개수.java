import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {

		   Scanner in = new Scanner(System.in);
		   
		   String s = in.nextLine();
		   
			StringTokenizer st = new StringTokenizer(s," ");
			
			// countTokens() 는 토큰의 개수를 반환한다
			System.out.println(st.countTokens());	
		   
		   
	   }

}
