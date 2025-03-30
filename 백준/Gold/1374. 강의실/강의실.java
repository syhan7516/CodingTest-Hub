import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 강의 클래스
class Lecture {
    int lectureID;
    int startTime;
    int endTime;

    public Lecture(int lectureID, int startTime, int endTime) {
        this.lectureID = lectureID;
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

public class Main {

    // 강의실 개수, 강의 개수
    public static int maxClassRoomCount, lectureCount;

    // 강의 정보 배열
    public static Lecture[] lectures;

    // 강의실 정보 우선순위 큐
    public static PriorityQueue<Lecture> queue;

    // 초기화 메서드
    public static void initialize() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 강의 개수 입력
        lectureCount = Integer.parseInt(br.readLine());

        // 강의 정보 배열 생성
        lectures = new Lecture[lectureCount];

        // 강의 정보 입력
        for(int lectureIndex=0; lectureIndex<lectureCount; lectureIndex++) {
            st = new StringTokenizer(br.readLine());
            int lectureID = Integer.parseInt(st.nextToken());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());
            lectures[lectureIndex] = new Lecture(lectureID,startTime,endTime);
        }
    }

    // 강의실 수업 진행 여부 확인 메서드
    public static boolean isAnyLectureInProgress() {
        return !queue.isEmpty();
    }

    // 기존 강의실 사용 가능 여부 확인 메서드
    public static boolean canUseExistingClassroom(int lectureStartTime) {
        return queue.peek().endTime <= lectureStartTime;
    }

    // 기존 강의실 사용 가능 여부 확인 메서드
    public static boolean canTakeClass(int lectureStartTime) {

        // 수업 중인 강의실 존재 여부 확인
        return isAnyLectureInProgress() && canUseExistingClassroom(lectureStartTime);
    }

    // 강의실 배정 메서드
    public static void solve() {

        // 강의실 정보 우선순위 큐 생성
        queue = new PriorityQueue<>((a,b) -> a.endTime - b.endTime);

        // 강의 정보 순회
        for(int lectureIndex=0; lectureIndex<lectures.length; lectureIndex++) {

            // 기존 강의실 사용 가능 여부 확인
            while(canTakeClass(lectures[lectureIndex].startTime)) {
                queue.poll();
            }

            // 수업 추가
            queue.offer(lectures[lectureIndex]);

            // 강의실 개수 갱신
            maxClassRoomCount = Math.max(maxClassRoomCount,queue.size());
        }
    }

    public static void main(String[] args) throws IOException {

        // 초기화
        initialize();

        // 강의 정렬 (강의 시작 시간 기준)
        Arrays.sort(lectures, (a,b) -> a.startTime - b.startTime);

        // 강의실 배정하기
        maxClassRoomCount = 0;
        solve();

        // 결과 출력
        System.out.println(maxClassRoomCount);
    }
}