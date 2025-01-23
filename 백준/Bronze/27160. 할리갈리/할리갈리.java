import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		HashMap<String, Integer> q = new HashMap<String, Integer>();
		for(int i = 0; i < n; i++) {
			String[] inputs = br.readLine().split(" ");
			if(q.get(inputs[0]) == null) {
				q.put(inputs[0], Integer.valueOf(inputs[1])); 
			}else {
				q.put(inputs[0], q.get(inputs[0]) + Integer.valueOf(inputs[1])); 
			}
		}
		
		String result = "NO";
		for(int value : q.values()) {
			if(value == 5) {
				result = "YES";
			}
		}
		
		System.out.println(result);
	}
}