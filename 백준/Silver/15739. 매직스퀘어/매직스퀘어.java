import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] map;
	static boolean magic = true;
	static Set<Integer> set = new HashSet<>();
	static int sum = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		sum = N * (N * N + 1) / 2;

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				set.add(map[i][j]);
			}
		}

		// 행의 합 체크
		for(int i=0; i<N; i++) {
			int cnt = 0;
			for(int j=0; j<N; j++) {
				cnt += map[i][j];
			} if(cnt != sum) magic = false;
		}
		// 열의 합 체크
		for(int i=0; i<N; i++) {
			int cnt = 0;
			for(int j=0; j<N; j++) {
				cnt += map[j][i];
			} if(cnt != sum) magic = false;
		}
		// 대각선 합 체크 - 1
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==j) cnt += map[i][i];
			}
		} if(cnt != sum) magic = false;

		// 대각선 합 체크 - 2
		cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=N-1; j>=0; j--) {
				if(i+j == N-1) cnt += map[i][j];
			}
		} if(cnt != sum) magic = false;

		// 중복되는 수 없이 모두 다른지 체크
		if(set.size() != N*N) magic = false;

		// 출력
		if(magic) System.out.println("TRUE");
		else System.out.println("FALSE");


	}

}