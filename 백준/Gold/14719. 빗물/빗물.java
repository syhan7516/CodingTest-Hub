import java.util.*;
import java.io.*;

public class Main {

    // 왼쪽에서 탐색하기 메서드
    public static int leftSearch(int blocks[], int maxIdx) {

        // 왼쪽 결과
        int result = 0;

        // 이전 최대 높이, 위치
        int preMaxHigh = -1;
        int preMaxIdx = -1;

        // 블록 순회
        for(int i=0; i<=maxIdx; i++) {

            // 시작 위치인 경우
            if(i==0) {
                preMaxIdx = i;
                preMaxHigh = blocks[i];
            }

            // 이전 블록 최대 높이보다 낮은 경우
            if(preMaxHigh>blocks[i])
                result += preMaxHigh-blocks[i];

            // 아닌 경우
            else {
                preMaxIdx = i;
                preMaxHigh = blocks[i];
            }
        }

        return result;
    }

    // 오른쪽에서 탐색하기 메서드
    public static int rightSearch(int blocks[], int maxIdx) {

        // 오른쪽 결과
        int result = 0;

        // 이전 최대 높이, 위치
        int preMaxHigh = -1;
        int preMaxIdx = -1;

        // 블록 순회
        for(int i=blocks.length-1; i>=maxIdx; i--) {

            // 시작 위치인 경우
            if(i==blocks.length-1) {
                preMaxIdx = i;
                preMaxHigh = blocks[i];
            }

            // 이전 블록 최대 높이보다 낮은 경우
            if(preMaxHigh>blocks[i])
                result += preMaxHigh-blocks[i];

                // 아닌 경우
            else {
                preMaxIdx = i;
                preMaxHigh = blocks[i];
            }
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = 0;

        // 블록 최대 높이, 위치
        int maxHigh = -1;
        int maxIdx = -1;

        // 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        // 블록 정보 배열 생성
        int blocks[] = new int[col];

        // 블록 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<col; i++) {

            // 블록 높이 입력
            blocks[i] = Integer.parseInt(st.nextToken());

            // 최대 높이일 경우 갱신
            if(maxHigh<blocks[i]) {
                maxHigh = blocks[i];
                maxIdx = i;
            }
        }

        // 왼쪽에서 탐색
        answer += leftSearch(blocks,maxIdx);

        // 오른쪽에서 탐색
        answer += rightSearch(blocks,maxIdx);

        // 결과 출력
        System.out.println(answer);
    }
}