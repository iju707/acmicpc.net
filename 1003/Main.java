import java.util.Scanner;

public class Main {
	public static int T;
	public static int N;
	public static int[][] DATA;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		for(int caseIdx = 1 ; caseIdx <= T ; caseIdx++) {
			N = sc.nextInt();
			
			DATA = new int[N + 1][2];
			
			for(int i = 0 ; i <= N ; i++) {
				if(i == 0) {
					DATA[0][0] = 1;
					DATA[0][1] = 0;
				}else if(i == 1) {
					DATA[1][0] = 0;
					DATA[1][1] = 1;
				}else {
					DATA[i][0] = DATA[i - 1][0] + DATA[i - 2][0];
					DATA[i][1] = DATA[i - 1][1] + DATA[i - 2][1];
				}
			}
			
			System.out.println(DATA[N][0] + " " + DATA[N][1]);
		}
		
		sc.close();
	}
}