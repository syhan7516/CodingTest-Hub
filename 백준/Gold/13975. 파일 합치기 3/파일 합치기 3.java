import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 우선 순위 큐 생성
            PriorityQueue<Long> queue = new PriorityQueue<>();

            // 파일 개수 입력
            int fileCnt = Integer.parseInt(br.readLine());

            // 파일 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<fileCnt; i++)
                queue.offer(Long.parseLong(st.nextToken()));

            // 파일 크기
            long answer = 0;

            // 파일 합치기
            while(queue.size()>1) {

                long size = queue.poll()+queue.poll();
                answer += size;
                queue.offer(size);
            }

            // 결과 저장
            sb.append(answer).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}