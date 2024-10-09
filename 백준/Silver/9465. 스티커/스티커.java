import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 개수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 테스트 케이스 수행
        for(int caseOrder=0; caseOrder<caseCount; caseOrder++) {

            // 결과
            int answer = 0;

            // 스티커 크기 입력
            int stickerSize = Integer.parseInt(br.readLine());

            // 스티커 배열, 결과 배열 생성
            int stickers[][] = new int[2][stickerSize+1];
            int DP[][] = new int[2][stickerSize+1];

            // 스티커 정보 입력
            for(int stickerRow=0; stickerRow<2; stickerRow++) {
                st = new StringTokenizer(br.readLine());
                for(int stickerCol=1; stickerCol<=stickerSize; stickerCol++)
                    stickers[stickerRow][stickerCol] = Integer.parseInt(st.nextToken());
            }

            // 스티커 점수 매기기
            DP[0][1] = stickers[0][1];
            DP[1][1] = stickers[1][1];

            for(int stickerCol=2; stickerCol<=stickerSize; stickerCol++) {
                DP[0][stickerCol] = Math.max(DP[1][stickerCol-1],DP[1][stickerCol-2])+stickers[0][stickerCol];
                DP[1][stickerCol] = Math.max(DP[0][stickerCol-1],DP[0][stickerCol-2])+stickers[1][stickerCol];
            }

            // 결과 저장
            sb.append(Math.max(DP[0][stickerSize],DP[1][stickerSize])).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}