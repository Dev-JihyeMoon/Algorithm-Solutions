import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int[][] board;
	static int countWhite = 0, countBlue = 0;
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		board = new int[n][n];
		
		for(int i=0; i<n; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		func(0, 0, n);
		
		System.out.print(countWhite+"\n"+countBlue);
		
		br.close();
		
	}
	
	public static void func(int x, int y, int size) {
		boolean check = true;
		int mode = board[x][y];
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(mode != board[i][j]) {
					check = false;
					break;
				}
				
				if(!check) {
					break;
				}
			}
		}
		
		if(check) {
			if(mode == 0) {
				countWhite++;
				return;
			} else {
				countBlue++;
				return;
			}
		} else {
			int newSize = size/2;
			func(x, y, newSize);
			func(x+newSize, y, newSize);
			func(x, y+newSize, newSize);
			func(x+newSize, y+newSize, newSize);
		}
	}
		
}