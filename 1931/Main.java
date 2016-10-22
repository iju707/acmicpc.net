import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 회의실배정
 * @author jinuke im
 * @see https://www.acmicpc.net/problem/1931 
 *
 */
public class Main {
	private static int N; // 회의 종류
	private static int[][] TIME; // 회의별 시작/종료시간
	private static int ANSWER; // 배치가능한 가장 많은 회의 개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		TIME = new int[N][2];
		for(int i = 0 ; i < N ; i++) {
			TIME[i][0] = sc.nextInt(); // 시작시간
			TIME[i][1] = sc.nextInt(); // 종료시간
		}
		// 전략 : 종료시간이 가장 빨리 끝나는 것부터 회의를 배치한다.
		// 전략 : 시작/종료가 같은 회의도 존재하므로 종료시간이 같을 경우에는 시작시간이 빠른것부터 배치한다.
		
		// 종료시간 기준 오름차순을 하고 같을 경우 시작시간 기준 오름차순으로 정렬한다.
		Arrays.sort(TIME, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				int diff = a[1] - b[1];
				if(diff == 0) {
					return a[0] - b[0];
				}else {
					return diff;
				}
			}
		});
		ANSWER = 0;
		int prevEndTime = 0; // 직전의 회의 종료시간
		// 종료시간이 빠른것부터 대입을 해본다.
		for(int i = 0 ; i < N ; i++) {
			if(prevEndTime <= TIME[i][0]) { // 시작시간이 직전 종료시간 이후라면 
				ANSWER++; // 회의를 배치하고
				prevEndTime = TIME[i][1]; // 종료시간을 변경한다.
			}
		}
		System.out.println(ANSWER);
		sc.close();
	}
}
