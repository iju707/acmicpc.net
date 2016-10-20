import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static int M; // 가로 길이
	private static int N; // 세로 길이
	
	private static int[][] BOX; // 토마토 박스
	
	private static int ANSWER; // 전체 토마토가 익는데 걸리는 시간
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		BOX = new int[N][M];
		for(int y = 0 ; y < N ; y++) {
			for(int x = 0 ; x < M ; x++) {
				BOX[y][x] = sc.nextInt();
			}
		}
		
		ANSWER = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		// 큐를 이용하여 BFS로 검색한다.
		// 큐에 보관할 정보는
		// [0] : y 좌표
		// [1] : x 좌표
		// [2] : 익는데 걸리는 날짜 수
		// 시작점은 익은 토마토(1)가 되므로 전체를 검색하여 시작점을 큐에 입력한다.
		for(int y = 0 ; y < N ; y++) {
			for(int x = 0 ; x < M ; x++) {
				if(BOX[y][x] == 1) {
					queue.add(new int[] { y, x, 0 });
				}
			}
		}
		// 큐가 빌때까지 진행한다.
		while(!queue.isEmpty()) {
			// 큐에서 데이터를 가져오고
			int[] data = queue.poll();
			int y = data[0]; // 현재 토마토의 y 좌표
			int x = data[1]; // 현재 토마토의 x 좌표
			int day = data[2]; // 현재 토마토가 익은 날짜

			// 정답을 계속 보관한다.
			ANSWER = day;
			// 상하좌우 총 4방향으로 갈 수 있는지 확인한다.
			// 각 방향이 갈 수 있는 범위 0 ~ N(or M)이내인지 확인하고
			// 익지 않은 토마토(0)인지 확인한다.
			// 갈 수 있는 경우 해당 토마토를 익히고, 날짜를 1증가 시킨 뒤 큐에 입력한다.
			// 상
			if(y - 1 >= 0 && BOX[y - 1][x] == 0) {
				BOX[y - 1][x] = 1;
				queue.add(new int[] { y - 1, x, day + 1 });
			}
			// 하
			if(y + 1 < N && BOX[y + 1][x] == 0) {
				BOX[y + 1][x] = 1;
				queue.add(new int[] { y + 1, x, day + 1 });
			}
			// 좌
			if(x - 1 >= 0 && BOX[y][x - 1] == 0) {
				BOX[y][x - 1] = 1;
				queue.add(new int[] { y, x - 1, day + 1 });
			}
			// 우
			if(x + 1 < M && BOX[y][x + 1] == 0) {
				BOX[y][x + 1] = 1;
				queue.add(new int[] { y, x + 1, day + 1 });
			}
		}
		// 익지 않은 토마토를 확인한다.
		int tomatoCount = 0;
		for(int y = 0 ; y < N ; y++) {
			for(int x = 0 ; x < M ; x++) {
				if(BOX[y][x] == 0) {
					tomatoCount++;
				}
			}
		}
		// 익지 않은 토마토가 있는 경우에는 -1 아니면 전체 걸린 시간을 출력한다.
		if(tomatoCount > 0) {
			System.out.println("-1");
		}else {
			System.out.println(ANSWER);
		}
		
		sc.close();
	}
}
