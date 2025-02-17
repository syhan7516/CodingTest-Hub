import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 레벨
    public static int level;

    // 결과, 먹을 개수
    public static long answer, tryCount;

    // 햄버거 높이 개수, 패티 개수 배열
    public static long[] count, meat;

    // 햄버거 높이 개수 저장 배열 생성 및 계산 메서드
    public static void calcCount() {

        // 기본 설정
        count = new long[51];
        meat = new long[51];
        count[0] = 1;
        count[1] = 5;
        count[2] = 13;
        meat[0] = 1;
        meat[1] = 3;
        meat[2] = 7;

        // 높이 개수 구하기
        for(int index=3; index<=50; index++) {
            count[index] = count[index-1]*2+3;
            meat[index] = meat[index-1]*2+1;
        }
    }

    // 햄버거 확인 메서드
    public static void solve(int currentLevel, long order) {

        // 못 먹는 경우
        if (order == 0) return;

        // 레벨 0인 경우
        if (currentLevel == 0) {
            answer++;
            return;
        }

        // 맨 밑 번먹기
        order--;

        if (count[currentLevel-1] == order) {
            order -= count[currentLevel-1];
            answer += meat[currentLevel-1];
            return;
        }

        else if (count[currentLevel-1] < order) {
            order -= count[currentLevel-1]+1;
            answer += meat[currentLevel-1]+1;
            solve(currentLevel-1,order);
        }

        else solve(currentLevel-1,order);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 햄버거 높이 개수 저장 배열 생성 및 계산
        calcCount();

        // 레벨, 먹을 개수 입력
        st = new StringTokenizer(br.readLine());
        level = Integer.parseInt(st.nextToken());
        tryCount = Long.parseLong(st.nextToken());

        // 햄버거 확인
        solve(level,tryCount);

        // 결과 출력
        System.out.println(answer);
    }
}