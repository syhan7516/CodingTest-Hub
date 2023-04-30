import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 테스트 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 숫자 개수 입력
            int numCnt = Integer.parseInt(br.readLine());

            // 숫자 정보 입력
            int nums[] = new int[numCnt];
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<nums.length; n++) {
                nums[n] = Integer.parseInt(st.nextToken());
            }

            // 숫자 합 확인
            int curNum = 0;
            int maxNum = Integer.MIN_VALUE;
            for(int n=0; n<nums.length; n++) {
                
                curNum += nums[n];

                maxNum = Math.max(maxNum,curNum);

                if(curNum<0)
                    curNum = 0;
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+maxNum+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}