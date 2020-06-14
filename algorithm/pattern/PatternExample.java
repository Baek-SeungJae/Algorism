package algorithm.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
	1) String클래스의 matches메소드 : 매개변수로 전달한 정규표현식에 일치하는 문자열이 있는지를 boolean으로 리턴
	2) java.util.regex패키지의 클래스를 활용
		- Pattern클래스 : 패턴을 정의할 때 사용
			CASE_INSENSITIVE : 대소문자를 정의하지 않겠다는 의미
		- Matcher클래스 : 패턴과 일치하는 문자열을 관리하는 클래스 
		- find() : 일부가 일치하는 것을 찾아 true or false를 리턴
		- start() : 매칭되는 패턴과 일치하는 문자열을 start index
		- end() : 패턴과 일치하는 문자열이 end index+1
		* group() : 패턴과 일치하는 문자열을 리턴
	3) 기호
		^
		$
		.
		|
		[]
		* : 0~여러개
		+ : 1~여러개
		? : 0~1
		.{n} : .은 임의의 한 문자 뒤에 n글자수
		xxxx{1,3} : 패턴의 개수가 1~3개 인것
		xxxx{3, } : 3 이상
*/
public class PatternExample {

	public static void main(String[] args) {
		String str = "aammavama";
		// String patternStr = "java";		// 1. 정확학 일치하는 것
		// String patternStr = "^java";		// 2. ^뒤의 문자열로 시작
		// String patternStr = "java$";		// 3. $앞의 문자열로 종료
		// String patternStr = "^\\$";		// 4. 패턴에서 사용하는 기호는 일반 문자열로 인식하지 않는다. 패턴에서 사용하는 기호를 문자열로 인식시키려면 \\를 같이 사용해야 함
		// String patternStr = "\\$$";		// 5. $로 끝나는 문자열인지 검색
		// String patternStr = ".";			// 6. .은 한 글자를 의미
		// String patternStr = "....";		// 7. 문자길이가 4
		// String patternStr = "\\.";		// 8. .이 포함된 문자열
		// String patternStr = "\\..\\.";	// 9. '. .'
		// String patternStr = "[\\.].+[\\.]";	// 10. '. .'
		//String patternStr = "[C-J]";			// C~J까지 한 글자
		//String patternStr = "[^c-j]";			// c-j를 제외
		// String patternStr = "[^a-zA-Z0-9 ]+";		// 영문자 숫자 제외
		 String patternStr = "[amv]{3,3}";			// 1. a, m, v, aa, am, av, ma, mm, mv, va, vm, vv, aaa, 등...
		// String patternStr = "[a-z0-9가-힣]+[^은는이가의에을를 ,.:()'이다''에서''에게'께'한테''보다''로서''라고''이라고''처럼''만큼''하고''이며''있다''말한다''하다']";
		// 1. 패턴을 인식
		Pattern pattern = Pattern.compile(patternStr);
		Matcher m = pattern.matcher(str);
		while(m.find()) {
			System.out.println(m.group());
		}
	}

	/* 숫자 모양에 대한 형식 검사 */
	public static boolean isNum(String str) {
		return Pattern.matches("[0-9 ]+", str);
	}

	/* 영문으로만 구성되었는지에 대한 형식 검사 */
	public static boolean isEng(String str) {
		return Pattern.matches("[a-zA-z ]+", str);
	}

	/* 한글로만 구성되었는지에 대한 형식 검사 */
	public static boolean isKor(String str) {
		return Pattern.matches("[가-힣 ㄱ-ㅎ]+", str);
	}

	/* 영문과 숫자로만 구성되었는지에 대한 형식 검사 */
	public static boolean isEngNum(String str) {
		return Pattern.matches("[a-zA-z0-9 ]+", str);
	}

	/* 한글과 숫자로만 구성되었는지에 대한 형식 검사 */
	public static boolean isKorNum(String str) {
		return Pattern.matches("[가-힣0-9ㄱ-ㅎ ]+", str);
	}

	/* 이메일 형식인지에 대한 검사 --> "아이디@도메인"의 형식을 충족해야 한다. */
	public static boolean isEmail(String str) {
		return Pattern.matches("[a-zA-Z0-9]+[@][a-zA-Z0-9]+[\\.][a-z]+", str);
	}
}
