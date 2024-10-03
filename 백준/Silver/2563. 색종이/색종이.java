import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = 0;

        // 도화지 배열 생성
        boolean drawingPaper[][] = new boolean[101][101];

        // 색종이 수 입력
        int colorPaperCnt = Integer.parseInt(br.readLine());

        // 색종이 정보 입력
        for(int i=0; i<colorPaperCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = startY+10;
            int endX = startX+10;
            
            for(int j=startY; j<endY; j++) {
                for(int k=startX; k<endX; k++) {
                    if(!drawingPaper[j][k]) {
                        drawingPaper[j][k] = true;
                        answer++;
                    }
                }
            }
        }

        // 결과
        System.out.println(answer);
    }
}