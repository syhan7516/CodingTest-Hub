
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 반복 수행
        while (true) {
            
            // 문자열 입력
            String str = br.readLine();
            boolean check = true;

            // 0인 경우
            if (str.equals("0")) break;

            // 각 대상 비교
            for (int idx=0; idx<str.length()/2; idx++) {
                if(str.charAt(idx)!=str.charAt(str.length()-1-idx)) check = false;
            }
            
            // 맞는 경우
            if (check) System.out.println("yes");
            // 아닌 경우
            else System.out.println("no");
        }
    }
}