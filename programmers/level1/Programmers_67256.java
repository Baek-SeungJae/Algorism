package programmers.level1;

class Programmers_67256
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		System.out.println(solution(numbers,hand));
		
	}
	
	public static String solution(int[] numbers, String hand) {
	    StringBuilder sb = new StringBuilder();
	    int right = -2;
	    int left = -1;
	    for(int i = 0; i < numbers.length; i++){
	        switch(numbers[i]){
	            case 1:
	            case 4:
	            case 7:
	                left = numbers[i];
	                sb.append('L');
	                break;
	            case 3:
	            case 6:
	            case 9:
	                right = numbers[i];
	                sb.append('R');
	                break;
	            case 2:
	            case 5:
	            case 8:
	            case 0:
	                if(distance(right,numbers[i]) > distance(left,numbers[i])){
	                    left = numbers[i];
	                    sb.append('L');
	                } else if (distance(right,numbers[i]) < distance(left,numbers[i])){
	                    right = numbers[i];
	                    sb.append('R');
	                } else {
	                    if(hand.equals("right")){
	                       right = numbers[i];
	                       sb.append('R');
	                    } else {
	                        left = numbers[i];
	                        sb.append('L');
	                    }
	                }
	        }
	    }
        String answer = sb.toString();
        return answer;
    }
    
    public static int distance(int start, int dest){
        int[] s = yx(start);
        int[] d = yx(dest);
        
        int row = Math.abs(s[1] - d[1]);
        int col = Math.abs(s[0] - d[0]);
        return row+col;
    }
    
    public static int[] yx(int number){
        int y;
        int x;
        if(number>0){
            number -= 1;
            y = number/3;
            x= number%3;
        } else if(number==0){
            y=3;
            x=1;
        } else if (number==-1){
            y = 3;
            x = 0;
        } else if (number==-2){
            y=3;
            x=2;
        } else{
            y=0;
            x=0;
        }
        return new int[]{y,x};
    }
}
