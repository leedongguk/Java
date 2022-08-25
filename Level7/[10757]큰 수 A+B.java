import java.util.Scanner;
import java.util.*;
import java.math.*;

public class Main {
	
	static String answer = "";
	
	 public static void main(String[] args) {
		 
	      Scanner in =new Scanner(System.in);
	      
	      BigInteger a = new BigInteger(in.next());
	      BigInteger b = new BigInteger(in.next());
	      
	      BigInteger c = a.add(b);
	      
	      System.out.println(c);
	      
	   }

	
}
