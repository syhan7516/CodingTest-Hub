import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 블록의 개수 입력
            int blockCnt = Integer.parseInt(br.readLine());

            // 블록 정보 입력 & 난이도 측정
            int upLevel = 0;
            int downLevel = 0;
            int blocks[] = new int[blockCnt];
            st = new StringTokenizer(br.readLine());
            blocks[0] = Integer.parseInt(st.nextToken());
            for(int b=1; b<blocks.length; b++) {
                blocks[b] = Integer.parseInt(st.nextToken());

                // 이동한 곳이 이전 보다 높은 경우
                if(blocks[b] > blocks[b-1])
                    upLevel = Math.max(upLevel,blocks[b]-blocks[b-1]);
                // 이동한 곳이 이전 보다 낮은 경우
                else if(blocks[b] < blocks[b-1])
                    downLevel = Math.max(downLevel,blocks[b-1]-blocks[b]);
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+upLevel+" "+downLevel);
        }
    }
}