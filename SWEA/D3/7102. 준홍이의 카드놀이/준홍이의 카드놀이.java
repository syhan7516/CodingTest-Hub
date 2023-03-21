import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 세트 당 개수 입력
            st = new StringTokenizer(br.readLine());
            int firSet = Integer.parseInt(st.nextToken());
            int secSet = Integer.parseInt(st.nextToken());

            // 카드 조합
            int maxNum = 0;
            int numSum = firSet + secSet;
            int nums[] = new int[numSum+1];
            for(int a=1; a<=firSet; a++) {
                for(int b=1; b<=secSet; b++) {
                    nums[a+b] += 1;
                    maxNum = Math.max(maxNum,nums[a+b]);
                }
            }

            // 카드 확인
            System.out.print("#"+(caseIdx+1)+" ");
            for(int card=0; card<nums.length; card++) {
                if(nums[card]==maxNum)
                    System.out.print(card+" ");
            }
            System.out.println();
        }
    }
}