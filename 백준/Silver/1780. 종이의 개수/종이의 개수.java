import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int n = Integer.parseInt(br.readLine());
		int[][] paper = new int[n][n];
		
		for(int i=0; i<n; i++) {
			paper[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		int[] count = new int[3];
		count = counting(paper, count);
		
		for(int i:count) {
			System.out.println(i);
		}
		
		br.close();
	}
	
	public static int[] counting(int[][] paper, int[] count) {
		boolean check = checking(paper);
		
		if(check) {
			count[paper[0][0]+1]++;
			return count;
		} else {
			int temp = paper.length / 3;
			
			for(int i=0; i<paper.length; i += temp) {
				for(int j=0; j<paper.length; j += temp) {
					int[][] smallPaper = new int[temp][temp];
					
					for(int k=0; k<temp; k++) {
						smallPaper[k] = Arrays.copyOfRange(paper[j+k], i, i+temp);
					}
					
					count = counting(smallPaper, count);
				}
			}
			
			return count;
		}
	}
	
	public static boolean checking(int[][] paper) {
		boolean check = true;
		int start = paper[0][0];
		for(int i=0; i<paper.length; i++) {
			for(int j=0; j<paper.length; j++) {
				if(start != paper[i][j]) {
					check = false;
					break;
				}
			}
			
			if(!check) {
				break;
			}
		}
		
		return check;
	}
}