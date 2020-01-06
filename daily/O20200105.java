package daily;
import java.util.HashSet;
public class O20200105 {
	public static void main(String[] args) {
		int max=0;
		int temp=0;
		String input = "abbbcedd";
		char[] chararr = input.toCharArray();
		int inputsize= input.length();
		HashSet<Character> set = new HashSet<Character>();
		for(int i=0; i<inputsize; i++)
		{
			if(set.contains(chararr[i]))
			{
				char t = chararr[i];
				if(temp>max)
					max=temp;
				temp=1;
				set.clear();
				set.add(t);
			}
			else {
				set.add(chararr[i]);
				temp++;
			}
		}
		System.out.println(max);
	}
}
