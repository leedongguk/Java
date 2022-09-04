import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException {
	  
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
	  int N = Integer.parseInt(br.readLine());
	  
	  String [] arr = new String[N];
	  
	  for(int i=0;i<N;i++) {
		  arr[i] = br.readLine();
	  }
	  
	  Arrays.sort(arr, new Comparator<String>() {
		  @Override
		  public int compare(String x, String y) {
			  
			  if(x.length() == y.length()) {
				  return x.compareTo(y);
			  }
			  else {
				  return x.length() - y.length();
			  }
			  
		  }
	  });
	  
		System.out.println(arr[0]);
		for (int i = 1; i < N; i++) {
			if(!arr[i].equals(arr[i-1])) {
				System.out.println(arr[i]);
			}
		}

	  
  }
}
