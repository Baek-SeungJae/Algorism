import java.util.HashSet;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		String problem = sc.next();
		exam01 ex01 = new exam01();
		ex01.solve(N, M, problem);
		
		
	}
}
