import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 결과
        int count = 0;

        // 문자열1 & 문자열2 개수 입력
        int firLetterCnt = Integer.parseInt(st.nextToken());
        int secLetterCnt = Integer.parseInt(st.nextToken());

        // 해시셋
        Set<String> result = new HashSet<>();

        // 문자열 입력
        for(int idx=0; idx<firLetterCnt; idx++) {
            result.add(br.readLine());
        }

        // 문자열 확인
        for(int idx=0; idx<secLetterCnt; idx++) {
            if(result.contains(br.readLine()))
                count += 1;
        }

        // 결과 출력
        System.out.println(count);
    }
}