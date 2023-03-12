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

            // 모래시계 개수, 삶는 시간, 오차 입력
            st = new StringTokenizer(br.readLine());
            int clockCnt = Integer.parseInt(st.nextToken());
            int cookTime = Integer.parseInt(st.nextToken());
            int diffTime = Integer.parseInt(st.nextToken());

            // 모래시계 정보 입력
            st = new StringTokenizer(br.readLine());
            int clocks[] = new int[clockCnt];
            for(int idx=0; idx<clockCnt; idx++) {
                clocks[idx] = Integer.parseInt(st.nextToken());
            }

            // 모래시계 확인
            int count = 0;
            int minTime = cookTime-diffTime;
            int maxTime = cookTime+diffTime;
            for(int idx=0; idx<clocks.length; idx++) {
                int n = 1;
                while(true) {
                    int getTimeCheck  = clocks[idx] * n;

                    // 종료 조건
                    if(getTimeCheck>maxTime)
                        break;

                    // 오차안에 들어올 경우
                    if(getTimeCheck>=minTime && getTimeCheck<=maxTime) {
                        count += 1;
                        break;
                    }
                    // 아닐 경우
                    else
                        n += 1;
                }
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+count);
        }
    }
}
