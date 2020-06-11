package programmers.level2;

public class Programmers_42586 {
	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = new String[] { "CXF", "ASF", "BDF", "CEFD" };
		System.out.println(solution(skill, skill_trees));
	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		for (int j = 0; j < skill_trees.length; j++) {
			int preindex = skill_trees[j].indexOf(skill.charAt(0));
			if (preindex == -1) {
				preindex = 27;
			}
			for (int i = 1; i < skill.length(); i++) {
				int index = skill_trees[j].indexOf(skill.charAt(i));
				if (index == -1) {
					index = 27;
				}
				if (preindex <= index) {
					preindex = index;
				} else {
					answer--;
					break;
				}
			}
			answer++;
		}
		return answer;
	}
}