import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 선 자르기 메서드
    static long solve(long left, long right, long lines[], int target) {

        // 탐색
        while(left<=right) {

            long mid = (left+right)/2;
            long lineLen = 0;

            // 자른 선의 길이
            for (int i=0; i<lines.length; i++)
                lineLen += (lines[i]/mid);

            if(lineLen<target)
                right = mid-1;
            else
                left = mid+1;
        }

        return right;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 랜선 개수와 필요 수 입력
        st = new StringTokenizer(br.readLine());
        int lineCnt = Integer.parseInt(st.nextToken());
        int lineResCnt = Integer.parseInt(st.nextToken());

        // 랜선 정보 배열 생성
        long lines[] = new long[lineCnt];

        // 가장 긴 랜선
        long maxLen = 0;

        // 랜선 정보 입력
        for (int i=0; i<lineCnt; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            maxLen = Math.max(maxLen, lines[i]);
        }

        // 선 자르기
        long result = solve(1,maxLen,lines,lineResCnt);

        // 결과 출력
        System.out.println(result);
    }
}