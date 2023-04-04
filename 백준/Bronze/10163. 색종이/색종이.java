import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 색종이 수 입력
        int paperCnt = Integer.parseInt(br.readLine());

        // 각 색종이 넓이 배열
        int paper[] = new int[paperCnt+1];

        // 큰 종이
        int board[][] = new int[1001][1001];

        // 종이 정보 입력
        for(int idx=1; idx<=paperCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            
            // 큰 종이에 종이 붙이기
            for(int a=x; a<width+x; a++) {
                for(int b=y; b<height+y; b++) {
                    board[a][b] = idx;
                }
            }
        }

        // 각 종이 넓이 확인
        for(int a=0; a<1001; a++) {
            for(int b=0; b<1001; b++) {
                paper[board[a][b]] += 1;
            }
        }

        // 결과 확인
        for(int idx=1; idx<=paperCnt; idx++)
            System.out.println(paper[idx]);
    }
}