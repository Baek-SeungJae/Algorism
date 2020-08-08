package programmers.DevMatching2020_3;

import java.util.LinkedList;

public class exam1 {
	static char[] dict = {'A','E','I','O','U'};
	static int order = 0;
	static int ans = 0;
	public static void main(String[] args) {
		String word = "I";
		System.out.println(solution(word));

	}
    public static int solution(String word) {
        LinkedList<Character> rePerArr = new LinkedList<Character>();   
        rePermutation(5, 5, rePerArr,word);
        
        int answer = ans;
        return answer;
    }
    private static void rePermutation(int n, int r, LinkedList<Character> rePerArr, String word) {
    	
    	StringBuilder sb = new StringBuilder("");
    	for(char i : rePerArr){
            sb.append(i);
        }
    	
        if(word.equals(sb.toString())) {
        	ans = order;
        }
        order++;
        
    	if(rePerArr.size() == r){
            return;
        }
        for(int i=0; i<n; i++){  
            rePerArr.add(dict[i]);
            rePermutation(n, r, rePerArr, word);
            rePerArr.removeLast();
 
        }
         
         
    }
}
