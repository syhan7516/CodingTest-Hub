import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 강의 클래스
class Lecture implements Comparable <Lecture> {
    int start;
    int end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    // 비교 기준
    public int compareTo(Lecture other) {
        if(this.start == other.start)
            return this.end - other.end;
        else
            return this.start - other.start;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 강의 개수 입력
        int lectureCnt = Integer.parseInt(br.readLine());

        // 강의 정보 리스트 생성
        ArrayList<Lecture> lectures = new ArrayList<>();

        // 강의 정보 입력
        for(int i=0; i<lectureCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures.add(new Lecture(start,end));
        }

        // 강의 정렬
        Collections.sort(lectures);

        // 강의실 배정 우선 순위 큐 생성
        PriorityQueue<Integer> priQ = new PriorityQueue<>();

        // 강의실 배정
        int exitTime = 0;

        for(Lecture lecture: lectures) {

            // 종료 시간
            exitTime = lecture.end;

            // 진행 중인 수업이 존재,
            // 종료 시간이 해당 수업 시작과 같거나 빠른 경우
            if(!priQ.isEmpty() && (priQ.peek() <= lecture.start))
                priQ.poll();

            // 강의실 배정
            priQ.offer(exitTime);
        }

        // 결과 출력
        System.out.println(priQ.size());
    }
}