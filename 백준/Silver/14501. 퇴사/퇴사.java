import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N];
        int[] P = new int[N];
        
        for (int i = 0; i < N; i++) {
            int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            T[i] = temp[0];
            P[i] = temp[1];
        }

        int[] dp = new int[N + 1]; // dp[i]: i일에 도달했을 때 최대 수익

        for (int i = 0; i < N; i++) {
            // 스킵: i+1일로 전파
            if (dp[i + 1] < dp[i]) dp[i + 1] = dp[i];

            // 수락: i+T[i]일로 전파 (i+T[i] <= N으로 가능)
            int end = i + T[i];
            if (end <= N) {
                int cand = dp[i] + P[i];
                if (dp[end] < cand) dp[end] = cand;
            }
        }

        System.out.println(dp[N]);
    }
}