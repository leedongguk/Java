import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		   Scanner in = new Scanner(System.in);
		   
		    int n = Integer.parseInt(in.next());
		    int count = n;

		    for (int i = 0; i < n; i++) {
		      String str = in.next();
		      int[] arr = new int[26];
		      for (int j = 0; j < str.length(); j++) {
		        if (arr[str.charAt(j) - 'a'] == 0) {
		          arr[str.charAt(j) - 'a']++;
		        } else if (j > 0 && str.charAt(j) != str.charAt(j - 1)) {
		          count--;
		          break;
		        }
		      }
		    }
		    System.out.println(count);
	}
	
	
}
