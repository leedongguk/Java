import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			int N = in.nextInt();
			if(N == 0) break;
			int count = 0;
			int SW = 0;
			for(int i = N + 1; i <= N * 2; i++) {
				int root = (int)Math.sqrt(i) + 1;
				for(int j = 2; j < root; j++) {
					if(i % j == 0) {
						SW = 1;
						break;
					}
				}
				if(SW == 0) count++;
				SW = 0;
			}
			System.out.println(count);
		}
	}

}
