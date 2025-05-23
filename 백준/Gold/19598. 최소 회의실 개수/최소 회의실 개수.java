import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 회의 클래스
class Meeting {
    int startTime;
    int endTime;

    public Meeting(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

public class Main {

    // 결과, 회의 개수
    public static int answer, meetingCount;

    // 회의 배열
    public static Meeting[] meetings;

    // 회의실 개수 구하기 메서드
    public static void solve() {

        // 회의 종료 시간 기준 우선 순위 큐 생성
        PriorityQueue<Meeting> queue = new PriorityQueue<>((a,b) -> a.endTime - b.endTime);

        // 회의 시작 기준으로 정렬
        Arrays.sort(meetings, (a,b) -> a.startTime - b.startTime);

        // 회의실 배정하기
        for(int meetingIndex=0; meetingIndex<meetings.length; meetingIndex++) {

            // 현재 회의
            Meeting meeting = meetings[meetingIndex];

            // 진행 중인 회의 시간 확인
            while(!queue.isEmpty() && queue.peek().endTime<=meeting.startTime) {
                queue.poll();
            }

            // 현재 회의 시작하기
            queue.offer(meeting);

            // 필요 회의실 개수 갱신
            answer = Math.max(answer,queue.size());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 회의 개수 입력
        meetingCount = Integer.parseInt(br.readLine());

        // 회의 배열 생성
        meetings = new Meeting[meetingCount];

        // 회의 정보 입력
        for(int meettingIndex=0; meettingIndex<meetingCount; meettingIndex++) {
            st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            meetings[meettingIndex] = new Meeting(startTime,endTime);
        }

        // 회의실 개수 구하기
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}