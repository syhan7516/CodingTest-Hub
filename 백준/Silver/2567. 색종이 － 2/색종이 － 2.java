import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 큰 종이 만들기
        int bigPaper[][] = new int[102][102];

        // 색종이 개수 입력
        int paperCnt = Integer.parseInt(br.readLine());

        // 색종이 정보 입력
        for(int p=0; p<paperCnt; p++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 색종이 붙이기
            for(int row=y; row<10+y; row++) {
                for(int col=x; col<10+x; col++) {
                    bigPaper[row][col] = 1;
                }
            }
        }

        // 색종이 둘레 확인
        int result = 0;
        for(int row=1; row<=100; row++) {
            for(int col=1; col<=100; col++) {
                // 색종이 면을 발견할 경우
                if(bigPaper[row][col]==1) {
                    // 색종이의 위
                    if(bigPaper[row+1][col]==0)
                        result++;
                    // 색종이의 아래
                    if(bigPaper[row-1][col]==0)
                        result++;
                    // 색종이의 왼쪽
                    if(bigPaper[row][col-1]==0)
                        result++;
                    // 색종이의 오른쪽
                    if(bigPaper[row][col+1]==0)
                        result++;
                }
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}