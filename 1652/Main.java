import java.util.Scanner;

public class Main {
    private static int N;
    private static int ROW;
    private static int COL;

    private static String[] DATA;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        // 입력되는 방의 정보를 문자열 단위로 저장한다.
        DATA = new String[N];
        for(int i = 0 ; i < N ; i++) {
            DATA[i] = sc.next();
        }
        // 전체 공간을 검색한다.
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < N ; j++) {
                // 만약 현재 위치에서 누울 수 있다면
                if(DATA[i].charAt(j) == '.') {
                    // 가로 계산
                    // 내 다음 위치가 공간안에 존재하고 누울 수 있다면
                    if(j + 1 < N && DATA[i].charAt(j+1) == '.') {
                        // 내 다다음 위치가 공간을 벗어나거나
                        if(j + 2 == N) ROW++;
                        // 내 다다음 위치가 짐으로 누울 수 없는 경우 가로로 누울 수 있다.
                        else if(DATA[i].charAt(j + 2) == 'X') ROW++;
                    }

                    // 세로 계산
                    // 내 다음 위치가 공간안에 존재하고 누울 수 있다면
                    if(i + 1 < N && DATA[i + 1].charAt(j) == '.') {
                        // 내 다다음 위치가 공간을 벗어나거나
                        if(i + 2 == N) COL++;
                        // 내 다다음 위치가 짐으로 누울 수  없는 경우 세로로 누울 수 있다.
                        else if(DATA[i + 2].charAt(j) == 'X') COL++;
                    }
                }
            }
        }

        System.out.println(ROW + " " + COL);
        sc.close();
    }
}
