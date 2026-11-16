import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            char[][] map = new char[H][W];
            for (int i = 0; i < H; i++) {
                String temp = br.readLine().trim();
                for (int j = 0; j < W; j++) {
                    map[i][j] = temp.charAt(j);
                }
            }

            int rowCount = 0; // 모두 '#'인 가로줄 수
            int colCount = 0; // 모두 '#'인 세로줄 수

            // 1. 가로줄 검사
            for (int i = 0; i < H; i++) {
                boolean check = true;
                for (int j = 0; j < W; j++) {
                    if (map[i][j] == '.') {
                        check = false;
                        break;
                    }
                }
                if (check) rowCount++;
            }

            // 2. 세로줄 검사
            for (int j = 0; j < W; j++) {
                boolean check = true;
                for (int i = 0; i < H; i++) {
                    if (map[i][j] == '.') {
                        check = false;
                        break;
                    }
                }
                if (check) colCount++;
            }

            int answer = 0;
            // 모든 가로줄이 '#'이라는 뜻은 격자판 전체가 '#'으로 꽉 찼다는 의미
            if (rowCount == H) {
                answer = Math.min(H, W);
            } else {
                answer = rowCount + colCount;
            }

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
