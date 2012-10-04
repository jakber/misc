import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Pattern;


public class Ls {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String P = in.readLine();
		
		int N = Integer.parseInt(in.readLine());
		
		//P = P.replace(".", "\\.");
		//P = P.replace("*", ".*");
		
		//Pattern pattern = Pattern.compile(P);
		
		
		
		for (int i = 0; i< N; i++) {
			String file = in.readLine();
			//if (file.matches(P)) System.out.println(file);
			//if (pattern.matcher(file).matches()) System.out.println(file);
			Set<Integer> positions = new HashSet<Integer>();
			positions.add(0);
			for (int k = 0; k < P.length() && P.charAt(k) == '*'; k++) positions.add(k+1);
			//System.out.println(file);
			
			for (int j = 0; j < file.length(); j++) {
				Set<Integer> prevPos = new HashSet<Integer>(positions);
				//System.out.print(file +"\t" +file.charAt(j) + " " +positions);
				positions.clear();
				for (Integer pos : prevPos) {
					if (pos >= P.length()) continue;
					if (P.charAt(pos) == '*') positions.add(pos);
					if (P.charAt(pos) == '*' || P.charAt(pos) == file.charAt(j)) {
						positions.add(pos+1);
						for (int k = pos+1; k < P.length() && P.charAt(k) == '*' ; k++) positions.add(k+1);
					}
				}
				//System.out.println(positions);
			}
			if (positions.contains(P.length())) System.out.println(file);
		}
	}
	
}
