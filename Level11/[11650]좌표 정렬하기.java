import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
	  
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
	  int N = Integer.parseInt(br.readLine());
	  
	  int[][] position = new int[N][2];
	  
	  for(int i=0;i<N;i++) {
		  String[] str = br.readLine().split(" ");
		  for(int j=0;j<2;j++) {
			  position[i][j] = Integer.parseInt(str[j]);
		  }
	  }
	  
	  Arrays.sort(position, (a, b) -> {
		  
		  if(a[0] == b[0]) {
			  return a[1] - b[1];
		  } else {
			  return a[0] - b[0];
		  }
		  
	  });
	  
	  for(int i=0; i<N;i++) {
		  System.out.println(position[i][0] + " " + position[i][1]);  
	  }
	  
	  
	  /*수정 전
	  for(int i=0;i<N;i++) {
		  for(int j=i+1;j<N;j++) {
			  
			  if(position[i][0] > position[j][0]) {
				  temp = position[i][0];
				  position[i][0] = position[j][0];
				  position[j][0] = temp;
				  
				  temp = position[i][1];
				  position[i][1] = position[j][1];
				  position[j][1] = temp;
				  
			  }
			  else if(position[i][0] == position[j][0] && position[i][1] > position[j][1]) {
				  
				  temp = position[i][0];
				  position[i][0] = position[j][0];
				  position[j][0] = temp;
				  
				  temp = position[i][1];
				  position[i][1] = position[j][1];
				  position[j][1] = temp;
				  
			  }
			  
		  }
	  }
	  
	  for(int i=0;i<N;i++) {
		  for(int j=0;j<2;j++) {
			  System.out.print(position[i][j] + " ");
	  }
		  System.out.print("\n");
	  }
	  */
	  
  }
}
