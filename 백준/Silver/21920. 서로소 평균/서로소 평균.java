import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main { // 서로소 평균

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int x = Integer.parseInt(bf.readLine());

		long sum = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (gcd(arr[i], x) == 1) {
				sum += arr[i];
				cnt += 1;
			}
		}

		System.out.println(sum / (double) cnt);
	}

	private static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}