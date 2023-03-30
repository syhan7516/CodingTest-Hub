import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 문자열 입력
            String letter = br.readLine();

            // 문자열 하이픈 배열
            int letters[] = new int[letter.length()+1];

            // 하이픈 개수 입력
            int cnt = Integer.parseInt(br.readLine());

            // 하이픈 정보
            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<cnt; idx++) {
                int point = Integer.parseInt(st.nextToken());
                letters[point] += 1;
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" ");
            for(int idx=0; idx<letter.length()+1; idx++) {
                int chCnt = letters[idx];
                while(true) {

                    // 종료 조건
                    if(chCnt==0)
                        break;

                    // 0이 아닌 경우
                    sb.append('-');

                    // 하이픈 개수 줄이기
                    chCnt--;
                }

                // 해당 위치 문자 저장
                if(letter.length()-1>=idx)
                    sb.append(letter.charAt(idx));
            }

            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}