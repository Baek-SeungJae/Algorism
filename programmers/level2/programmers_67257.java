package programmers.level2;

import java.util.ArrayList;

public class programmers_67257 {

	public static void main(String[] args) {
		String expression = "100-200*300-500+20";
		System.out.println(solution(expression));

	}

	public static long solution(String expression) {
		ArrayList<Long> numbers = new ArrayList<>();
		ArrayList<Character> ops = new ArrayList<>();

		expression = expression.replace("-", ",-,").replace("+", ",+,").replace("*", ",*,");
		String[] expressionArr = expression.split(",");
		for (int i = 0; i < expressionArr.length; i++) {
			if (expressionArr[i].equals("-") || expressionArr[i].equals("+") || expressionArr[i].equals("*")) {
				ops.add(expressionArr[i].charAt(0));
			} else {
				numbers.add(Long.parseLong(expressionArr[i]));
			}
		}
		long result = 0;
		for (int i = 0; i < 6; i++) {

			ArrayList<Long> numbersTemp = (ArrayList<Long>) numbers.clone();
			ArrayList<Character> opsTemp = (ArrayList<Character>) ops.clone();
			switch (i) {
			case 0:
				result = Math.max(result, pmt(numbersTemp, opsTemp));
				break;
			case 1:
				result = Math.max(result, ptm(numbersTemp, opsTemp));
				break;
			case 2:
				result = Math.max(result, mpt(numbersTemp, opsTemp));
				break;
			case 3:
				result = Math.max(result, mtp(numbersTemp, opsTemp));
				break;
			case 4:
				result = Math.max(result, tpm(numbersTemp, opsTemp));
				break;
			case 5:
				result = Math.max(result, tmp(numbersTemp, opsTemp));
				break;
			}
		}
		long answer = result;
		return answer;
	}

	public static long pmt(ArrayList<Long> numbers, ArrayList<Character> ops) {
		plus(numbers, ops);
		minus(numbers, ops);
		times(numbers, ops);
		return Math.abs(numbers.get(0));
	}

	public static long ptm(ArrayList<Long> numbers, ArrayList<Character> ops) {
		plus(numbers, ops);
		times(numbers, ops);
		minus(numbers, ops);
		return Math.abs(numbers.get(0));
	}

	public static long mpt(ArrayList<Long> numbers, ArrayList<Character> ops) {
		minus(numbers, ops);
		plus(numbers, ops);
		times(numbers, ops);
		return Math.abs(numbers.get(0));
	}

	public static long mtp(ArrayList<Long> numbers, ArrayList<Character> ops) {
		minus(numbers, ops);
		times(numbers, ops);
		plus(numbers, ops);
		return Math.abs(numbers.get(0));
	}

	public static long tmp(ArrayList<Long> numbers, ArrayList<Character> ops) {
		times(numbers, ops);
		minus(numbers, ops);
		plus(numbers, ops);
		return Math.abs(numbers.get(0));
	}

	public static long tpm(ArrayList<Long> numbers, ArrayList<Character> ops) {
		times(numbers, ops);
		plus(numbers, ops);
		minus(numbers, ops);
		return Math.abs(numbers.get(0));
	}

	public static void plus(ArrayList<Long> numbers, ArrayList<Character> ops) {
		for (int i = 0; i < ops.size(); i++) {
			if (ops.get(i) == '+') {
				long result = numbers.get(i) + numbers.get(i + 1);
				numbers.remove(i);
				numbers.remove(i);
				numbers.add(i, result);
				ops.remove(i);
				i--;
			}
		}
	}

	public static void minus(ArrayList<Long> numbers, ArrayList<Character> ops) {
		for (int i = 0; i < ops.size(); i++) {
			if (ops.get(i) == '-') {
				long result = numbers.get(i) - numbers.get(i + 1);
				numbers.remove(i);
				numbers.remove(i);
				numbers.add(i, result);
				ops.remove(i);
				i--;
			}
		}
	}

	public static void times(ArrayList<Long> numbers, ArrayList<Character> ops) {
		for (int i = 0; i < ops.size(); i++) {
			if (ops.get(i) == '*') {
				long result = numbers.get(i) * numbers.get(i + 1);
				numbers.remove(i);
				numbers.remove(i);
				numbers.add(i, result);
				ops.remove(i);
				i--;
			}
		}
	}
}
