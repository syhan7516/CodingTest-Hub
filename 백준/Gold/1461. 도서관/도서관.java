import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    // 결과, 책의 개수, 보유 가능 수
    public static int answer, bookCount, loadCount;

    // 책 위치 우선 순위 큐
    public static PriorityQueue<Integer> left, right;

    // 책 옮기기 메서드
    public static int solve(PriorityQueue<Integer> points) {

        // 거리
        int distance = 0;

        // 책 옮기기
        while(!points.isEmpty()){

            int currentDist = points.poll();
            for(int carry=1; carry<loadCount && !points.isEmpty(); carry++){
                points.poll();
            }
            distance += currentDist*2;
        }

        return distance;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 책의 수, 보유 가능 수 입력
        st = new StringTokenizer(br.readLine());
        bookCount = Integer.parseInt(st.nextToken());
        loadCount = Integer.parseInt(st.nextToken());

        // 책 위치 우선 순위 큐 생성
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>(Collections.reverseOrder());

        // 가장 먼 거리에 있는 책 위치
        int maxBookPoint = 0;

        // 책 위치 입력
        st = new StringTokenizer(br.readLine());
        for(int point=0; point<bookCount; point++) {

            // 책 위치 입력
            int book = Integer.parseInt(st.nextToken());

            // 오른쪽에 가까운 경우
            if(book>0) right.offer(Math.abs(book));
            
            // 왼쪽에 가까운 경우
            else left.offer(Math.abs(book));

            // 가장 먼 거리에 있는 책 위치
            maxBookPoint = Math.max(maxBookPoint,Math.abs(book));
        }

        // 책 옮기기
        answer = solve(left)+solve(right)-maxBookPoint;

        // 결과 출력
        System.out.println(answer);
    }
}