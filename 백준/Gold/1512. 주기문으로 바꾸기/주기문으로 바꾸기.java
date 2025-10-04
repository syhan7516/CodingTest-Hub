import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력 받기
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine().trim();

        int answer = Integer.MAX_VALUE;

        // M 값을 줄여가며 검사
        for (int m = M; m > 0; m--) {
            int cnt = 0;

            // 주기 내 그룹별 처리
            for (int i = 0; i < m; i++) {
                int[] count = new int[4]; // A=0, C=1, G=2, T=3
                int total = 0;
                int maxCount = 0;

                for (int j = i; j < s.length(); j += m) {
                    char c = s.charAt(j);
                    int idx;
                    if (c == 'A') idx = 0;
                    else if (c == 'C') idx = 1;
                    else if (c == 'G') idx = 2;
                    else idx = 3;
                    count[idx]++;
                    maxCount = Math.max(maxCount, count[idx]);
                    total++;
                }

                cnt += total - maxCount; // 바꿔야 하는 문자 수
            }

            answer = Math.min(answer, cnt);
        }

        System.out.println(answer);
    }
}