import java.util.Scanner;
import java.util.*;

public class Main {
    public static int count =0;
    public static StringBuilder array = new StringBuilder();
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        hanoi(n,1,2,3);
        array.insert(0,count + "\n");
        System.out.println(array);
		
	}
 
	public static void hanoi(int num, int a, int b, int c) {
		if(num == 1) {
			array.append(a +" " + c+"\n");
			count++;
		}
		
        else {
            hanoi(num-1,a,c,b);
            array.append(a + " "+c+"\n");
            count++;
            hanoi(num-1,b,a,c);
        }
	}
}
