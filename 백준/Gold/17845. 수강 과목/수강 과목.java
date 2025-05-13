import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 과목
class Subject {
    int importance;
    int requiredTime;

    public Subject(int importance, int requiredTime) {
        this.importance = importance;
        this.requiredTime = requiredTime;
    }
}

public class Main {

    // 최대 공부 시간, 과목 수
    public static int maxStudyTime, subjectCount;

    // 과목 정보 배열
    public static Subject[] subjects;

    // 수강 정보 배열
    public static int[][] DP;

    // 시간 범위 확인 메서드
    public static boolean isNotTimeLessThanZero(int time, int requiredTime) {
        return time >= requiredTime;
    }

    // 수강하기 메서드
    public static void solve() {

        // 수강 정보 배열 생성
        DP = new int[subjectCount+1][maxStudyTime+1];

        // 과목 확인
        for(int subjectIndex=0; subjectIndex<subjectCount; subjectIndex++) {

            // 수강 정보 비교
            for(int time=1; time<=maxStudyTime; time++) {

                // 현재 과목 수강이 가능한 경우
                if(isNotTimeLessThanZero(time,subjects[subjectIndex].requiredTime)) {
                    DP[subjectIndex+1][time] = Math.max(DP[subjectIndex][time],
                            DP[subjectIndex][time-subjects[subjectIndex].requiredTime]+subjects[subjectIndex].importance);
                }

                // 불가능한 경우
                else {
                    DP[subjectIndex+1][time] = DP[subjectIndex][time];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 최대 공부 시간, 과목 수 입력
        st = new StringTokenizer(br.readLine());
        maxStudyTime = Integer.parseInt(st.nextToken());
        subjectCount = Integer.parseInt(st.nextToken());

        // 과목 정보 배열 생성
        subjects = new Subject[subjectCount];

        // 과목 정보 입력
        for(int subjectIndex=0; subjectIndex<subjectCount; subjectIndex++) {
            st = new StringTokenizer(br.readLine());
            int importance = Integer.parseInt(st.nextToken());
            int requiredTime = Integer.parseInt(st.nextToken());
            subjects[subjectIndex] = new Subject(importance,requiredTime);
        }

        // 수강하기
        solve();

        // 결과 출력
        System.out.println(DP[subjectCount][maxStudyTime]);
    }
}