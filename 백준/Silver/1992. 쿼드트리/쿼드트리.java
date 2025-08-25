import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] board;
	
	public static void main(String[] args) throws IOException {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		board = new char[n][n];
		
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			
			for(int j=0; j<n; j++) {
				board[i][j] = input.charAt(j);
			}
		}
		
		String answer = func(0, 0, n);
		
		System.out.print(answer);
		
		br.close();
	}
	
	public static String func(int x, int y, int size) {
		char mode = board[x][y];
		boolean check = true;
		
		for(int i=x; i<x+size; i++) {
			for(int j=y; j<y+size; j++) {
				if(mode != board[i][j]) {
					check = false;
					break;
				}
			}
			
			if(!check) {
				break;
			}
		}
		
		if(check) {
			return String.valueOf(mode);
		} else {
			int newSize = size/2;
			
			String output = "(";
			output += func(x, y, newSize);
			output += func(x, y+newSize, newSize);
			output += func(x+newSize, y, newSize);
			output += func(x+newSize, y+newSize, newSize);
			output += ")";
			
			return output;
		}
	}
}
