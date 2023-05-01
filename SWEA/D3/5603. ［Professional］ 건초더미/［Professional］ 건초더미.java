import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 건초더미 개수 입력
            int cnt = Integer.parseInt(br.readLine());

            // 건초더미 정보 입력
            int result = 0;
            int avg = 0;
            int dumy[] = new int[cnt];
            for(int d=0; d<cnt; d++) {
                dumy[d] = Integer.parseInt(br.readLine());
                avg += dumy[d];
            }

            // 더미 평균구하기
            avg = avg/cnt;

            // 더미 정렬
            Arrays.sort(dumy);

            // 더미 옮기기
            int left = 0;
            int right = dumy.length-1;

            while(left<right) {

                // 여분의 더미 구하기
                int extra = dumy[right]-avg;
                right--;

                while(true) {

                    // 여분의 더미를 다 사용한 경우
                    if(extra==0)
                        break;

                    // 더미 채우기
                    dumy[left]++;
                    result++;
                    extra--;

                    // 더미를 다 채운 경우
                    if(dumy[left]==avg)
                        left++;
                }
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}