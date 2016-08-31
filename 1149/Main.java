import java.util.Scanner;

public class Main {
	private static int N;
	private static int[][] DATA;
	private static int[][] MIN;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		DATA = new int[N][3];
		for(int i = 0 ; i < N ; i++) {
			DATA[i][0] = sc.nextInt();
			DATA[i][1] = sc.nextInt();
			DATA[i][2] = sc.nextInt();
		}
		
		MIN = new int[N][3];
		MIN[0][0] = DATA[0][0];
		MIN[0][1] = DATA[0][1];
		MIN[0][2] = DATA[0][2];
		
		for(int i = 1 ; i < N ; i++) {
			MIN[i][0] = Math.min(MIN[i - 1][1], MIN[i - 1][2]) + DATA[i][0];
			MIN[i][1] = Math.min(MIN[i - 1][0], MIN[i - 1][2]) + DATA[i][1];
			MIN[i][2] = Math.min(MIN[i - 1][0], MIN[i - 1][1]) + DATA[i][2];
		}
		
		int answer = Math.min(MIN[N - 1][0], MIN[N - 1][1]);
		answer = Math.min(answer, MIN[N - 1][2]);
		
		System.out.println(answer);
		
		sc.close();
	}
}