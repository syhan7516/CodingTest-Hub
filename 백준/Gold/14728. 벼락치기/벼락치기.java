import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 단원 개수, 공부 가능 시간
    public static int chapterCount, possibleTime;

    // DP 배열
    public static int DP[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 단원 개수, 공부 가능 시간 입력
        st = new StringTokenizer(br.readLine());
        chapterCount = Integer.parseInt(st.nextToken());
        possibleTime = Integer.parseInt(st.nextToken());

        // DP 배열 생성
        DP = new int[chapterCount+1][possibleTime+1];

        // 단원 정보, 공부 시간 입력
        for(int chapter=1; chapter<=chapterCount; chapter++) {
            st = new StringTokenizer(br.readLine());
            int studyTime = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            for(int time=1; time<=possibleTime; time++) {
                
                if(time<studyTime) {
                    DP[chapter][time] = DP[chapter-1][time];
                }

                else {
                    DP[chapter][time] = Math.max(DP[chapter-1][time-studyTime]+score,DP[chapter-1][time]);
                }
            }
        }

        // 결과 출력
        System.out.println(DP[chapterCount][possibleTime]);
    }
}