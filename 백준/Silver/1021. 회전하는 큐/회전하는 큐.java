import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 덱
        LinkedList<Integer> deque = new LinkedList<>();
        
        // 사이즈, 뽑을 개수 입력
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int selectCnt = Integer.parseInt(st.nextToken());

        // 결과
        int result = 0;
        
        // 숫자 삽입
        for (int idx=1; idx<=size; idx++) {
            deque.offer(idx);
        }
        
        // 위치 입력
        st = new StringTokenizer(br.readLine());
        for (int idx=0; idx<selectCnt; idx++) {
            int point = Integer.parseInt(st.nextToken());
            int locate = deque.indexOf(point);
            
            if(locate!=0) {
                if(locate<=deque.size()/2) {
                    while(deque.getFirst()!=point) {
                        deque.offer(deque.poll());
                        result++;
                    }
                } 
                else {
                    while(deque.getFirst()!=point) {
                        deque.addFirst(deque.removeLast());
                        result++;
                    }
                }
            }
            
            deque.poll();
        }
        
        // 결과 출력
        System.out.println(result);
    }
}
