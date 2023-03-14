import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 테스트 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 문자 구멍 수 저장 배열
            int holeCnt[] = {1,2,0,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0};

            // 실제 문자열 & 비교 문자열 입력
            st = new StringTokenizer(br.readLine());
            String firLetters = st.nextToken();
            String secLetters = st.nextToken();

            // 각 문자열 동일 여부
            boolean flag = true;

            // 두 문자열 길이가 다른 경우
            if(firLetters.length()!=secLetters.length())
                flag = false;

            // 두 문자여 길이가 같은 경우
            else {
                for(int idx=0; idx<firLetters.length(); idx++) {
                    int firHoleIdx = firLetters.charAt(idx)-65;
                    int secHoleIdx = secLetters.charAt(idx)-65;
                    // 단어 구멍 수가 같은 경우
                    if(holeCnt[firHoleIdx]==holeCnt[secHoleIdx])
                        continue;
                    // 단어 구멍 수가 다른 경우
                    else {
                        flag = false;
                        break;
                    }
                }
            }

            // 결과 출력
            System.out.print("#"+(caseIdx+1)+" ");
            if(flag==true)
                System.out.println("SAME");
            else
                System.out.println("DIFF");
        }
    }
}
