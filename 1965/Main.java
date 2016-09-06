// 1965 : 상자넣기
//
// Author : Jinuk Im
//
// LIS(Longest Increase Subsequence)
// Lower Bound 방식을 이용
import java.util.Scanner;

public class Main {
    private static int N;
    private static int[] bound;
    private static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        bound = new int[N];
        bound[size] = sc.nextInt();

        for(int i = 1 ; i < N ; i++) {
            int tic = sc.nextInt();
            if(bound[size] < tic) {
                bound[++size] = tic;
            }else {
                bound[size] = tic;
            }
        }

        System.out.println(size + 1);

        sc.close();
    }
}