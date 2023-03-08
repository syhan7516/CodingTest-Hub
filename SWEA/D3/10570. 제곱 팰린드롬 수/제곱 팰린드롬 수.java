import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 회문 검사
    static boolean check(int number) {
        String letters = Integer.toString(number);
        for(int sol=0; sol<letters.length()/2; sol++) {
            if(letters.charAt(sol)!=letters.charAt(letters.length()-sol-1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 제곱 정보
        int square[] = new int[33];
        for(int idx=1; idx<square.length; idx++)
            square[idx] = idx * idx;


        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(st.nextToken());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 결과
            int result = 0;

            // A, B 입력
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 확인
            for(int idx=1; idx<square.length; idx++) {
                if(square[idx]>=start && square[idx]<=end) {
                    int number = square[idx];
                    if(check(number) && check((int)Math.sqrt(number))) {
                        result += 1;
                    }
                }
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}