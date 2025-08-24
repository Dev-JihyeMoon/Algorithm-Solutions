import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static char[][] chess;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		//체스판 입력
		chess = new char[n][m];
		for(int i=0; i<n; i++) {
			String inputChess = br.readLine();
			
			for(int j=0; j<m; j++) {
				chess[i][j] = inputChess.charAt(j);
			}
		}
		
		//8*8로 구하는 부분 필요.
		int min = painting(0, 0);
		for(int i=0; i<=n-8; i++) {
			for(int j=0; j<=m-8; j++) {
				int now = painting(i, j);
				if(min>now) {
					min = now;
				}
			}
		}
		
		System.out.println(min);		
		br.close();
	}
	
	public static int painting(int x, int y) {
		
		int countW = 0, countB = 0;
		
		for(int i=0; i<8; i++) {
			for(int j=0; j<8; j++) {
				char now = chess[x+i][y+j];
				//체스판의 짝수 라인
				if(i%2 == 0) {
					if(j%2==0) {
						//white 시작
						if(now=='B') {
							countW++;
						} 
						//black 시작
						else {
							countB++;
						}
					} else {
						//white 시작
						if(now=='W') {
							countW++;
						} 
						//black 시작
						else {
							countB++;
						}
					}
				} else {
					if(j%2==0) {
						//white 시작
						if(now=='W') {
							countW++;
						} 
						//black 시작
						else {
							countB++;
						}
					} else {
						//white 시작
						if(now=='B') {
							countW++;
						} 
						//black 시작
						else {
							countB++;
						}
					}
				}
				
			}
		}
		
		return countW<countB?countW:countB;
	}
}