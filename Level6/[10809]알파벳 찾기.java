import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		   Scanner in = new Scanner(System.in);

		   int[] list = new int[26];	   
		   
		   for(int i=0;i<26;i++) {
			   list[i] = -1;
		   }
		   
		   String N = in.nextLine();
		   
		   for(int i=0;i<N.length();i++) {
			   
			   char a = N.charAt(i);
			   
			   if(list[(int)a - 'a']==-1) {
			   list[(int)a-'a'] = i;
			   }
		   }
		   
		   for(int i=0;i<26;i++) {
			   
			   System.out.println(list[i]);
			   
		   }
		   
		   
	   }

}
