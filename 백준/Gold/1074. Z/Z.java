import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 크기
    public static int answer, size;

    // 배열
    public static int arr[][];

    // 방문 수행 메서드
    public static void solve(int arrSize, int resultRow, int resultCol) {

        // 모두 쪼개진 경우
        if(arrSize==1) return;

        // 중간
        int midSize = arrSize/2;

        // 상단 왼쪽
        if(resultRow<midSize && resultCol<midSize) {
            solve(midSize,resultRow,resultCol);
        }

        // 상단 오른쪽
        else if(resultRow<midSize && resultCol>=midSize) {
            answer += arrSize * arrSize/4;
            solve(midSize,resultRow,resultCol-midSize);
        }

        // 하단 왼쪽
        else if(resultRow>=midSize && resultCol<midSize) {
            answer += arrSize * arrSize/4 * 2;
            solve(midSize,resultRow-midSize,resultCol);
        }

        // 하단 오른쪽
        else {
            answer += arrSize * arrSize/4 * 3;
            solve(midSize,resultRow-midSize,resultCol-midSize);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크기, 위치 입력
        st = new StringTokenizer(br.readLine());
        size = Integer.parseInt(st.nextToken());
        int resultRow = Integer.parseInt(st.nextToken());
        int resultCol = Integer.parseInt(st.nextToken());

        // 배열 생성
        int arrSize = (int)Math.pow(2,size);

        // 방문 수행
        answer = 0;
        solve(arrSize,resultRow,resultCol);

        // 결과 출력
        System.out.println(answer);
    }
}