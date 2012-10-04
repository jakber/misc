import java.util.Random;


public class RobotsTest {
	public static void main(String[] args) {
		int n = 1000;
		System.out.println(n);
	
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(random.nextInt(10)== 0 ? "#": ".");
			}
			System.out.println();
		}
	}
}
