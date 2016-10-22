import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 카드1
 * @author jinuk im
 * @see https://www.acmicpc.net/problem/2161 
 *
 */
public class Main {
	private static int N; // 카드 개수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		// 큐를 사용하여 시뮬레이션 한다.
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i = 1 ; i <= N ; i++) {
			queue.offer(i);
		}
		// 큐에 1개 남을때까지 진행한다.
		while(queue.size() > 1) {
			// 하나를 빼서 출력하고
			System.out.print(queue.poll() + " ");
			// 하나를 빼서 뒤로 보낸다.
			Integer next = queue.poll();
			queue.offer(next);
		}
		// 남은 하나를 출력한다.
		System.out.println(queue.poll());
		
		sc.close();
	}
}
