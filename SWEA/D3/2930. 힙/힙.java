
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
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

            // 우선 순위 큐 생성
            PriorityQueue<Integer> priQ = new PriorityQueue<>();

            // 연산의 수 입력
            int opCnt = Integer.parseInt(br.readLine());

            // 연산 정보 입력
            sb.append("#"+(caseIdx+1)+" ");
            for(int o=0; o<opCnt; o++) {
                st = new StringTokenizer(br.readLine());
                int opNum = Integer.parseInt(st.nextToken());

                // 1의 연산
                if(opNum==1) {
                    priQ.offer(-Integer.parseInt(st.nextToken()));
                }
                // 2의 연산
                else {
                    if(priQ.isEmpty())
                        sb.append(-1+" ");
                    else
                        sb.append(-priQ.poll()+" ");
                }
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}