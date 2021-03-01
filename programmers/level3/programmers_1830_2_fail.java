package programmers.level3;

import java.util.ArrayList;

public class programmers_1830_2_fail {

	public static void main(String[] args) {

		ArrayList<String> testcase = new ArrayList<>();
		ArrayList<String> answer = new ArrayList<>();
		testcase.add("HaEaLaLaObWORLDb"); answer.add("HELLO WORLD");
		testcase.add("SpIpGpOpNpGJqOqA"); answer.add("SIGONG JOA");
		testcase.add("A"); answer.add("A");
		testcase.add("HELLOWORLD"); answer.add("HELLOWORLD");
		testcase.add("aHbEbLbLbOacWdOdRdLdDc"); answer.add("HELLO WORLD");
		testcase.add("HaEaLaLObWORLDb"); answer.add("HELL O WORLD");
		testcase.add("AAA"); answer.add("AAA");
		testcase.add("aHELLOWORLDa"); answer.add("HELLOWORLD");
		testcase.add("AAAaBaAbBBBBbCcBdBdBdBcCeBfBeGgGGjGjGRvRvRvRvRvR"); answer.add("AA ABA BBBB C BBBB C BB GG GGG RRRRRR");
		testcase.add("aIaAM"); answer.add("I AM");
		testcase.add("bAaOb"); answer.add("AO");
		testcase.add("AxAxAxAoBoBoB"); answer.add("invalid");
		testcase.add("a"); answer.add("invalid");
		testcase.add("Aa"); answer.add("invalid");
		testcase.add("aA"); answer.add("invalid");
		testcase.add("HaEaLaLaOWaOaRaLaD"); answer.add("invalid");
		testcase.add("abHELLObaWORLD"); answer.add("invalid");
		testcase.add("aHELLOa bWORLDb"); answer.add("invalid");
		testcase.add("TxTxTxbAb"); answer.add("invalid"); 
		testcase.add("bTxTxTaTxTbkABaCDk"); answer.add("invalid");
		testcase.add("baHELLOabWORLD"); answer.add("invalid");
		testcase.add("AxAxAxABcBcBcB"); answer.add("AAAA BBBB");
		testcase.add("A B"); answer.add("invalid"); 
		testcase.add("oBBoA"); answer.add("BB A");
		testcase.add("AxAxAxA"); answer.add("AAAA");
		testcase.add("HaEaLaLaObWORLDbSpIpGpOpNpGJqOqAdGcWcFcDdeGfWfLeoBBoAAAAxAxAxAA"); answer.add("HELLO WORLD SIGONG J O A GWFD GWL BB AAA AAAA A");
		testcase.add("aBcAadDeEdvAvlElmEEEEm"); answer.add("BA DE A E EEEE");
		testcase.add("AcAcABaBaB"); answer.add("A A AB B B");
		testcase.add("aGbWbFbDakGnWnLk"); answer.add("GWFD GWL");
		testcase.add("aCaCa"); answer.add("invalid");
		testcase.add("xBaCbDbEbAaBx"); answer.add("invalid");
		testcase.add("AccABB"); answer.add("invalid");
		/*
		for(int i=0; i< testcase.size(); i++) {
			if(solution(testcase.get(i)).equals(answer.get(i))) {
			} else {
				System.out.println(testcase.get(i));
				System.out.println(solution(testcase.get(i)));
				System.out.println(answer.get(i));
				System.out.println();
			}
		}
		*/
		System.out.println(solution("ccABB"));
	}

	public static String solution(String sentence) {
		// a = 97, z = 122
		char[] repetition = new char[26];
		StringBuilder sb = new StringBuilder();
		if (sentence.contains(" ")) {
			return "invalid";
		}
		
		int start = 0;
		int last = sentence.length()-1;
		String temp = "";
		while(sentence.length()!=0){	
		/* 문장의 길이가 2 이상이고, 두번째 알파벳이 소문자라면 */
		if(1<sentence.length() && isLowerCase(sentence.charAt(1))) {
			/* 두 번째 알파벳이 2번조건이라면 */
			if(sentence.lastIndexOf(sentence.charAt(1))==1 || (3< sentence.length() &&sentence.charAt(1)==sentence.charAt(3))) {
				/* 0~1번째 소문자가 같다면 */
				if(sentence.charAt(0)==sentence.charAt(1)) {
					sb.append(' ');
					sentence = sentence.substring(2);
					continue;
				}
				start = 0;
				last = sentence.lastIndexOf(sentence.charAt(1))+1;
				if(sentence.length()<last+1) {
					return "invalid";
				}
				
				temp = sentence.substring(start, last+1);
				//System.out.println("2.1. "+temp);
				temp = condition2(temp, repetition);
				//System.out.println("변환 후:" + temp);
				if(temp.equals("invalid")) {
					return "invalid";
				}
				sb.append(temp);
				sb.append(' ');
				sentence= sentence.substring(last+1);
			}
			/* 두 번째 알파벳이 1번 조건의 시작점이라면 */
			else {
				
				/*첫번째 알파벳은 그냥 sb에 추가하고 통과*/
				//System.out.println("2.2.1"+sentence.charAt(0));
				sb.append(sentence.charAt(0));
				sb.append(' ');

				sentence= sentence.substring(1);
				/* 나머지는 1번조건 적용  */
				start = 0;
				last = sentence.lastIndexOf(sentence.charAt(0))+1;
				temp = sentence.substring(start, last);
				//System.out.println("2.2.2 "+temp);
				temp = condition1(temp, repetition);
				//System.out.println("변환 후:" + temp);
				if(temp.equals("invalid")) {
					return "invalid";
				}
				if(!temp.equals("")) {
					sb.append(temp);
					sb.append(' ');
				}
				sentence= sentence.substring(last);
			}
		}
		/*첫번째 알파벳이 소문자라면 */
		else if(isLowerCase(sentence.charAt(0))) {
			start = 0;
			last = sentence.lastIndexOf(sentence.charAt(0))+1;
			/*첫번째 알파벳이 소문자인데 2개가 아니라면 */
			temp = sentence.substring(start, last);
			if(sentence.indexOf(sentence.charAt(0),1)+1!=last) {
				return "invalid";
			}
			//System.out.println("1. "+temp);
			temp = condition1(temp, repetition);
			//System.out.println("변환 후:" + temp);
			if(temp.equals("invalid")) {
				return "invalid";
			}
			sb.append(temp);
			sb.append(' ');
			sentence= sentence.substring(last);
		}
		/*첫번째나 두번째 알파벳에 소문자가 없으면 */
		else {
			start = 0;
			last = 0;
			while(last<sentence.length() && !isLowerCase(sentence.charAt(last)) ){
				if(last+1<sentence.length() && isLowerCase(sentence.charAt(last+1))){
					break;
				}
				last++;
			}
			temp = sentence.substring(start, last);
			//System.out.println("3. "+temp);
			if(temp.equals("invalid")) {
				return "invalid";
			}
			sb.append(temp);
			sb.append(' ');
			sentence= sentence.substring(last);
		}
		} 
		String answer = sb.substring(0, sb.length()-1);
		return answer;
	}
	// 소문자면 true, 대문자면 false
	public static boolean isLowerCase(char character) {
		if (character >= 97 && character <= 122) {
			return true;
		} else {
			return false;
		}
	}

	// 사용한적 있는 알파벳이 나오면 invalid
	// 아니면 앞뒤로 1문자만 제거
	public static String condition1(String sentence, char[] repetition) {
		if(repetition[sentence.charAt(0)-97]!=0) {
			return "invalid";
		} else {
			repetition[sentence.charAt(0)-97]++;
			String result = sentence.substring(1, sentence.length() - 1);
			if(0<result.length() && isLowerCase(result.charAt(0))) {
				return "invalid";
			}
			result = condition2(result, repetition);
			return result;
		}
	}

	// 
	public static String condition2(String sentence, char[] repetition) {
		StringBuilder sb = new StringBuilder();
		char[] sentenceArray = sentence.toCharArray();
		if(0<sentenceArray.length && isLowerCase(sentenceArray[0]) || sentenceArray.length != 0 && isLowerCase(sentenceArray[sentenceArray.length-1])) {
			return "invalid";
		}
		
		if(sentence.length()>1 && sentence.charAt(1)>=97) {
			for (int i = 0; i < sentence.length(); i += 2) {
				sb.append(sentenceArray[i]);
			}
			char compare = sentenceArray[1];
			if(repetition[compare-97]!=0) {
				return "invalid";
			} else {
				repetition[compare-97]++;
			}
			for(int i= 1; i< sentence.length()-1; i+=2) {
				if(compare!=sentenceArray[i]) {
					return "invalid";
				}
			}
			return sb.toString();
		} else {
			if(0<sentenceArray.length && sentence.charAt(0)>97) {
				return "invalid"; 
			}else {
				return sentence;
			}
		}	
	}
}