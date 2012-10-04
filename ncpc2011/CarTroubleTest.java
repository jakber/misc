import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CarTroubleTest {
	public static void main(String[] args) { 
		int n = 1000;
		Random random = new Random();
		System.out.println(n);
		for (int i  = 0 ; i< n; i++) {
			List<Integer> E = new ArrayList<Integer>();
			for (int j = 0; j< n; j++) {
				if (j != i && random.nextInt(200) == 0)
				E.add(j);
			}
			System.out.print(i + " " + E.size());
			for (int e : E) System.out.print(" " +e);
			System.out.println();
		}
	}
}
