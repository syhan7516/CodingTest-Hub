import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 시간, 기본 크기, 전체 크기, 검정 크기
    public static int time, basicSize, totalSize, blackSize;

    // 좌표
    public static int startY, startX, endY, endX;

    // 색깔 찾기 메서드
    public static int findPointColor(int size, int row, int col) {

        // 크기가 1인 경우
        if(size == 1) {
            return 0;
        }

        // 분할 크기 단위 설정
        int currentSize = size / basicSize;

        // 중앙 좌표 설정
        int minRowAndCol = (basicSize - blackSize) / 2 * currentSize;
        int maxRowAndCol = (basicSize + blackSize) / 2 * currentSize - 1;

        // 중앙인지 확인
        if(row >= minRowAndCol && row <= maxRowAndCol && col >= minRowAndCol && col <= maxRowAndCol) {
            return 1;
        }

        return findPointColor(currentSize, row % currentSize, col % currentSize);
    }

    // 탐색 메서드
    public static String solve() {

        // 빌더 생성
        StringBuilder sb = new StringBuilder();

        // 시간이 0인 경우
        if(time == 0) {
            sb.append(0);
            return sb.toString();
        }

        // 전체 크기 확인
        totalSize = 1;
        for(int index=0; index<time; index++) {
            totalSize *= basicSize;
        }

        // 색깔 확인

        for(int rowIndex=startY; rowIndex<=endY; rowIndex++) {
            for(int colIndex=startX; colIndex<=endX; colIndex++) {
                sb.append(findPointColor(totalSize, rowIndex, colIndex));
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 시간, 기본 크기, 검정 크기 입력
        st = new StringTokenizer(br.readLine());
        time = Integer.parseInt(st.nextToken());
        basicSize = Integer.parseInt(st.nextToken());
        blackSize = Integer.parseInt(st.nextToken());

        // 좌표 입력
        startY = Integer.parseInt(st.nextToken());
        endY = Integer.parseInt(st.nextToken());
        startX = Integer.parseInt(st.nextToken());
        endX = Integer.parseInt(st.nextToken());

        // 탐색 -> 결과 출력
        System.out.println(solve());;
    }
}