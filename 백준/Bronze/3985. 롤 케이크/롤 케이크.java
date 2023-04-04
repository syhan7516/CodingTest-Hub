import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 케이크 길이 입력
        int cakeLen = Integer.parseInt(br.readLine());

        // 방청객 수 입력
        int human = Integer.parseInt(br.readLine());

        // 케이크 정보 배열
        boolean cake[] = new boolean[cakeLen+1];

        // 결과 저장 배열
        int result[] = new int[4];

        // 원하는 조각 정보 입력
        for(int idx=0; idx<human; idx++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 케이크를 받을 예상 길이
            int getGuessCakeLen = 0;
            getGuessCakeLen = end - start;

            // 예상 길이 비교
            if(result[0]<getGuessCakeLen) {
                result[0] = getGuessCakeLen;
                result[1] = idx+1;
            }

            // 실제로 케이크를 얻은 길이
            int getRealCakeLen = 0;
            for(int c=start; c<=end; c++) {
                if(!cake[c]) {
                    getRealCakeLen += 1;
                    cake[c] = true;
                }
            }

            // 실제 케이크 길이 비교
            if(result[2]<getRealCakeLen) {
                result[2] = getRealCakeLen;
                result[3] = idx+1;
            }
        }

        // 결과 출력
        System.out.println(result[1]);
        System.out.println(result[3]);
    }
}