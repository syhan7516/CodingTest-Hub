import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 가로, 세로 크기, 스위치 수
    public static int answer, rowSize, colSize, switchCount;

    // 가로 off 개수 저장 배열
    public static int[] rowLampOffCounts;

    // 가로 상태 저장 배열
    public static String[] rowLampStatus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 가로 off 개수 저장 배열 생성
        rowLampOffCounts = new int[rowSize];

        // 가로 상태 저장 배열 생성
        rowLampStatus = new String[rowSize];

        // 램프 정보 입력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            int offCount = 0;
            String status = br.readLine();
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                if(status.charAt(colIndex) == '0') {
                    offCount++;
                }
            }
            rowLampOffCounts[rowIndex] = offCount;
            rowLampStatus[rowIndex] = status;
        }

        // 스위치 수 입력
        switchCount = Integer.parseInt(br.readLine());

        // 램프를 모두 켤 수있는 행 확인
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {

            // off 개수보다 스위치 수가 작은 경우
            if(rowLampOffCounts[rowIndex] > switchCount) continue;

            // 램프를 키고 남은 스위치 수가 홀수인 경우
            if((switchCount - rowLampOffCounts[rowIndex]) % 2 == 1) continue;

            // 동일한 상태의 행
            int equalsStatusRow = 0;

            // 해당 행의 램프를 모두 킬 수 있는 경우 동일한 상태의 행 확인
            for(int index=0; index<rowSize; index++) {

                // 동일한 상태인 경우
                if(rowLampStatus[rowIndex].equals(rowLampStatus[index])) {
                    equalsStatusRow++;
                }
            }

            // 결과 갱신
            answer = Math.max(answer, equalsStatusRow);
        }

        // 결과 출력
        System.out.println(answer);
    }
}