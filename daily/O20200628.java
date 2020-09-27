package daily;

public class O20200628 {

	public static void main(String[] args) {
		int[] input = new int[] {-40, -30, -20, 2};
		System.out.println(solution(input));
	}
	public static int solution(int[] input) {
		int index = input.length/2;
		while(true) {
			if(input[index]==index) {
				return index;
			} else if(input[index]>index) {
				index = index/2;
				if(index == index/2) {
					return -1;
				}
			} else {
				index = (input.length+index)/2;
				if(index == (input.length+index)/2) {
					return -1;
				}
			}
		}
	}

}
