package programmers;

public class Programmers_17682 {
	public static void main(String[] args) {
		String dartResult = "1S*2T*3S";
		solution(dartResult);
	}

	public static int solution(String dartResult) {
		dartResult = dartResult.replace("S", ",S,");
		dartResult = dartResult.replace("D", ",D,");
		dartResult = dartResult.replace("T", ",T,");
		dartResult = dartResult.replace("*", ",*,");
		dartResult = dartResult.replace("#", ",#,");
		dartResult = dartResult.replace(",,", ",");

		String[] strArr = dartResult.split(",");

		int sum[] = new int[4];
		int sumindex=0;
		int temp = 0;
		for (int i = 0; i < strArr.length; i++) {
			try {
				Integer.parseInt(strArr[i]);
				sum[sumindex] += temp;
				temp = 0;
				temp = Integer.parseInt(strArr[i]);
				sumindex++;
			} catch (NumberFormatException e) {
				if (strArr[i].equals("S")) {
					temp = temp;
				} else if (strArr[i].equals("D")) {
					temp = (int) Math.pow(temp, 2);
				} else if (strArr[i].equals("T")) {
					temp = (int) Math.pow(temp, 3);
				} else if (strArr[i].equals("*")) {
					temp = temp * 2;
					sum[sumindex-1] *=2;
				} else if (strArr[i].equals("#")) {
					temp = temp * -1;
				}
			}
		}
		sum[3] = temp;
		int answer = sum[1]+sum[2]+sum[3];
		System.out.println(answer);
		return answer;
	}
}