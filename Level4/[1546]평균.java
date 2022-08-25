import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		float[] map = new float[N];
		float max = 0;
		float avg = 0;
		
		for(int i=0; i<map.length; i++) {
			map[i] = in.nextInt();
			if(map[i]>max) {
				max = map[i];
			}
		}
		
		for(int j=0; j<map.length; j++) {
			avg += (map[j]/max*100)/N;
		}
		System.out.println(avg);
	}
}
