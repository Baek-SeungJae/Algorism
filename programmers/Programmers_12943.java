package programmers;

public class Programmers_12943 {
	public static void main(String[] args) {
		int num = 626331;
		System.out.println(solution(num));
	}

	public static int solution(int num) {
        int answer = -1;
        if(num==1) {
        	return 0;
        }
        long testcase = num;
        for(int i=1; i<=500; i++) {
        	if(testcase%2==0) {
        		testcase = testcase/2;
        	} else {
        		testcase = testcase*3 +1;
        	}
        	if(testcase==1) {
        		answer = i;
        		break;
        	}
        }
        return answer;
    }
}