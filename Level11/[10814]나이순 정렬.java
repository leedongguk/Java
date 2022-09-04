import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	   public static void main(String[] args) {
           Scanner in = new Scanner(System.in);
           int N = in.nextInt();
           String[][] arr = new String[N][2];

           for(int i=0;i<N;i++){
               arr[i][0] = in.next();
               arr[i][1] = in.next();
           }

           Arrays.sort(arr, new Comparator<String[]>() {
               @Override
               public int compare(String[] x, String[] y) {
                   return Integer.parseInt(x[0]) - Integer.parseInt(y[0]);
               }
           });

           for(int i=0;i<N;i++)
               System.out.println(arr[i][0]+" "+arr[i][1]);
   }
}
