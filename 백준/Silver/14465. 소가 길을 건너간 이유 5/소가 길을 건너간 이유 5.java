import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 횡단보드 수, 목표 수, 고장난 수 입력
        st = new StringTokenizer(br.readLine());
        int crossBoardCount = Integer.parseInt(st.nextToken());
        int targetCount = Integer.parseInt(st.nextToken());
        int breakCount = Integer.parseInt(st.nextToken());

        // 결과
        int answer = 100001;

        // 횡단보도 배열 생성
        boolean[] crossBoard = new boolean[crossBoardCount+1];

        // 고장 정보 입력
        for(int index=0; index<breakCount; index++) {
            int breakNum = Integer.parseInt(br.readLine());
            crossBoard[breakNum] = true;
        }

        // 확인
        int currentCount = 0;
        for(int index=1; index<=targetCount; index++) {
            if(crossBoard[index]) currentCount++;
        }

        answer = Math.min(answer, currentCount);
        for(int index=targetCount+1; index<crossBoard.length; index++) {
            if(crossBoard[index - targetCount]) {
                currentCount--;
            }

            if(crossBoard[index]) {
                currentCount++;
            }

            answer = Math.min(answer, currentCount);
        }

        // 결과 출력
        System.out.println(answer);
    }
}