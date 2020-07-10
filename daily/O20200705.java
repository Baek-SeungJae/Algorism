package dally;

public class O20200705 {

	public static void main(String[] args) {
		int input = 64;
		System.out.println(solution(input));
	}
	
	public static boolean solution(int input) {
		
		while(input>1) {
			if(input % 4 !=0) {
				return false;
			}
			input /=4; 
			if(input==1) {
				return true;
			}
		}
		return false;
	}

}
