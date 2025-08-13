import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 박스 개수, 색깔 수 입력
        st = new StringTokenizer(br.readLine());
        int boxCount = Integer.parseInt(st.nextToken());
        int colorCount = Integer.parseInt(st.nextToken());

        // 색깔 확인 여부 배열 생성
        boolean[] colorCheck = new boolean[colorCount];
        int answer = 0;

        // 박스 확인
        for(int box=0; box<boxCount; box++) {
            st = new StringTokenizer(br.readLine());

            // 색깔, 색깔 종류 개수
            int color = -1;
            int colorTypeCount = 0;

            // 카드 색깔 입력
            for(int colorIndex=0; colorIndex<colorCount; colorIndex++) {
                int kinds = Integer.parseInt(st.nextToken());

                // 카드가 있는 경우
                if(kinds > 0) {
                    color = colorIndex;
                    colorTypeCount++;
                }
            }

            // 색깔 종류가 없는 경우
            if (colorTypeCount == 0) continue;

            // 색깔 종류가 하나이면서 박스에 안담긴 경우
            if (colorTypeCount == 1 && !colorCheck[color]) {
                colorCheck[color] = true;
            }

            // 색깔 종류가 여러 개인 경우 - 옮기기
            // 색깔이 하나 & 박스에 담긴 경우 - 옮기기
            else answer++;
        }

        // 결과 출력
        // 모두 색깔끼리 모인 경우 고려
        sb.append(answer - 1 == -1 ? 0 : answer - 1);
        System.out.println(sb.toString());
    }
}