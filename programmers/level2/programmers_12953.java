package programmers.level2;

public class programmers_12953 {

    public static void main(String[] args) {
        int[] arr1 = {2,6,8,14};
        int[] arr2 = {1,2,3};
        System.out.println(solution(arr1));
        System.out.println(solution(arr2));

    }

    public static int solution(int[] arr) {
        for(int i=0; i< arr.length-1; i++){
            arr[i+1] = lcm(arr[i], arr[i+1]);
        }
        return arr[arr.length-1];
    }
    public static int gcd(int a, int b){
        while(b!=0){
            int r = a%b;
            a= b;
            b= r;
        }
        return a;
    }

    public static int lcm(int a, int b){
        return a * b / gcd(a,b);
    }
}
