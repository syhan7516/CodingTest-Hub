import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 숫자 체크 함수
    static int getNumCheck(int number) {
        int value = number;

        // 초기값
        int preNum = value%10;
        int curNum = -1;
        value = value/10;

        // 자리마다 확인
        while(value>0) {
            curNum = value%10;
            if(preNum-1!=curNum)
                return -1;

            preNum = curNum;
            value = value/10;
        }
        return number;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 숫자 개수
            int numCnt = Integer.parseInt(br.readLine());
            // 숫자 배열
            int nums[] = new int[numCnt];
            // 숫자 입력
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<numCnt; n++) {
                nums[n] = Integer.parseInt(st.nextToken());
            }
            // 숫자 확인
            int result = -1;
            for(int firNum=0; firNum<numCnt-1; firNum++) {
                for(int secNum=firNum+1; secNum<numCnt; secNum++) {
                    int number = nums[firNum] * nums[secNum];
                    result = Math.max(result,getNumCheck(number));
                }
            }
            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}