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

        int count = 1;

        while(true) {
            // 종료 조건
            if(count==11)
                break;

            // 테스트 케이스 숫자 입력
            int caseNum = Integer.parseInt(br.readLine());

            // 큐 생성
            Queue<Integer> queue = new LinkedList<>();

            // 감소시킬 숫자
            int decline = 1;

            // 8개 숫자 입력
            st = new StringTokenizer(br.readLine());
            for(int n=0; n<8; n++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }

            // 0보다 작을 때까지 수행
            while(true) {

                // 숫자 꺼내기
                int number = queue.poll();

                // 숫자 1꺼내기
                number -= decline;
                if(number<=0) {
                    number = 0;
                    queue.offer(number);
                    break;
                }

                // 다시 넣기
                queue.offer(number);

                // 감소시킬 수 증가
                decline++;
                if(decline>5)
                    decline=1;
            }

            // 결과 저장
            sb.append("#"+count+" ");
            for(int element : queue)
                sb.append(element+" ");
            sb.append("\n");

            count++;
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}