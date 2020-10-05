package programmers.level3;

class programmers_60059 {

	public static void main(String[] args) {

		//int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		//int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		//int[][] key = { { 0, 0 }, { 1, 1},{0,0},{0,0} };
		//int[][] lock = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

		int[][] key = { {1},{1} };
		int[][] lock = { { 1, 1, 1 }, { 1,1,1 }, { 1,1,1 }};
		System.out.println(solution(key, lock));
	}

	public static boolean solution(int[][] key, int[][] lock) {
		for (int i = 0; i < 1; i++) {
			if (compare(key, lock)) {
				return true;
			}
			key = rotate(key);
		}
		return false;
	}

	public static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[0].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int[][] rotate(int[][] array) { // 배열 회전
		int[][] rotated = new int[array[0].length][array.length];
		for (int i = 0; i < rotated.length; i++) {
			for (int j = 0; j < rotated[0].length; j++) {
				rotated[i][j] = array[rotated[0].length - 1 - j][i];
			}
		}
		return rotated;
	}

	public static boolean compare(int[][] key, int[][] lock) {
		boolean result = false;
		int[][] temp = keyReset(lock);
		for (int l = -key.length; l < lock.length; l++) {
			for (int k = -key[0].length; k < lock[0].length; k++) {
				for (int i = 0; i < lock.length; i++) {
					for (int j = 0; j < lock[0].length; j++) {
						try {
							temp[i][j] = lock[i][j] + key[i - l][j - k];
						} catch (ArrayIndexOutOfBoundsException e) {
							continue;
						}
					}
				}
				print(temp);
				if (check_lock(temp)) {
					//return true;
				}
				temp = keyReset(lock);
			}
		}
		return result;
	}

	public static int[][] keyReset(int[][] key) {
		int[][] result = key.clone();
		for (int i = 0; i < key.length; i++)
			result[i] = key[i].clone();
		return result;
	}

	public static boolean check_lock(int[][] temp) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[0].length; j++) {
				if (temp[i][j] != 1)
					return false;
			}
		}
		return true;
	}
}