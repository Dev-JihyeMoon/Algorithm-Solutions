import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int[][] paper = new int[100][100];
	
	int output = 0; 

	int count = Integer.parseInt(br.readLine());
	for(int i=0; i<count; i++) {
		String[] input = br.readLine().split(" ");
		
		int x = Integer.parseInt(input[0]);
		int y = Integer.parseInt(input[1]);
		
		for(int j=0; j<10; j++) {
			for(int k=0; k<10; k++) {
				paper[x+j][y+k] = 1;
			}
		}
	}
	
	for(int i=0; i<100; i++) {
		for(int j=0; j<100; j++) {
			if(paper[i][j] != 0)
				output++;
		}
	}
	
	System.out.print(output);
	
	br.close();
	}

}
