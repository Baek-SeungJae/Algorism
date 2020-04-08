package line;

public class exam03 {

	public static void main(String[] args) {
		String road = "111011110011111011111100011111";
		int n = 3;
		System.out.println(solution(road, n));

	}

	public static int solution(String road, int n) {
		StringBuffer temp = new StringBuffer(road);
		int max = 0;

		while (true) {
			int firstzero = 0;
			for (int i = 0; i < n; i++) {
				if (i == 0)
					firstzero = temp.indexOf("0");
				try {
					temp.setCharAt(temp.indexOf("0"), '1');
					if (temp.indexOf("0") == -1) {
						if (temp.length() > max)
							max = temp.length();
					} else {
						if (temp.indexOf("0") > max)
							max = temp.indexOf("0");
					}

				} catch (Exception e) {
				}
			}
			temp.delete(0, temp.length());
			temp.append(road);
			road = temp.delete(0, firstzero + 1).toString();
			if (temp.indexOf("0") == -1)
				break;
		}
		int answer = max;
		return answer;
	}

}
