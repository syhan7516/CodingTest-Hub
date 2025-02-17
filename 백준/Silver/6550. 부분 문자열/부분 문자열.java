import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;

        while((line = br.readLine()) != null) {

            // 두 문자열 입력
            st = new StringTokenizer(line);
            String letter1 = st.nextToken();
            String letter2 = st.nextToken();

            // 확인
            int point = 0;

            // 탐색
            for(int index=0; index<letter2.length(); index++) {

                if(letter1.charAt(point)==letter2.charAt(index))
                    point++;

                if(point==letter1.length())
                    break;
            }

            // 결과 출력
            if(point==letter1.length()) System.out.println("Yes");
            else System.out.println("No");
        }
    }
}