import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
	  
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
	  int N = Integer.parseInt(br.readLine());
	  
	  int[][] position = new int[N][2];
	  
	  for(int i=0;i<N;i++) {
		  String[] str = br.readLine().split(" ");
	      position[i][0] = Integer.parseInt(str[1]);
	      position[i][1] = Integer.parseInt(str[0]);
	  }
	  
	  Arrays.sort(position, (a, b) -> {
		  
		  if(a[0] == b[0]) {
			  return a[1] - b[1];
		  } else {
			  return a[0] - b[0];
		  }
		  
	  });
	  
	  for(int i=0; i<N;i++) {
		  System.out.println(position[i][1] + " " + position[i][0]);  
	  }
	 
	  
  }
}
