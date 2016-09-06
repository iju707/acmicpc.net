import java.util.Scanner;

public class Main {
    private static int N;

    private static int[] DATA;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        DATA = new int[N + 1];
        DATA[1] = 0;

        for(int i = 2 ; i <= N ; i++) {
            int minus = DATA[i - 1] + 1;
            int sub2 = i % 2 == 0 ? DATA[i / 2] + 1 : Integer.MAX_VALUE;
            int sub3 = i % 3 == 0 ? DATA[i / 3] + 1 : Integer.MAX_VALUE;

            DATA[i] = Math.min(Math.min(minus, sub2), sub3);
        }

        System.out.println(DATA[N]);
        sc.close();
    }
}