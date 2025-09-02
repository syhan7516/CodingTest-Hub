import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시간 클래스
class Time {
    String startTime;
    String endTime;

    public Time(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

public class Main {

    // 버스 개수
    public static int busCount;

    // 시간표 저장 리스트
    public static ArrayList<Time> times;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 버스 개수 입력
        busCount = Integer.parseInt(br.readLine());

        // 시간표 저장 리스트 생성
        times = new ArrayList<>();

        // 버스 시간표 입력
        for(int index=0; index<busCount; index++) {
            st = new StringTokenizer(br.readLine());
            times.add(new Time(st.nextToken(), st.nextToken()));
        }

        // 들어오는 시간 순서로 정렬
        Collections.sort(times, (a, b) -> a.startTime.compareTo(b.startTime));

        // 우선 순위 큐 생성 - 나가는 순으로 정렬
        PriorityQueue<Time> queue = new PriorityQueue<>(
                (a, b) -> a.endTime.compareTo(b.endTime)
        );

        // 버스 확인
        int answer = 0;
        for(int index=0; index<times.size(); index++) {
            
            // 확인 버스
            Time time = times.get(index);

            // 이미 들어온 버스가 있으면, 나가는 시간이 현재 들어오는 버스보다 작거나 같은 경우 내보내기
            while(!queue.isEmpty() && queue.peek().endTime.compareTo(time.startTime) <= 0) {
                queue.poll();
            }

            // 현재 버스 주차
            queue.offer(time);
            
            // 개수 갱신
            answer = Math.max(answer, queue.size());
        }

        // 결과 출력
        System.out.println(answer);
    }
}