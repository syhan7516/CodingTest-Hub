import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 반복 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 전체 과목 수, 선택 과목 수
            st = new StringTokenizer(br.readLine());
            int totalSubjectCnt = Integer.parseInt(st.nextToken());
            int selectSubjectCnt = Integer.parseInt(st.nextToken());

            // 과목 정보 입력
            int scores[] = new int[totalSubjectCnt];

            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<totalSubjectCnt; idx++) {
                scores[idx] = Integer.parseInt(st.nextToken());
            }

            // 과목 정렬
            Arrays.sort(scores);

            // 총점
            int scoreSum = 0;
            for(int idx=scores.length-1; idx>scores.length-selectSubjectCnt-1; idx--) {
                scoreSum += scores[idx];
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+scoreSum);
        }
    }
}