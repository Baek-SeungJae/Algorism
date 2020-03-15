package kakaoTest_2019;

public class Exam04 {

	public static void main(String[] args) {
		long[] input = {2,5};
		long k = 5;
		solution(k, input);
	}

	public static long[] solution(long k, long[] room_number) {

		long[] temp = new long[(int)k+1];
		boolean[] check = new boolean[(int)k+1]; // false�� ���
		boolean loopcheck = false;
		for (int i = 0; i < room_number.length; i++) {
				if (!check[(int) room_number[i] - 1]) {

					temp[i] = room_number[i];
					check[(int) room_number[i] - 1] = true;
				}

		}
		while (!loopcheck) {
			loopcheck = false;
			
				for (int i = 0; i < room_number.length; i++) {
					if (temp[i] == 0) {
						for (int j = (int) room_number[i]; j < temp.length; j++) {
							if (!check[j - 1]) {
								temp[i] = j;
								check[j - 1] = true;

								break;
							} else {
							}
						}
					}
					loopcheck = loopcheck || check[i];
				}
		}

		long[] answer = new long[room_number.length];
		for(int i=0; i<room_number.length;i++)
		{
			answer[i] = temp[i];
		}
		for (int i = 0; i < room_number.length; i++) {
			System.out.println(answer[i]);
		}
		return answer;
	}
}
