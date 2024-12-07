import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 가로, 세로, 회전 수
    public static int rowSize, colSize, rotateCount;

    // 배열
    public static int arr[][];

    // 회전 메서드
    public static void rotate(int deep) {

        // 시작점 빼기
        int mock = arr[deep][deep];

        // 위쪽
        for(int colIndex=deep; colIndex<colSize-1-deep; colIndex++) {
            arr[deep][colIndex] = arr[deep][colIndex+1];
        }

        // 오른쪽
        for(int rowIndex=deep; rowIndex<rowSize-1-deep; rowIndex++) {
            arr[rowIndex][colSize-1-deep] = arr[rowIndex+1][colSize-1-deep];
        }

        // 아래쪽
        for(int colIndex=colSize-1-deep; colIndex>deep; colIndex--) {
            arr[rowSize-1-deep][colIndex] = arr[rowSize-1-deep][colIndex-1];
        }

        // 왼쪽
        for(int rowIndex=rowSize-1-deep; rowIndex>deep; rowIndex--) {
            arr[rowIndex][deep] = arr[rowIndex-1][deep];
        }

        // 시작점 넣기
        arr[deep+1][deep] = mock;
    }

    // 회전하기 메서드
    public static void solve() {

        // 배열 깊이
        int deep = Math.min(rowSize/2,colSize/2);

        // 차례로 회전
        for(int point=0; point<deep; point++)
            rotate(point);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 가로, 세로, 회전 수 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        rotateCount = Integer.parseInt(st.nextToken());

        // 배열 생성
        arr = new int[rowSize][colSize];

        // 배열 정보 입력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                arr[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
            }
        }

        // 회전하기
        for(int rotate=0; rotate<rotateCount; rotate++)
            solve();

        // 결과 출력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            for(int colIndex=0; colIndex<colSize; colIndex++)
                sb.append(arr[rowIndex][colIndex]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}