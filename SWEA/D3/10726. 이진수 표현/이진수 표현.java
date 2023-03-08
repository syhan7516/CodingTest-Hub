import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(st.nextToken());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 결과
            String result = "ON";
            // N, M 입력
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            // 진법 변환
            String binaryM = Integer.toString(M,2);
            
            // 비트 길이가 더 긴 경우
            if(binaryM.length()<N || M==0)
                result = "OFF";
            // 아닌 경우
            else {
                for(int idx=binaryM.length()-1; idx>binaryM.length()-1-N; idx--) {
                    if(binaryM.charAt(idx)=='0') {
                        result = "OFF";
                        break;
                    }
                }
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}