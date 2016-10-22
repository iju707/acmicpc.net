import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로찾기
 * @author jinuk im
 * @see https://www.acmicpc.net/problem/2178
 *
 */
public class Main {
	private static int N; // 미로의 세로길이
	private static int M; // 미로의 가로길이
	
	private static int[][] DATA; // 미로
	
	private static int ANSWER; // 도착지까지 최소 칸수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		DATA = new int[N][M];
		// 문제는 1,1 ~ N,M이면
		// DATA는 0,0 ~ N-1,M-1까지 존재한다.
		for(int i = 0 ; i < N ; i++) {
			String data = sc.next();
			for(int j = 0 ; j < M ; j++) {
				char tic = data.charAt(j);
				if(tic == '0') {
					DATA[i][j] = 0;
				}else {
					DATA[i][j] = 1;
				} 
			}
		}
		// BFS를 이용하여 미로를 탐색한다.
		ANSWER = 0;
		Queue<int[]> queue = new LinkedList<int[]>();
		// 0 : row / 1 : column / 2 : 칸수
		// 0, 0부터 시작한다.
		queue.offer(new int[] {0, 0, 1});
		DATA[0][0] = 0;
		// 큐가 빌때까지 추적한다.
		while(!queue.isEmpty()) {
			int[] prev = queue.poll(); // 큐에서 1개를 추출하고
			int r = prev[0]; // row
			int c = prev[1]; // column
			int count = prev[2]; // 칸수
			if(r == N - 1 && c == M - 1) {
				// N-1, M-1일 경우 도착지 이므로 탐색을 중단한다.
				ANSWER = count;
				break;
			}
			// 상하좌우로 갈 수 있는 경우 탐색을 한다.
			// 다른 경로를 통해 재방문하지 않도록 0으로 변경한다.
			// 큐에 row, column에 대한 정보를 입력하고 칸수를 1 증가시킨다.
			if(r + 1 < N && DATA[r + 1][c] == 1) {
				DATA[r + 1][c] = 0;
				queue.offer(new int[] { r + 1, c, count + 1 });
			}
			if(r - 1 >= 0 && DATA[r - 1][c] == 1) {
				DATA[r - 1][c] = 0;
				queue.offer(new int[] { r - 1, c, count + 1 });
			}
			if(c + 1 < M && DATA[r][c + 1] == 1) {
				DATA[r][c + 1] = 0;
				queue.offer(new int[] { r, c + 1, count + 1 });
			}
			if(c - 1 >= 0 && DATA[r][c - 1] == 1) {
				DATA[r][c - 1] = 0;
				queue.offer(new int[] {r, c - 1, count + 1 });
			}
		}
		System.out.println(ANSWER);
		
		sc.close();
	}
}
