import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int[] map = new int[10];
		int temp;
		int count = 0;
		
		for(int i =0;i<map.length;i++){
			map[i] = in.nextInt();
			map[i] = map[i] % 42;
		}
		
		for(int i=0;i<map.length;i++){
			temp = 0;
			for(int j=i+1;j<map.length;j++) {
				
				if(map[i]==map[j]) {
					temp= temp + 1;
				}
			}
			
		      if(temp == 0) {
		          count ++;
		        }
			
		}
		
		System.out.println(count);
		
		
	}
}
