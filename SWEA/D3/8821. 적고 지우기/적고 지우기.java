import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 테스트 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 결과
            int count = 0;

            // 숫자 개수 배열
            boolean nums[] = new boolean[10];
            Arrays.fill(nums,false);

            // 숫자 문자열 입력
            String numLetters = br.readLine();
            // 숫자 적고, 지우기
            for(int n=0; n<numLetters.length(); n++) {
                int num = numLetters.charAt(n)-48;
                // 숫자가 있는 경우
                if(nums[num]==true)
                    nums[num] = false;
                else
                    nums[num] = true;
            }
            // 개수 확인
            for(int idx=0; idx<nums.length; idx++) {
                if(nums[idx]==true)
                    count += 1;
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+count);
        }
    }
}