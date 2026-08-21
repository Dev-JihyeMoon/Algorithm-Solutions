import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int t = Integer.parseInt(br.readLine());

		for(int i=1; i<=t; i++) {
			int n = Integer.parseInt(br.readLine());
			
			int[][] answer = snail(n);
			
			bw.write("#"+i+"\n");
			for(int[] j:answer) {
				for(int k:j) {
					bw.write(k+" ");
				}
				bw.write("\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static int[][] snail(int n){
		int[][] answer = new int[n][n];
		int x = 0, y = 0, point = n-1;
		String direction = "Right"; // Right, Left, Top, Bottom
		
		for(int i=1; i<=n*n; i++) {
			answer[y][x] = i;
			
			if(direction.equals("Right")) {
				if(x==point || answer[y][x+1] != 0) {
					direction = "Bottom";
					y++;
				} else {
					x++;
				}
			} else if(direction.equals("Left")) {
				if(x == 0 || answer[y][x-1] != 0) {
					direction = "Top";
					y--;
				} else {
					x--;
				}
			} else if(direction.equals("Bottom")) {
				if(y==point || answer[y+1][x] != 0) {
					direction = "Left";
					x--;
				} else {
					y++;
				}
			} else { // direction == "Top"
				if(y==0 || answer[y-1][x] != 0) {
					direction = "Right";
					x++;
				} else {
					y--;
				}
			}
		}
		
		return answer;
	}
}