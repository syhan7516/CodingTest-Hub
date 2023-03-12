import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 과자 개수, 무게 제한 입력
            st = new StringTokenizer(br.readLine());
            int cracker = Integer.parseInt(st.nextToken());
            int maxWeight = Integer.parseInt(st.nextToken());

            // 각 과자 개수 무게 입력
            int crackerWeight[] = new int[cracker];
            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<cracker; idx++) {
                crackerWeight[idx] = Integer.parseInt(st.nextToken());
            }

            // 과자들어보기
            int result = -1;
            for(int a=0; a<crackerWeight.length-1; a++) {
                for(int b=a+1; b<crackerWeight.length; b++) {
                    int totalWeight = crackerWeight[a] + crackerWeight[b];
                    if(totalWeight<=maxWeight)
                        result = Math.max(result,totalWeight);
                }
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}
