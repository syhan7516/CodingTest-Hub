import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    // 최대, 최소 우선 순위 큐
    public static PriorityQueue<Integer> max, min;

    // 숫자 정보 해시
    public static HashMap<Integer,Integer> nums;

    // 최대, 최소 값 큐에서 제거 메서드
    static int delete(PriorityQueue<Integer> queue) {

        while(true) {

            // 숫자 꺼내기
            int current = queue.poll();

            // 없는 경우
            if(!nums.containsKey(current)) continue;

            // 1개 존재하는 경우
            if(nums.get(current)==1) nums.remove(current);

            // 2개 이상인 경우
            else {
                nums.put(current,nums.get(current)-1);
            }

            return current;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 우선 순위 큐 생성
            max = new PriorityQueue<>(Collections.reverseOrder());
            min = new PriorityQueue<>();

            // 숫자 정보 해시 생성
            nums = new HashMap<>();

            // 연산 개수 입력
            int cnt = Integer.parseInt(br.readLine());

            // 연산 수행
            for(int i=0; i<cnt; i++) {

                // 연산 정보 입력
                st = new StringTokenizer(br.readLine());
                char kind = st.nextToken().charAt(0);
                int number = Integer.parseInt(st.nextToken());

                // I
                if(kind=='I') {
                    max.offer(number);
                    min.offer(number);
                    nums.put(number,nums.getOrDefault(number,0)+1);
                }

                // D
                else {
                    // 수가 없는 경우
                    if(nums.size()==0) continue;

                    // 1 : 최댓값 삭제
                    if(number==1) {
                        // 제거
                        delete(max);
                    }

                    // -1 : 최솟값 삭제
                    else {
                        // 제거
                        delete(min);
                    }
                }
            }

            // 결과 저장
            if(nums.size()==0) sb.append("EMPTY").append("\n");

            else {
                if(nums.size()==1) {
                    int result = delete(max);
                    sb.append(result).append(" ").append(result).append("\n");
                }
                else
                    sb.append(delete(max)).append(" ").append(delete(min)).append("\n");
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}