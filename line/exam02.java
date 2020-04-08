package line;

public class exam02 {

	public static void main(String[] args) {
		String answer_sheet = "4132315142";
		String[] sheet = {"3241523133","4121314445","3243523133","4433325251","2412313253"};
		System.out.println(solution(answer_sheet, sheet));
	}

	public static int solution(String answer_sheet, String[] sheet) {
		int answer = 0;
		int k = 0;
		for (int i = k; i < sheet.length; i++) {
			for (int j = 0; j < sheet.length; j++) {
				if (i != j) {
					int max = compare(answer_sheet, sheet[i], sheet[j]);
					if (answer < max) {
						answer = max;
					}
				}
			}
			k++;
		}
		return answer;
	}

	public static int compare(String ans, String str1, String str2) {
		int maxlen = 0;
		int maxlentemp = 0;
		int count = 0;
		char[] ansarr = ans.toCharArray();
		char[] str1arr = str1.toCharArray();
		char[] str2arr = str2.toCharArray();

		for (int i = 0; i < ansarr.length; i++) {
			if (ansarr[i] != str1arr[i] && str1arr[i] == str2arr[i]) {
				count++;
				maxlentemp++;
				if (maxlentemp > maxlen) {
					maxlen = maxlentemp;
				}
			} else {
				maxlentemp = 0;
			}
		}
		return count + maxlen * maxlen;
	}

}
