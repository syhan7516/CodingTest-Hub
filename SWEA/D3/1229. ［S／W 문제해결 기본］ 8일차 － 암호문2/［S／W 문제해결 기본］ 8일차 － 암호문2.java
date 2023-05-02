import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 케이스 10번 수행
        for(int caseIdx=0; caseIdx<10; caseIdx++) {

            // 암호문 길이 입력
            int sentenseCnt = Integer.parseInt(br.readLine());

            // 암호문 입력
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> sentense = new ArrayList<>();
            for(int s=0; s<sentenseCnt; s++) {
                int num = Integer.parseInt(st.nextToken());
                sentense.add(num);
            }

            // 명령어 개수 입력
            int orderCnt = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int o=0; o<orderCnt; o++) {

                // 명령어, 위치, 개수 입력
                char order = st.nextToken().charAt(0);
                int point = Integer.parseInt(st.nextToken());
                int cnt = Integer.parseInt(st.nextToken());
                
                // 삽입 명령어인 경우
                if(order=='I') {
                    // 명령어 수행
                    for(int i=0; i<cnt; i++) {
                        int num = Integer.parseInt(st.nextToken());
                        sentense.add(point+i,num);
                    }
                }
                
                // 삭제 명령어인 경우
                else {
                    // 명령어 수행
                    for(int d=0; d<cnt; d++) {
                        sentense.remove(point);
                    }
                }
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" ");
            for(int res=0; res<10; res++)
                sb.append(sentense.get(res)+" ");
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}