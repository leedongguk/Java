import java.util.Scanner;

public class Main {
	
	 public static void main(String[] args) {
		 
	    	Scanner in = new Scanner(System.in);
	    	int N, M; //시작값과 끝값
	    	N = in.nextInt();
	    	M = in.nextInt();
	    	
	    	boolean[] p = new boolean[M+1];
	    	p[1]=true;
	    	
	    	for(int i=2;i<M;i++) {
	    		for(int j=2; i*j<M+1;j++) {
	    			p[i*j]=true;
	    		}
	    	}
	    	for(int i=N; i<M+1;i++) {
	    		if(p[i]!=true) {
	    			System.out.println(i);
	    		}
	    	}

	   }
}
