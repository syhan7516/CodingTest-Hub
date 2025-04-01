import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 칸 수
    public static final int ORDER_COUNT = 3;

    // 입출력
    public static BufferedReader br;
    public static StringTokenizer st;

    // 줄 수, 최댓값, 최솟값
    public static int lineCount, maxValue, minValue;

    // 단계 배열
    public static int[][] stages;
    public static int[] maxStages;
    public static int[] minStages;

    // 줄 수 입력 메서드
    public static void inputLineCount() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        lineCount = Integer.parseInt(br.readLine());
    }

    // 단계 배열 생성
    public static void createStageArray() {
        stages = new int[lineCount+1][ORDER_COUNT];
        maxStages = new int[ORDER_COUNT];
        minStages = new int[ORDER_COUNT];
    }

    // 단계 점수 입력 메서드
    public static void inputStageScore() throws IOException {

        for(int lineIndex=1; lineIndex<=lineCount; lineIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int orderIndex=0; orderIndex<ORDER_COUNT; orderIndex++) {
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

        // 현재 값 기록
        int currentZeroIndexMaxValue = maxStages[0];
        int currentTwoIndexMaxValue = maxStages[2];

        // 최댓값 구하기
        maxStages[0] = Math.max(maxStages[0],maxStages[1])+stages[lineIndex][0];
        maxStages[2] = Math.max(maxStages[1],maxStages[2])+stages[lineIndex][2];
        maxStages[1] = Math.max(Math.max(currentZeroIndexMaxValue,maxStages[1]),currentTwoIndexMaxValue)+stages[lineIndex][1];
    }

    // 최솟값 연산 메서드
    public static void computeMinValue(int lineIndex) {

        // 현재 값 기록
        int currentZeroIndexMaxValue = minStages[0];
        int currentTwoIndexMaxValue = minStages[2];

        // 최솟값 구하기
        minStages[0] = Math.min(minStages[0],minStages[1])+stages[lineIndex][0];
        minStages[2] = Math.min(minStages[1],minStages[2])+stages[lineIndex][2];
        minStages[1] = Math.min(Math.min(currentZeroIndexMaxValue,minStages[1]),currentTwoIndexMaxValue)+stages[lineIndex][1];
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

        for(int orderIndex=0; orderIndex<ORDER_COUNT; orderIndex++) {
            maxValue = Math.max(maxValue,maxStages[orderIndex]);
            minValue = Math.min(minValue,minStages[orderIndex]);
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