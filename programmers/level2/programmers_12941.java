package programmers.level2;

import java.util.Arrays;

public class programmers_12941 {

    public static void main(String[] args) {
        int[] A1 = {1,4,2};
        int[] B1 = {5,4,4};
        int[] A2 = {1,2};
        int[] B2 = {3,4};
        System.out.println(solution(A1, B1));
        System.out.println(solution(A2, B2));

    }

    public static int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for(int i=0; i< A.length; i++){
            sum += A[i] * B[A.length-1-i];
        }

        return sum;
    }
}
