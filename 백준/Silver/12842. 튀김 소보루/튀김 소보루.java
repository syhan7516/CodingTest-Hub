import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 친구 클래스
class Friend implements Comparable<Friend> {
    int saram;
    int time;
    int speed;

    public Friend(int saram, int time, int speed) {
        this.saram = saram;
        this.time = time;
        this.speed = speed;
    }

    @Override
    public int compareTo(Friend other) {
        if(this.time == other.time) {
            return this.saram - other.saram;
        }

        return this.time - other.time;
    }
}

public class Main {

    // 결과, 빵 개수, 남은 개수, 현재 시간, 인원
    public static int answer, breadCount, existCount, currentTime, saramCount;

    // 우선 순위 큐
    public static PriorityQueue<Friend> queue;

    // 먹기 수행
    public static void eatBread() {

        // 확인 친구
        Friend friend = queue.poll();
        answer = friend.saram;
        currentTime = friend.time;

        // 빵 먹기
        breadCount--;

        // 다음 빵먹는 시간 갱신
        friend.time += friend.speed;
        queue.offer(friend);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 빵 개수, 남은 개수 입력
        st = new StringTokenizer(br.readLine());
        breadCount = Integer.parseInt(st.nextToken());
        existCount = Integer.parseInt(st.nextToken());

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 인원 입력
        saramCount = Integer.parseInt(br.readLine());

        // 속도 입력
        for(int index=1; index<=saramCount; index++) {
            int speed = Integer.parseInt(br.readLine());
            queue.offer(new Friend(index, 0, speed));
        }

        // 탐색 수행
        answer = 0;
        currentTime = 0;
        while(breadCount > existCount) {
            eatBread();

            // 동일한 시간 내에 빵먹는 친구 확인
            while(breadCount > existCount && queue.peek().time == currentTime) {
                eatBread();
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}