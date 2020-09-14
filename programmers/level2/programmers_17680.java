package programmers.level2;

import java.util.ArrayList;

public class programmers_17680 {

	public static void main(String[] args) {
		int cacheSize1 = 3;
		String[] cities1 = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
		solution(cacheSize1, cities1);
		// (output) 50

		int cacheSize2 = 3;
		String[] cities2 = { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" };
		solution(cacheSize2, cities2);
		// (output) 21

		int cacheSize3 = 2;
		String[] cities3 = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
				"Jeju", "NewYork", "Rome" };
		solution(cacheSize3, cities3);
		// (output) 60

		int cacheSize4 = 5;
		String[] cities4 = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris",
				"Jeju", "NewYork", "Rome" };
		solution(cacheSize4, cities4);
		// (output) 52

		int cacheSize5 = 2;
		String[] cities5 = { "Jeju", "Pangyo", "NewYork", "newyork" };
		solution(cacheSize5, cities5);
		// (output) 16

		int cacheSize6 = 0;
		String[] cities6 = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };
		solution(cacheSize6, cities6);
		// (output) 25

		int cacheSize7 = 0;
		String[] cities7 = { "Jeju", "Jeju" };
		solution(cacheSize7, cities7);
		// (output) 25
	}

	public static int solution(int cacheSize, String[] cities) {
		int answer = 5;
		ArrayList<String> al = new ArrayList<>();
		al.add(cities[0].toUpperCase());
		for (int i = 1; i < cities.length; i++) {
			String temp = cities[i].toUpperCase();
			if (al.size() < cacheSize) {
				if (al.contains(temp)) {
					al.remove(temp);
					answer += 1;
					al.add(temp);
				} else {
					answer += 5;
					al.add(temp);
				}
			} else {
				if (al.size() > cacheSize) {
					al.remove(0);
					answer += 5;
					al.add(temp);
				} else {
					if (al.contains(temp)) {
						al.remove(temp);
						answer += 1;
						al.add(temp);
					} else {
						al.remove(0);
						answer += 5;
						al.add(temp);
					}
				}
			}

		}
		System.out.println(answer);
		return answer;
	}
}
