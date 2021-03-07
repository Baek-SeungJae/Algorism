package programmers.level2;

public class programmers_49994 {
	public static void main(String[] args) {
		String dirs1 = "ULURRDLLU";
		System.out.println(solution(dirs1));
		String dirs2 = "LULLLLLLU";
		System.out.println(solution(dirs2));
	}

	public static int solution(String dirs) {
		int LEFT = -6;
		int DOWN = -6;
		int locX = 0;
		int locY = 0;
		boolean[][][][] isPassingRoad = new boolean[6 - LEFT][6 - DOWN][6 - LEFT][6 - DOWN];
		int distance = 0;
		for (int i = 0; i < dirs.length(); i++) {
			switch (dirs.charAt(i)) {
				case 'U':
					if (canMove(locX, locY + 1)) {
						if (isPassingRoad[locX - LEFT][locY - DOWN][locX - LEFT][locY - DOWN + 1] == false) {
							isPassingRoad[locX - LEFT][locY - DOWN][locX - LEFT][locY - DOWN + 1] = true;
							isPassingRoad[locX - LEFT][locY - DOWN + 1][locX - LEFT][locY - DOWN] = true;
							distance++;
						}
						locY++;
					}
					break;
				case 'D':
					if (canMove(locX, locY - 1)) {
						if (isPassingRoad[locX - LEFT][locY - DOWN][locX - LEFT][locY - DOWN - 1] == false) {
							isPassingRoad[locX - LEFT][locY - DOWN][locX - LEFT][locY - DOWN - 1] = true;
							isPassingRoad[locX - LEFT][locY - DOWN - 1][locX - LEFT][locY - DOWN] = true;
							distance++;
						}
						locY--;
					}
					break;
				case 'R':
					if (canMove(locX + 1, locY)) {
						if (isPassingRoad[locX - LEFT][locY - DOWN][locX - LEFT + 1][locY - DOWN] == false) {
							isPassingRoad[locX - LEFT][locY - DOWN][locX - LEFT + 1][locY - DOWN] = true;
							isPassingRoad[locX - LEFT + 1][locY - DOWN][locX - LEFT][locY - DOWN] = true;
							distance++;
						}
						locX++;
					}
					break;
				case 'L':
					if (canMove(locX - 1, locY)) {
						if (isPassingRoad[locX - LEFT][locY - DOWN][locX - LEFT - 1][locY - DOWN] == false) {
							isPassingRoad[locX - LEFT][locY - DOWN][locX - LEFT - 1][locY - DOWN] = true;
							isPassingRoad[locX - LEFT - 1][locY - DOWN][locX - LEFT][locY - DOWN] = true;
							distance++;
						}
						locX--;
					}
					break;
			}
		}
		int answer = distance++;
		return answer;
	}

	public static boolean canMove(int locX, int locY) {
		return (locX <= 5 && locX >= -5) && (locY <= 5 && locY >= -5);
	}
}
