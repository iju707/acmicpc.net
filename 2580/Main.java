import java.util.Scanner;

/**
 * 스도쿠
 * @see https://www.acmicpc.net/problem/2580
 * @author iju707
 *
 */
public class Main {
	private static int[][] DATA; // 스도쿠 판 
	private static int[][] ZERO; // 빈곳의 좌표
	private static int zeroCount; // 빈곳의 개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		DATA = new int[9][9];
		ZERO = new int[81][2];
		zeroCount = 0;
		for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				DATA[i][j] = sc.nextInt();
				// 데이터를 입력하고 빈곳의 위치를 기억해둔다.
				if(DATA[i][j] == 0) {
					ZERO[zeroCount][0] = i;
					ZERO[zeroCount][1] = j;
					zeroCount++;
				}
			}
		}
		// 백트래킹을 이용하여 1~9까지 가능한 숫자를 하나씩 채워본다.
		backtrack(0);
		// 정답이 되면 백트래킹이 종료되므로 출력한다.
		for(int i = 0 ; i < 9 ; i++) {
			for(int j = 0 ; j < 9 ; j++) {
				System.out.print(DATA[i][j] + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	/**
	 * 비어있는 곳에 숫자를 넣어보며 백트래킹을 한다.
	 * @param index 비어있는 곳의 번호
	 * @return 1 : 정답 / 0 : 오답
	 */
	private static int backtrack(int index) {
		// 비어있는 곳의 번호가 0의 개수 이상이면 다 채웠으므로 정답처리
		if(index >= zeroCount) {
			return 1;
		}
		
		int r = ZERO[index][0]; // 비어있는곳 행
		int c = ZERO[index][1]; // 비어있는곳 열
		// 1부터 9까지 시도를 한다.
		for(int number = 1 ; number <= 9 ; number++) {
			// 해당 위치에 해당 숫자가 가능한 경우
			if(isPosible(r, c, number)) {
				DATA[r][c] = number; // 숫자를 입력하고
				if(backtrack(index + 1) == 1) { // 다음 백트래킹을 해서 정답이면 정답 처리
					return 1;
				}
				DATA[r][c] = 0; // 오답이면 초기화 하고 다음 단계로 간다.
			}
		}
		// 정답이 나오지 않은 경우는 오답처리
		return 0;
	}

	/**
	 * 해당 위치에 해당 숫자가 가능한지 판별
	 * @param r 위치의 행
	 * @param c 위치의 열
	 * @param number 가능한지 판단하려는 숫자
	 * @return 가능여부
	 */
	private static boolean isPosible(int r, int c, int number) {
		// 가로 계산
		for(int i = 0 ; i < 9 ; i++) {
			if(DATA[r][i] == number) {
				return false;
			}
		}
		// 세로 계산
		for(int i = 0 ; i < 9 ; i++) {
			if(DATA[i][c] == number) {
				return false;
			}
		}
		// 3 * 3 영역은
		// 위치를 3으로 나눈뒤 3 곱하면 해당 영역의 첫번째 좌표를 얻을 수 있다.
		// 예 4, 3 => 3, 3이 3*3영역의 첫번째
		int idxR = r / 3;
		int idxC = c / 3;
		for(int i = 0 ; i < 3 ; i++) {
			for(int j = 0 ; j < 3 ; j++) {
				int newR = idxR * 3 + i;
				int newC = idxC * 3 + j;
				if(DATA[newR][newC] == number) {
					return false;
				}
			}
		}
		return true;
	}
}
