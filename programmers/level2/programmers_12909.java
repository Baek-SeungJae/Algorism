package programmers.level2;

public class programmers_12909 {

    public static void main(String[] args) {
        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));

    }

    public static boolean solution(String s) {
        int check = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                check++;
            } else {
                check--;
            }
            if (check < 0) {
                return false;
            }
        }
        if (check == 0) {
            return true;
        } else {
            return false;
        }
    }
}
