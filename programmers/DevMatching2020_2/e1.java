package programmers.DevMatching2020_2;

public class e1 {
	public static void main(String[] args) {
		int p = 1987;
		System.out.println(solution(p));
	}
	public static int solution(int p) {
		
		p++;
		while(true) {
			int y1 = p/1000;
			int y2 = (p/100)%10;
			int y3 = (p/10)%10;
			int y4 = p%10;
			
			if(y1!=y2 && y1!=y3 && y1!=y4 && y2 != y3 && y2 != y4 && y3!=y4) {
				break;
			}
			p++;
		}
		
        int answer = p;
        return answer;
    }
}
