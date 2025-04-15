import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 문제 난이도 최소, 최대 값
    public static final int MIN_LEVEL = 0;
    public static final int MAX_LEVEL = 1000001;

    // 결과, 문제 수, 최소 합, 최대 합, 최소최대 난이도 차
    public static int answer, problemCount, minSum, maxSum, valueRange;

    // 문제 난이도 저장 배열
    public static int[] problemLevels;

    // 문제 선정 메서드
    public static void solve(int problem, int selectedCount, int sum, int minLevel, int maxLevel) {

        // 문제를 다 고른 경우
        if(problem==problemCount) {

            // 선택된 문제가 2개 미만인 경우
            if(selectedCount<2) return;

            // 난이도 합이 최소보다 작고, 최대보다 큰 경우
            if(sum<minSum || sum>maxSum) return;

            // 최대, 최소 난이도 차 확인
            if(maxLevel-minLevel<valueRange) return;

            // 방법 수 증가
            answer++;

            return;
        }

        // 선택
        solve(problem+1,selectedCount+1,sum+problemLevels[problem]
                ,Math.min(minLevel,problemLevels[problem]),Math.max(maxLevel,problemLevels[problem]));

        // 미선택
        solve(problem+1,selectedCount,sum,minLevel,maxLevel);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 문제 수, 최소 합, 최대 합, 최소최대 난이도 차 입력
        st = new StringTokenizer(br.readLine());
        problemCount = Integer.parseInt(st.nextToken());
        minSum = Integer.parseInt(st.nextToken());
        maxSum = Integer.parseInt(st.nextToken());
        valueRange = Integer.parseInt(st.nextToken());

        // 문제 난이도 저장 배열 생성
        problemLevels = new int[problemCount];

        // 문제 난이도 입력
        st = new StringTokenizer(br.readLine());
        for(int problemIndex=0; problemIndex<problemCount; problemIndex++) {
            problemLevels[problemIndex] = Integer.parseInt(st.nextToken());
        }

        // 문제 선정
        solve(0,0,0,MAX_LEVEL,MIN_LEVEL);

        // 결과 출력
        System.out.println(answer);
    }
}