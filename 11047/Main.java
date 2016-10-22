import java.util.Scanner;

/**
 * 동전 0
 * @author jinuke im
 * @see https://www.acmicpc.net/problem/11047 
 *
 */
public class Main {
	private static int N; // 동전의 종류 수 
	private static int K; // 목표 금액
	private static int[] COIN; // 동전의 종류
	
	private static int ANSWER; // 최소 동전개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		COIN = new int[N];
		for(int i = 0 ; i < N ; i++) {
			COIN[i] = sc.nextInt();
		}
		// 전략 : 가장큰 동전부터 사용한다.
		// 단, 동전이 배수라는 단서가 있기 때문에 가능함.
		// 오름차순으로 정렬되어서 입력이 들어오므로 역순으로 접근한다.
		for(int i = N - 1 ; i >= 0 ; i--) {
			ANSWER += K / COIN[i]; // 금액에서 동전을 나누면 필요한 개수가 나온다.
			K = K % COIN[i]; // 필요한 개수만큼 사용하고 남은 금액은 나머지 연산을 하면 나온다.
		}
		
		System.out.println(ANSWER);
		sc.close();
	}
}
