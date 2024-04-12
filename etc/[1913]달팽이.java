import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int x = N / 2;
        int y = N / 2;
        int mx = 1;
        int my = 1;
        int stackN = 0;

        map[x][y] = ++stackN;

        while (true) {

            if (map[0][0] == N * N) break;

            for (int i = 0; i < mx; i++) {
                if (map[0][0] == N * N) break;
                x--;
                map[x][y] = ++stackN;
            }
            mx++;

            for (int i = 0; i < my; i++) {
                if (map[0][0] == N * N) break;
                y++;
                map[x][y] = ++stackN;
            }
            my++;

            for (int i = 0; i < mx; i++) {
                if (map[0][0] == N * N) break;
                x++;
                map[x][y] = ++stackN;
            }
            mx++;

            for (int i = 0; i < my; i++) {
                if (map[0][0] == N * N) break;
                y--;
                map[x][y] = ++stackN;
            }
            my++;

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(map[i][j]).append(" ");
                if (A == map[i][j]) {
                    x = i;
                    y = j;
                }
            }
            sb.append("\n");
        }
        sb.append((x + 1)).append(" ").append((y + 1));

        System.out.print(sb.toString());

    }
}
