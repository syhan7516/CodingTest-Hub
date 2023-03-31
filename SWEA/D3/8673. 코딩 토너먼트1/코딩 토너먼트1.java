import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 반복
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 토너먼트 큐 만들기
            Queue<Integer> game = new LinkedList<>();

            // 사람 수 입력
            int humanCnt = (int)Math.pow(2,Integer.parseInt(br.readLine()));

            // 코딩 실력 입력
            st = new StringTokenizer(br.readLine());
            for(int idx=0; idx<humanCnt; idx++) {
                int score = Integer.parseInt(st.nextToken());
                game.offer(score);
            }

            // 경기 진행
            int result = 0;
            while(!game.isEmpty()) {

                // 종료 조건
                if(game.size()==1)
                    break;

                // 경기할 두 사람 실력
                int firPlayer = game.poll();
                int secPlayer = game.poll();

                // 지루함 저장
                result += Math.abs(firPlayer-secPlayer);

                // 승자 저장
                game.offer(Math.max(firPlayer,secPlayer));
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}