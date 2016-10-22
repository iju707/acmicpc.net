import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
// 2583 - 영역구하기 DFS 버전
public class Main2 {
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
		//정답이 다건이므로 List에 보관
		ANSWER = new ArrayList<Integer>();
		for(int y = 0 ; y < M ; y++) {
			for(int x = 0 ; x < N ; x++) {
				// 전체를 검색하면서 0일 경우 탐색 시작
				if(BOX[y][x] == 0) {
					ANSWER.add(dfs(x, y));
				}
			}
		}
		// 배열의 사이즈가 구성된 그룹영역의 개수와 동일
		System.out.println(ANSWER.size());
		// 오름차순을 위한 정렬 후 출력한다.
		Collections.sort(ANSWER);
		for(int i = 0 ; i < ANSWER.size() ; i++) {
			System.out.print(ANSWER.get(i) + " " );
		}
		System.out.println();
		sc.close();
	}
	// x, y를 기준으로 DFS를 한 뒤 영역의 사이즈를 반환한다.
	private static Integer dfs(int x, int y) {
		// 재사용을 방지하기 위하여 1로 변경
		BOX[y][x] = 1;
		int answer = 1;
		// 상하좌우에 대하여 빈곳이 있으면 깊이우선탐색을 한다.
		if(x - 1 >= 0 && BOX[y][x - 1] == 0) {
			answer += dfs(x - 1, y);
		}
		if(x + 1 < N && BOX[y][x + 1] == 0) {
			answer += dfs(x + 1, y);
		}
		if(y - 1 >= 0 && BOX[y - 1][x] == 0) {
			answer += dfs(x, y - 1);
		}
		if(y + 1 < M && BOX[y + 1][x] == 0) {
			answer += dfs(x, y + 1);
		}
		return answer;
	}
}
