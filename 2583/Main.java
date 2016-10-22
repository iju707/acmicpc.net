import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static int M;
	private static int N;
	private static int K;
	
	private static int[][] BOX;
	
	private static List<Integer> ANSWER;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		
		BOX = new int[M][N];
		// 직사각형 영역을 1로 채운다.
		for(int i = 0 ; i < K ; i++) {
			int xLB = sc.nextInt();
			int yLB = sc.nextInt();
			int xRT = sc.nextInt();
			int yRT = sc.nextInt();
			// 왼쪽하단 부터 오른쪽상단 전까지 1로 채운다.
			for(int y = yLB ; y < yRT ; y++) {
				for(int x = xLB ; x < xRT ; x++) {
					BOX[y][x] = 1;
				}
			}
		}
		// 정답이 다건이므로 List로 보관
		ANSWER = new ArrayList<Integer>();
		for(int y = 0 ; y < M ; y++) {
			for(int x = 0 ; x < N ; x++) {
                // 전체를 검색하면서 0일 경우 탐색 시작
				if(BOX[y][x] == 0) {
                    // BFS를 적용
					Queue<int[]> queue = new LinkedList<int[]>();
                    // 최초 데이터 값 입력
					BOX[y][x] = 1;
					queue.add(new int[] { x, y });
					int size = 0;
					// 큐가 빌때까지 추적
					while(!queue.isEmpty()) {
                        // 큐에서 한개를 추출한 뒤
						int[] data = queue.poll();
						int nowX = data[0]; // 현재 x
						int nowY = data[1]; // 현재 y
                        // 큐에서 추출할 때 마다 사이즈를 1 증가시킨다.
						size++;
						// 상하좌우 가능한지 여부를 판단하고
                        // 가능하다면 방문여부를 1로 바꾼 뒤 큐에다 집어 넣는다.
						if(nowX - 1 >= 0 && BOX[nowY][nowX - 1] == 0) {
							BOX[nowY][nowX - 1] = 1;
							queue.add(new int[] { nowX - 1, nowY });
						}
						if(nowX + 1 < N && BOX[nowY][nowX + 1] == 0) {
							BOX[nowY][nowX + 1] = 1;
							queue.add(new int[] { nowX + 1, nowY });
						}
						if(nowY - 1 >= 0 && BOX[nowY - 1][nowX] == 0) {
							BOX[nowY - 1][nowX] = 1;
							queue.add(new int[] { nowX, nowY - 1 });
						}
						if(nowY + 1 < M && BOX[nowY + 1][nowX] == 0) {
							BOX[nowY + 1][nowX] = 1;
							queue.add(new int[] { nowX, nowY + 1 });
						}
					}
                    // 탐색하여 계산된 사이즈를 보관한다.
					ANSWER.add(size);
				}
			}
		}
        // 배열의 사이즈가 구성된 그룹영역의 개수와 동일
		System.out.println(ANSWER.size());
        // 오름차순을 위한 정렬 후 출력한다
		Collections.sort(ANSWER);
		for(int i = 0 ; i < ANSWER.size() ; i++) {
			System.out.print(ANSWER.get(i) + " " );
		}
		System.out.println();
		sc.close();
	}
}
