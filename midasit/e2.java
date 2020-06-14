package midasit;

import java.util.ArrayList;
import java.util.TreeSet;

public class e2 {
	public static void main(String[] args) {
		int x = -1;
		int y = 2;
		int r = 2;
		int d = 60;
		int[][] target = { { 0, 1 }, { -1, 1 }, { 1, 0 }, { -2, 2 } };
		System.out.println(solution(x, y, r, d, target));
	}

	public static int solution(int x, int y, int r, int d, int[][] target) {
		double PI = 3.141592;
		double angle1 = -d + (180 * Math.atan2(y, x) / PI);
		double angle2 = d + (180 * Math.atan2(y, x) / PI);
		int count = 0;
		for (int i = 0; i < target.length; i++) {
			int tx = target[i][0];
			int ty = target[i][1];
			double tangle = 180 * Math.atan2(ty, tx) / PI;
			if ((int) tangle >= (int) angle1 && (int) tangle <= (int) angle2) {
				if (Math.sqrt(Math.pow(tx, 2) + Math.pow(ty, 2)) <= r) {
					System.out.println(tx + ", " + ty);
					count++;
				}
			}

		}

		return count;
	}
}
