import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    // 옮긴 횟수
    public static int count;

    // 하노이 탑 함수 정의
    static void hanoiTop(int board, int start, int mid, int end) {

        // 옮긴 횟수 조정
        count += 1;

        // 종료 조건
        if(board==1) {
            sb.append(start+" "+end+"\n");
            return ;
        }

        // 작은 원판 다른 곳으로 이동
        hanoiTop(board-1,start,end,mid);
        // 옮기기
        sb.append(start+" "+end+"\n");
        // 작은 원판 되돌려 놓기
        hanoiTop(board-1,mid,start,end);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 원판의 개수 입력
        int boardCnt = Integer.parseInt(br.readLine());

        // 하노이 탑 수행
        count = 0;
        hanoiTop(boardCnt, 1, 2, 3);

        // 결과 출력
        System.out.println(count);
        System.out.println(sb.toString());
    }
}