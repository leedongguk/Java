import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String args[]) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer br = new StringTokenizer(in.readLine(), " ");
        
        int a = Integer.parseInt(br.nextToken());
        int b = Integer.parseInt(br.nextToken());
        int v = Integer.parseInt(br.nextToken());
        
        int days = (v-a) / (a-b);
        if((v - a) % (a-b) != 0)
            days++;
        System.out.println(days+1);
    }
	
}
