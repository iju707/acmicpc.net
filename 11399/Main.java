import java.util.Arrays;
import java.util.Scanner;

/**
 * ATM
 * @author jinuke im
 * @see https://www.acmicpc.net/problem/11399 
 *
 */
public class Main {
	private static int N; // 사람수
	private static int[] P; // 사람별 출금 시간
	
	private static int ANSWER; // 전체 누적된 시간
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		P = new int[N];
		for(int i = 0 ; i < N ; i++) {
			P[i] = sc.nextInt();
		}
		// 전략 : 출금시간이 가장 적은 사람부터 인출을 시작한다.
		// 출금시간별 오름차순 정렬
		Arrays.sort(P);
		int prevSum = 0; // 누적된 시간정보
		for(int i = 0 ; i < N ; i++) {
			prevSum += P[i]; // 본인의 시간을 누적하고
			ANSWER += prevSum; // 본인이 출금하는데 걸린 전체시간을 답에 합산한다.
		}
		System.out.println(ANSWER);
		sc.close();
	}
}
