package programmers.level2;

public class programmers_12911 {

    public static void main(String[] args) {
        int n1 = 78;
        int n2 = 15;

        System.out.println(solution(n1));
        System.out.println(solution(n2));

    }

    public static int solution(int n) {

        int origin = countOne(Integer.toBinaryString(n));
        int dest = -1;
        while(origin!=dest){
            n++;
            dest = countOne(Integer.toBinaryString(n));
        }

        int answer = n;
        return answer;
    }

    public static int countOne(String bin){
        int count = 0;
        for(int i=0; i< bin.length(); i++){
            if(bin.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
}
