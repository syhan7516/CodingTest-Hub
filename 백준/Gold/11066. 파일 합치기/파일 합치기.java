import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 장 수
    public static int chapterCount;

    // 장 수 정보 배열
    public static int[] chapters;

    // 장 수 누적합 배열
    public static int[] prefixSum;

    // 최소 비용 배열
    public static int[][] DP;

    // 파일 합차기 메서드
    public static int solve() {

        // 최소 비용 배열 생성
        DP = new int[chapterCount+1][chapterCount+1];
        
        for (int len=1; len<=chapterCount; len++) {
            for (int startIndex=1; startIndex+len<=chapterCount; startIndex++) {
                int range = startIndex+len;
                DP[startIndex][range] = Integer.MAX_VALUE;
                for (int endIndex=startIndex; endIndex<range; endIndex++) {
                    DP[startIndex][range] = Math.min(DP[startIndex][range],
                            DP[startIndex][endIndex]+DP[endIndex+1][range]+prefixSum[range]-prefixSum[startIndex-1]);
                }
            }
        }

        return DP[1][chapterCount];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseIndex=0; caseIndex<caseCount; caseIndex++) {

            // 장 수 입력
            chapterCount = Integer.parseInt(br.readLine());

            // 장 수 정보 배열 생성
            chapters = new int[chapterCount+1];

            // 장 수 누적합 배열 생성
            prefixSum = new int[chapterCount+1];

            // 장 수 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int chapterIndex=1; chapterIndex<=chapterCount; chapterIndex++) {
                chapters[chapterIndex] = Integer.parseInt(st.nextToken());;
                prefixSum[chapterIndex] = prefixSum[chapterIndex-1]+chapters[chapterIndex];
            }

            // 파일 합치기
            sb.append(solve()).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}