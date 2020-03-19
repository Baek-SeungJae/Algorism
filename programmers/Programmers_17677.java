package programmers;

public class Programmers_17677 {
	public static void main(String[] args) {
		String input1 = "AAAB*ABC";
		String input2 = "AAB*ABDD";
		System.out.println(solution(input1, input2));
	}

	public static int solution(String str1, String str2) {

		char[] chararr1 = str1.toUpperCase().toCharArray();
		char[] chararr2 = str2.toUpperCase().toCharArray();
		StringBuffer sb1 = new StringBuffer("");
		StringBuffer sb2 = new StringBuffer("");
		for (int i = 0; i < chararr1.length - 1; i++) {
			if ((chararr1[i] >= 'A' & chararr1[i] <= 'Z') & (chararr1[i + 1] >= 'A' & chararr1[i + 1] <= 'Z')) {
				sb1.append(chararr1[i]);
				sb1.append(chararr1[i + 1]);
				sb1.append(",");
			}
		}
		for (int i = 0; i < chararr2.length - 1; i++) {
			if ((chararr2[i] >= 'A' & chararr2[i] <= 'Z') & (chararr2[i + 1] >= 'A' & chararr2[i + 1] <= 'Z')) {
				sb2.append(chararr2[i]);
				sb2.append(chararr2[i + 1]);
				sb2.append(",");
			}
		}
		String[] set1 = sb1.toString().split(",");
		String[] set2 = sb2.toString().split(",");

		int charsize1;
		if (sb1.toString().equals("")) {
			charsize1 = 0;
		} else {
			charsize1 = sb1.toString().split(",").length;
		}
		int charsize2;

		if (sb2.toString().equals("")) {
			charsize2 = 0;
		} else {
			charsize2 = sb2.toString().split(",").length;
		}

		int total = charsize1 + charsize2;

		int inter = 0;
		for (int i = 0; i < charsize1; i++) {
			for (int j = 0; j < charsize2; j++)
				if (set1[i].equals(set2[j])) {
					set2[j] = "";
					inter++;
					break;
				}
		}
		int union = total - inter;
		double j = (double) inter / union;

		if (charsize1 == 0 && charsize2 == 0)
			j = 1;
		return (int) (65536 * j);
	}
}