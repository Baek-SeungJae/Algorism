package programmers.level3;

public class programmers_1830_fail {

	public static void main(String[] args) {

		String sentence = "HaEaLaLaObWORLDb";
		System.out.println("HELLO WORLD : " + solution(sentence));

		String sentence2 = "SpIpGpOpNpGJqOqA";
		System.out.println("SIGONG JOA : " + solution(sentence2));

		String sentence3 = "AxAxAxAoBoBoB";
		System.out.println("invalid : " + solution(sentence3));

		String sentence4 = "HELLOWORLD";
		System.out.println("HELLOWORLD : " + solution(sentence4));

		String sentence5 = "aHbEbLbLbOacWdOdRdLdDc";
		System.out.println("HELLO WORLD : " + solution(sentence5));

		String sentence6 = "abHELLObaWORLD";
		System.out.println("invalid : " + solution(sentence6));

		String sentence7 = "cHaEaLaLcObWORLDb";
		System.out.println("HELL O WORLD : " + solution(sentence7));

	}

	public static String solution(String sentence) {
		// a = 97, z = 122
		char[] repetition = new char[26];
		StringBuilder sb = new StringBuilder();
		if (sentence.contains(" ")) {
			return "invalid";
		}
		
		int index = 0;
		while (index < sentence.length()) {
			char ch = sentence.charAt(index);
			int eow = index + 1;
			String temp;
			if (isLowerCase(ch)) {
				eow = sentence.indexOf(sentence.charAt(index), index + 1);
				temp = sentence.substring(index,eow+1);
				temp = condition1(temp, repetition);
				if(temp.equals("invalid")) {
					return "invalid";
				} else {
					temp = condition2(temp, repetition);
					if(temp.equals("invalid")) {
						return "invalid";
					} else {
						sb.append(temp);
						sb.append(' ');
						//System.out.println(temp);
					}
				}
				index = eow+1;
			} else if(eow+2<sentence.length() && isLowerCase(sentence.charAt(eow)) && sentence.charAt(eow)==sentence.charAt(eow+2) ){
				while (sentence.charAt(index + 1) == sentence.charAt(eow)) {
					eow += 2;
					if (eow >= sentence.length()) {
						break;
					}
				}
				temp = sentence.substring(index, eow);
				temp = condition2(temp,repetition);
				if(temp.equals("invalid")) {
					return "invalid";
				} else {
					sb.append(temp);
					sb.append(' ');
					///System.out.println(temp);
				}
				index = eow;
			} else {
				eow = index;
				while(sentence.charAt(eow)<97) {
					eow++;
					if(eow>=sentence.length()) {
						break;
					}
				}
				if(eow<sentence.length() && repetition[sentence.charAt(eow)-97]!=0) {
					return "invalid"; 
				}
				sb.append(sentence.substring(index,eow));
				sb.append(' ');
				index = eow+1;
			}
		}
		String answer = sb.substring(0, sb.length()-1);
		return answer;
	}

	public static boolean isLowerCase(char character) {
		if (character >= 97 && character <= 122) {
			return true;
		} else {
			return false;
		}
	}

	public static String condition1(String sentence, char[] repetition) {
		if(repetition[sentence.charAt(0)-97]!=0) {
			return "invalid";
		} else {
			repetition[sentence.charAt(0)-97]++;
			String result = sentence.substring(1, sentence.length() - 1);
			return result;
		}
		
	}

	public static String condition2(String sentence, char[] repetition) {
		StringBuilder sb = new StringBuilder();
		char[] sentenceArray = sentence.toCharArray();
		if(sentence.length()>1 && sentence.charAt(1)>=97) {
			for (int i = 0; i < sentence.length(); i += 2) {
				sb.append(sentenceArray[i]);
			}
			char compare = sentenceArray[1];
			for(int i= 1; i< sentence.length()-1; i+=2) {
				if(compare!=sentenceArray[i]) {
					return "invalid";
				}
			}
			return sb.toString();
		} else {
			if(sentence.charAt(0)>97) {
				return "invalid"; 
			}else {
				return sentence;
			}
		}
		
	}

	public static boolean checkRepetition(char[] repetition, String sentence, int index) {
		if (repetition[sentence.charAt(index) - 97] != 0) {
			return true;
		} else {
			repetition[sentence.charAt(index) - 97]++;
			return false;
		}
	}
}