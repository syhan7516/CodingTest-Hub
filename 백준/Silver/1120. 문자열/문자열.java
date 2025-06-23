import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과
    public static int answer;

    // 문자열 A, B
    public static String A, B;

    // 문자열 비교 메서드
    public static void solve() {

        // 문자 길이 차이만큼 비교
        for(int startIndex=0; startIndex<=B.length()-A.length(); startIndex++) {

            // 불일치 수
            int count = 0;

            // 비교
            for(int index=0; index<A.length(); index++) {

                // 비교 문자
                char a = A.charAt(index);
                char b = B.charAt(index+startIndex);

                // 문자가 불일치하는 경우
                if(a!=b) count++;
            }

            // 결과 갱신
            answer = Math.min(answer,count);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 문자열 입력
        st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();

        // 문자열 비교
        answer = 51;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}