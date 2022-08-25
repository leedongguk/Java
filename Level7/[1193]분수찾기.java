import java.io.*;

public class Main {
	
	 public static void main(String[] args) throws IOException{
		 
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	      
	      int N = Integer.parseInt(in.readLine());
	      
	      int count = 0;
	      int line =0;
	      int mo = 0;//분자
	      int de = 0;//분모
	      
	      while(count<N) {
	    	  line++;
	    	  count = line * (line+1) / 2;
	      }
	      
	      if(line%2 != 0) {
	    	  mo = 1 + count - N;
	    	  de = line + N - count;
	      } else {    	  
	    	  de = 1 + count - N;
	    	  mo = line + N - count;
	      }
	      
	      System.out.println(mo + "/" + de);
	      
	   }
	
}
