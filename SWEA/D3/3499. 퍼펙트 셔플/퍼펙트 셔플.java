import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

            // 카드 수 입력
            int cardCnt = Integer.parseInt(br.readLine());

            // 카드 정보 입력
            ArrayList<String> A = new ArrayList<>();
            ArrayList<String> B = new ArrayList<>();

            // 카드 배분
            st = new StringTokenizer(br.readLine());
            for(int d=0; d<cardCnt; d++) {
                if(d<=(cardCnt-1)/2)
                    A.add(st.nextToken());
                else
                    B.add(st.nextToken());
            }

            // 셔플
            sb.append("#"+(caseIdx+1)+" ");
            for(int d=0; d<B.size(); d++)
                sb.append(A.get(d)+" "+B.get(d)+" ");

            // 카드 수가 홀수인 경우 A 카드를 하나 더 넣기
            if(cardCnt%2!=0)
                sb.append(A.get(A.size()-1));

            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}