package programmers.level2;

public class programmers_12945 {

    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 5;
        System.out.println(solution(n1));
        System.out.println(solution(n2));
    }

    public static int solution(int n) {
        int[] fibo = new int[n + 1];

        fibo[0] = 0;
        fibo[1] = 1;

        for (int i = 2; i <= n; i++) {
            fibo[i] = (fibo[i - 1] % 1234567) + (fibo[i - 2] % 1234567);
        }

        return fibo[fibo.length - 1] % 1234567;
    }
}
