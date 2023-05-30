import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 기준 문자열 입력
        String S = br.readLine();

        // 만들 문자열 입력
        sb.append(br.readLine());

        // 문자열 확인
        while(true) {

            // 기준 문자열과 만들 문자열의 길이가 같은 경우
            if(S.length()==sb.length()) {
                // 동일한 경우
                if(S.equals(sb.toString())) System.out.println(1);
                // 다른 경우
                else System.out.println(0);

                break;
            }

            // 맨 뒤 문자 확인
            char alpha = sb.charAt(sb.length()-1);

            // A인 경우
            if(alpha=='A') {
                sb.delete(sb.length()-1,sb.length());
            }

            // B인 경우
            else {
                sb.delete(sb.length()-1,sb.length());
                sb.reverse();
            }
        }
    }
}