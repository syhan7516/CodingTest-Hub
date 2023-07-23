import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 약수 개수 입력
            int numCnt = Integer.parseInt(br.readLine());

            // 약수 정보 입력
            int [] nums = new int[numCnt];

            st = new StringTokenizer(br.readLine());
            for(int n=0; n<numCnt; n++) {
                nums[n] = Integer.parseInt(st.nextToken());
            }

            // 약수 정보 정렬
            Arrays.sort(nums);

            // 결과 구하기
            int result = 0;

            // 개수가 한 개인 경우
            if(numCnt==1) {
                result = nums[0]*nums[0];
            }

            // 여러 개인 경우
            else {

                // 개수가 짝수 개인 경우
                if(numCnt%2==0) {
                    result = nums[0]*nums[nums.length-1];
                }

                // 개수가 홀수 개인 경우
                else {
                    int idx = nums.length/2;
                    result = nums[idx]*nums[idx];
                }
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}