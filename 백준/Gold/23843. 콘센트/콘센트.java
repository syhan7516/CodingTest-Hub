import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시간 클래스
class Time {
    int start;
    int end;

    public Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {

    // 결과, 기기 개수, 콘센트 개수
    public static int answer, equipmentCount, plugCount;

    // 우선 순위 큐
    public static PriorityQueue<Time> queue;

    // 전자기기 배열
    public static int[] equipments;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 기기 개수, 콘센트 개수 입력
        st = new StringTokenizer(br.readLine());
        equipmentCount = Integer.parseInt(st.nextToken());
        plugCount = Integer.parseInt(st.nextToken());

        // 전자기기 배열 생성
        equipments = new int[equipmentCount];

        // 전자기기 충전 시간 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<equipmentCount; index++) {
            equipments[index] = Integer.parseInt(st.nextToken());
        }

        // 오래 걸리는 순으로 정렬
        Arrays.sort(equipments);

        // 우선 순위 큐 생성
        queue = new PriorityQueue<>((a, b) -> a.end - b.end);

        // 전자기기 확인
        answer = 0;
        for(int index=equipmentCount-1; index>=0; index--) {

            // 자리가 없는 경우
            if(queue.size() >= plugCount) {
                int endTime = queue.peek().end;
                while(!queue.isEmpty() && queue.peek().end <= endTime) {
                    queue.poll();
                }

                answer = endTime;
            }

            queue.offer(new Time(answer, answer + equipments[index]));
        }

        // 충전 중인 전자기기 충전 완료시키기
        while(!queue.isEmpty()) {
            answer = queue.poll().end;
        }

        // 결과 출력
        System.out.println(answer);
    }
}