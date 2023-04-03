import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 다이나믹 테이블
    public static int[][][] D;

    // 재귀 함수 정의
    static int recursion(int a, int b, int c) {
        if(a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if(D[a][b][c]!=0) {
            return D[a][b][c];
        }

        if(a > 20 || b > 20 || c > 20) {
            return D[a][b][c] = recursion(20,20,20);
        }

        if(a < b && b < c) {
            return D[a][b][c] = recursion(a,b,c-1) + recursion(a, b-1, c-1) - recursion(a, b-1, c);
        }

        return D[a][b][c] = recursion(a-1,b,c) + recursion(a-1,b-1,c) + recursion(a-1,b,c-1) - recursion(a-1,b-1,c-1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // a, b, c 초기화
        int a = 0, b = 0, c = 0;

        // DP 테이블 초기화
        D = new int[51][51][51];

        // 케이스 반복 수행
        while(true) {

            // a, b, c 입력
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            // 종료 조건
            if(a==-1 && b==-1 && c==-1)
                break;

            // 재귀 호출
            int result = recursion(a,b,c);

            // 결과 출력
            System.out.println("w("+a+", "+b+", "+c+") = "+result);
        }
    }
}