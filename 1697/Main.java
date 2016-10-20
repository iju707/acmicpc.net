import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	private static int N; // 수빈이 위치
	private static int K; // 동생 위치
	
	private static boolean[] USED; // 위치에 대한 계산 여부
	
	private static int ANSWER; // 수빈이 위치에서 동생 위치까지 간 횟수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		USED = new boolean[100001];
		
		Queue<int[]> queue = new LinkedList<int[]>();
		// 수빈이 위치부터 시작
		USED[N] = true;
		queue.add(new int[] { N, 0 });
		// 큐에 데이터가 없을 때 까지 반복
		while(!queue.isEmpty()) {
			// 큐에서 데이터를 빼온 뒤
			int[] data = queue.poll();
			int position = data[0]; // 0은 현재 위치
			int moveCount = data[1]; // 1은 현재 위치까지 이동한 횟수
			// 만약 현재 위치가 동생위치라면 종료
			if(position == K) {
				ANSWER = moveCount; // 정답은 동생위치까지 이동한 횟수
				break; // 더 이상 탐색이 필요 없으므로 끝
			}
			// 이동가능한 곳을 탐색한다.
			// 가능할 경우에는 이동했다고 표시하고 큐에다가 정보를 입력한다.
			// 입력할 때 이동횟수가 1 증가했으므로 moveCount + 1을 입력한다.
			// -1일 경우에는 0보다 크거나 같은지 확인 후 이동안했으면 이동
			if(position - 1 >= 0 && !USED[position - 1]) {
				USED[position - 1] = true;
				queue.add(new int[] { position - 1, moveCount + 1 });
			}
			// +1일 경우에는 100000보다 작거나 같은지 확인 후 이동안했으면 이동
			if(position + 1 <= 100000 && !USED[position + 1]) {
				USED[position + 1] = true;
				queue.add(new int[] { position + 1, moveCount + 1 });
			}
			// *2일 경우에는 100000보다 작거나 같은지 확인 후 이동안했으면 이동
			if(position * 2 <= 100000 && !USED[position * 2]) {
				USED[position * 2] = true;
				queue.add(new int[] { position * 2, moveCount + 1 });
			}
		}
		
		System.out.println(ANSWER);
		sc.close();
	}
}
