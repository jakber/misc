import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class Deathknight {

	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		int n = Integer.parseInt(line);
		int count = 0;
		for (int i = 0; i< n; i++) {
			String battle = in.readLine();
			if (!battle.contains("CD")) count++;
		}
		System.out.println(count);
	}
	
}
