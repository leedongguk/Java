import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.lang.StringBuilder;

public class Main {
	   public static void main(String[] args) throws IOException{
           
	   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	   StringBuilder st = new StringBuilder();
	   
	   int N = Integer.parseInt(reader.readLine());
	   int[] arr = new int[N];
	   
	   String[] temp = reader.readLine().split(" ");
	   
	   for(int i=0; i<N;i++) {
		   arr[i] = Integer.parseInt(temp[i]);
	   }
	   
	   int M = Integer.parseInt(reader.readLine());
	   int[] target = new int[M];
	   temp = reader.readLine().split(" ");
	   
	   for(int i=0;i<M;i++) {
		   target[i] = Integer.parseInt(temp[i]);
	   }
	   
	   Arrays.sort(arr);
	   
	   for(int i = 0; i < M; i++) {
		   if(binarySearch(arr, target[i])) {
			   st.append("1 ");
		   }
		   else {
			   st.append("0 ");
		   }
	   }
	   System.out.println(st.toString());
	   }
	   
	   public static boolean binarySearch(int[] arr, int target) {
		   
		   int left = 0;
		   int right = arr.length - 1;
		   int mid;
		   
		   while(left <= right) {
			   mid = (left + right) / 2;
			   
			   if(arr[mid] < target)
				   left = mid + 1;
			   else if(arr[mid] > target)
				   right = mid - 1;
			   else
				   return true;
		   }
		   
		   
		   return false;
	   }
	   
}
