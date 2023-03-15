import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 숫자 개수 입력
            int numCnt = Integer.parseInt(br.readLine());

            // 숫자 입력
            int result = 0;
            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<numCnt; idx++) {
                // 첫 값은 저장
                if(idx==0)
                    result = Integer.parseInt(st.nextToken());
                // 일반적인 연산
                else {
                    int number = Integer.parseInt(st.nextToken());
                    // 곱하려는 수나 곱당하는 수가 1보다 작다면 더하기
                    if(result<=1 || number<=1)
                        result += number;
                    // 아니라면 곱하기
                    else
                        result *= number;
                }
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}