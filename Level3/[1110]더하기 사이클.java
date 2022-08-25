import java.util.Scanner;

	public class Main {
	    public static void main(String[] args) {

	    	Scanner in = new Scanner(System.in);
	        
	    	int n;
	    	int a, b, c, d, e;
	    	int sum = 0;
	    	
	        int A = in.nextInt();
	    	
	        e= A;
	        
	    while(true){

	   
	    	sum += 1;

	    	
	    	a = A %10; //두번째자리
	    	b = (A - a)/10;//첫번째자리
	    	c = a + b;//덧셈값
	    	d = (a*10) + (c%10);

	    	if(e==d){
	    	    System.out.println(sum);
	    		break;
	    	}
	    	else if(e!=d){
	    	 A = d;	
	    	}
	    		  
	    }

	    	
	    	
	    }
	}
