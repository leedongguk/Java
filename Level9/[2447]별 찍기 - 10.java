import java.util.Scanner;

public class Main {
	  static char[][] arr;

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt();
	        arr = new char[N][N];
	        StringBuilder text = new StringBuilder();

	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                arr[i][j] = ' ';
	            }
	        }

	        star(0, 0, N);

	        for (int i = 0; i < N; i++) {
	            for (int j = 0; j < N; j++) {
	                text.append(arr[i][j]);
	            }
	            text.append("\n");
	        }

	        System.out.println(text);
	    }

	    public static void star(int x, int y, int n) {
	        if (n == 1) {
	            arr[x][y] = '*';
	            return;
	        }

	        n /= 3;

	        for (int i = 0; i < 3; i++) {
	           for (int j = 0; j < 3; j++) {
	               if (i == 1 && j == 1) {
	                   continue;
	               }

	               star(x + (i * n), y + (j * n), n);
	           }
	        }
	    }
}
