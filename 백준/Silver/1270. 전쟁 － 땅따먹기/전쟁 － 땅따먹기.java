import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			String[] war = br.readLine().split(" ");
			
			bw.write(solution(war)+"\n");
 		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static String solution(String[] war) {
		int t = Integer.parseInt(war[0]);
		String output = "";
		HashMap<String, Integer> map = new HashMap<>();
		
		for(int i=1; i<=t; i++) {
			if(map.containsKey(war[i])) {
				map.put(war[i], map.get(war[i])+1);
				
				if((t/2) < map.get(war[i])) {
					output = war[i];
					break;
				}
			} else {
				map.put(war[i], 1);
			}
		}
		
		if(output == "") {
			return "SYJKGW";
		} else {
			return output;
		}
	}
}
