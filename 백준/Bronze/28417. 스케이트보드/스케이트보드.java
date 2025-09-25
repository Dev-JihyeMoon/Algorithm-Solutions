import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int[] run = new int[2];
        int[] trick = new int[5];
        int score = 0;
        int highScore = 0;

        for (int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                run[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(run);

            for (int j = 0; j < 5; j++) {
                trick[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(trick);

            score = run[1] + trick[3] + trick[4];
            highScore = (int) Math.max(highScore, score);
        }

        sb.append(highScore);
        System.out.println(sb.toString());
    }
}