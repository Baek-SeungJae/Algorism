package programmers.level1;

public class Programmers_12916 {
	public static void main(String[] args) {
		String s = "pPoooyY";
		solution(s);

	}

	public static boolean solution(String s) {
        boolean answer = true;
        int p=0;
        int y=0;
        char temp;
        for(int i=0; i<s.length();i++) {
        	temp = s.charAt(i);
        	if(temp=='p'||temp=='P') {
        		p++;
        	} else if (temp=='y'||temp=='Y') {
        		y++;
        	}
        }
        if(p==y) {
        	answer = true;
        } else {
        	answer = false;
        }
        
        return answer;
    }
}