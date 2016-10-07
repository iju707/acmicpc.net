import java.util.Scanner;

public class Main {
    private static int N;
    private static long[][] DATA;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        DATA = new long[N + 1][2];
        DATA[1][0] = 0;
        DATA[1][1] = 1;

        for(int i = 2 ; i <= N ; i++) {
            DATA[i][0] = DATA[i - 1][0] + DATA[i - 1][1];
            DATA[i][1] = DATA[i - 1][0];
        }

        System.out.println(DATA[N][0] + DATA[N][1]);

        sc.close();
    }
}