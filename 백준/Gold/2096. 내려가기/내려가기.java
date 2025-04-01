import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 입출력
    public static BufferedReader br;
    public static StringTokenizer st;

    // 줄 수, 최댓값, 최솟값
    public static int lineCount, maxValue, minValue;

    // 단계 배열
    public static int[][] stages;
    public static int[][] maxStages;
    public static int[][] minStages;

    // 줄 수 입력 메서드
    public static void inputLineCount() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        lineCount = Integer.parseInt(br.readLine());
    }

    // 단계 배열 생성
    public static void createStageArray() {
        stages = new int[lineCount+1][3];
        maxStages = new int[lineCount+1][3];
        minStages = new int[lineCount+1][3];
    }

    // 단계 점수 입력 메서드
    public static void inputStageScore() throws IOException {

        for(int lineIndex=1; lineIndex<=lineCount; lineIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int orderIndex=0; orderIndex<3; orderIndex++) {
                stages[lineIndex][orderIndex] = Integer.parseInt(st.nextToken());
            }
        }
    }

    // 최댓값, 최솟값 설정 메서드
    public static void initMaxValueAndMinValue() {
        maxValue = 0;
        minValue = Integer.MAX_VALUE;
    }

    // 최댓값 연산 메서드
    public static void computeMaxValue(int lineIndex) {

        maxStages[lineIndex][0] = Math.max(maxStages[lineIndex-1][0],maxStages[lineIndex-1][1])+stages[lineIndex][0];
        maxStages[lineIndex][2] = Math.max(maxStages[lineIndex-1][1],maxStages[lineIndex-1][2])+stages[lineIndex][2];
        maxStages[lineIndex][1] = Math.max(Math.max(maxStages[lineIndex-1][0],maxStages[lineIndex-1][1]),maxStages[lineIndex-1][2])+stages[lineIndex][1];
    }

    // 최솟값 연산 메서드
    public static void computeMinValue(int lineIndex) {

        minStages[lineIndex][0] = Math.min(minStages[lineIndex-1][0],minStages[lineIndex-1][1])+stages[lineIndex][0];
        minStages[lineIndex][2] = Math.min(minStages[lineIndex-1][1],minStages[lineIndex-1][2])+stages[lineIndex][2];
        minStages[lineIndex][1] = Math.min(Math.min(minStages[lineIndex-1][0],minStages[lineIndex-1][1]),minStages[lineIndex-1][2])+stages[lineIndex][1];
    }

    // 내려가기 메서드
    public static void solve() {

        for(int lineIndex=1; lineIndex<=lineCount; lineIndex++) {
            computeMaxValue(lineIndex);
            computeMinValue(lineIndex);
        }
    }

    // 최솟값, 최댓값 저장 메서드
    public static void saveMaxAndMin() {

        for(int orderIndex=0; orderIndex<3; orderIndex++) {
            maxValue = Math.max(maxValue,maxStages[lineCount][orderIndex]);
            minValue = Math.min(minValue,minStages[lineCount][orderIndex]);
        }
    }

    // 초기화 메서드
    public static void initialize() throws IOException {

        // 최댓값, 최솟값 설정
        initMaxValueAndMinValue();

        // 줄 수 입력
        inputLineCount();

        // 단계 배열 생성
        createStageArray();

        // 단계 점수 입력
        inputStageScore();
    }

    public static void main(String[] args) throws IOException {

        // 초기화
        initialize();

        // 내려가기
        solve();

        // 최솟값, 최댓값 저장
        saveMaxAndMin();

        // 결과 출력
        System.out.println(maxValue+" "+minValue);
    }
}