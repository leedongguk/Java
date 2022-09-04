import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	   public static void main(String[] args) {
           
		   Scanner in = new Scanner(System.in);
           int N = in.nextInt();
           int[] arr = new int[N];
           int[] arrClone;
           
          Map<Integer, Integer> map = new HashMap<>();
          int count = 0;
          StringBuilder sb = new StringBuilder();
          
           for(int i=0;i<N;i++){
               arr[i] = in.nextInt();
           }
           
           arrClone = arr.clone();
           
           Arrays.parallelSort(arrClone);
           
           for(int i = 0; i < arrClone.length;i++) {
        	   if(!map.containsKey(arrClone[i])) {
        		   map.put(arrClone[i], count++);
        	   }
           }
           
           for(int i=0; i<arr.length;i++) {
        	   sb.append(map.get(arr[i])).append(" ");
           }
           
           System.out.println(sb);           
           
	   }
}
