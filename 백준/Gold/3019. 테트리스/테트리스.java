import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 열의 개수, 블록 종류
    public static int answer, colSize, block;

    // 필드 배열
    public static int field[];

    // 필드 높이 입력 메서드
    public static void inputFieldHeight(StringTokenizer st) {

        for(int colIndex=0; colIndex<colSize; colIndex++) {
            field[colIndex] = Integer.parseInt(st.nextToken());
        }
    }

    // 놓기 가능한지 계산하기 메서드
    public static void calcPossibleBlock(String kinds) {

        // 길이
        int blockLen = kinds.length();

        // 각 열을 시작으로 계산하기
        for(int colIndex=0; colIndex<=colSize-blockLen; colIndex++) {

            // 현재 높이에서 해당 블록의 공간 계산
            int gap = field[colIndex] - kinds.charAt(0)-'0';

            // 가능 여부
            boolean flag = true;

            // 옆으로 이동하며 비교
            for(int nextIndex=1; nextIndex<blockLen; nextIndex++) {

                // 차이가 다른 경우
                if(field[colIndex+nextIndex] - kinds.charAt(nextIndex)-'0' != gap) {
                    flag = false;
                    break;
                }
            }

            // 놓을 수 있는 경우
            if(flag) answer++;
        }
    }

    // 놓기 가능한 블록 경우의 수 구하기 메서드
    public static void calcPossibleCount() {

        switch(block) {

            // 1
            case 1:
                answer += colSize;
                calcPossibleBlock("0000");
                break;

            // 2
            case 2:
                calcPossibleBlock("00");
                break;

            // 3
            case 3:
                calcPossibleBlock("001");
                calcPossibleBlock("10");
                break;

            // 4
            case 4:
                calcPossibleBlock("100");
                calcPossibleBlock("01");
                break;

            // 5
            case 5:
                calcPossibleBlock("000");
                calcPossibleBlock("01");
                calcPossibleBlock("101");
                calcPossibleBlock("10");
                break;

            // 6
            case 6:
                calcPossibleBlock("000");
                calcPossibleBlock("00");
                calcPossibleBlock("011");
                calcPossibleBlock("20");
                break;

            // 7
            case 7:
                calcPossibleBlock("000");
                calcPossibleBlock("02");
                calcPossibleBlock("110");
                calcPossibleBlock("00");
                break;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 열의 개수, 블록 종류 입력
        st = new StringTokenizer(br.readLine());
        colSize = Integer.parseInt(st.nextToken());
        block = Integer.parseInt(st.nextToken());

        // 필드 배열 생성
        field = new int[colSize];

        // 필드 높이 입력
        inputFieldHeight(new StringTokenizer(br.readLine()));

        // 놓기 가능한 블록 경우의 수 구하기
        calcPossibleCount();

        // 결과 출력
        System.out.println(answer);
    }
}