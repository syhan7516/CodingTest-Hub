import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 숫자 배열
    public static char nums[];
    // 교환 횟수
    public static int cnt;
    // 결과
    public static int result;

    // 숫자 교환하기
    static void solve(int idx, int curCnt) {

        // 교환을 다한 경우
        if(cnt==curCnt) {

            // 숫자 연결
            String letter = "";
            for(char c: nums) letter += c;

            // 최대 값 갱신
            result = Math.max(result,Integer.parseInt(letter));

            return;
        }

        // 덜 교환한 경우
        for(int a=idx; a<nums.length; a++) {
            for(int b=a+1; b<nums.length; b++) {

                // 교환
                char temp = nums[a];
                nums[a] = nums[b];
                nums[b] = temp;

                // 다음 단계
                solve(a,curCnt+1);

                // 다시 복구
                temp = nums[a];
                nums[a] = nums[b];
                nums[b] = temp;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 숫자, 교환 횟수 입력
            st = new StringTokenizer(br.readLine());
            nums = st.nextToken().toCharArray();
            cnt = Integer.parseInt(st.nextToken());

            // 교환 횟수가 자리 수보다 클 경우
            if(nums.length<cnt) cnt = nums.length;

            // 숫자 교환하기
            result = 0;
            solve(0,0);

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}