package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class programmers_12951 {

    public static void main(String[] args) {
        String s1 = "3people unFollowed me";
        String s2 = "for the last week a";
        String s3 = "aaa Aaa aAa aAA AAA AAa   3a a3 A3 3A A";
        String s4 = "3peOple 3unFollowed mE";
        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));

    }

    public static String solution(String s) {
        StringBuilder sb = new StringBuilder(s);

        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));

        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == ' ') {
                if (sb.charAt(i + 1) <= 'z' && 'a' <= sb.charAt(i + 1)) {
                    sb.setCharAt(i + 1, Character.toUpperCase(sb.charAt(i + 1)));
                }
            } else {
                if (sb.charAt(i + 1) <= 'Z' && 'A' <= sb.charAt(i + 1)) {
                    sb.setCharAt(i + 1, Character.toLowerCase(sb.charAt(i + 1)));
                }
            }
        }
        System.out.println(s);
        String answer = sb.toString();
        return answer;
    }
}
