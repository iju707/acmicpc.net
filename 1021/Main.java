import java.util.Scanner;

public class Main {
	private static int N;
	private static int M;
	// 찾아야될 위치
	private static int[] TARGET;
	// 해당위치의 숫자를 뽑았는지 여부
	private static boolean[] USED;
	
	private static int ANSWER;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		TARGET = new int[M];
		USED = new boolean[N];
		for(int i = 0 ; i < M ; i++) {
			TARGET[i] = sc.nextInt();
		}
		// 가장 처음의 시작점은 1부터 시작
		int head = 1;
		for(int i = 0 ; i < M ; i++) {
			// 찾고자 하는 목표를 설정하고
			int target = TARGET[i];
			// 시작점 -> 목표 또는 목표 -> 시작점에 대한 거리를 계산해서 가장 작은것을 취한다.
			ANSWER += Math.min(find(head, target), find(target, head));
			// 목표는 탐색했으므로 사용했다고 표시
			USED[target % N] = true;
			// 다음의 시작점은 목표 다음지점으로 변경된다.
			head = target + 1;
		}
		
		System.out.println(ANSWER);
		sc.close();
	}
	
	/**
	 * @param start 시작점
	 * @param end 목표
	 * @return 시작점에서 목표로 가는 거리
	 */
	private static int find(int start, int end) {
		int count = 0;
		if(start < end) {
			// 시작점이 작은 경우에는 시작점 -> 목표로 탐색하면 된다.
			for(int i = start ; i < end ; i++) {
				if(!USED[i % N]) count++;
			}
		}else if(end < start) {
			// 시작점이 큰 경우에는 시작점 -> 목표 + 전체크기 만큼 탐색하면 된다.
			for(int i = start ; i < end + N ; i++) {
				if(!USED[i % N]) count++;
			}
		}
		return count;
	}
}
