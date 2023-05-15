import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Line implements Comparable<Line> {
    private long start;
    private long end;

    public Line(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public long getStart() {
        return start;
    }

    public long getEnd() {
        return end;
    }

    public int compareTo(Line other) {
        if(this.start<other.start)
            return -1;
        return 1;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 선 개수 입력
        int lineCnt = Integer.parseInt(br.readLine());

        // 선 정보 입력
        PriorityQueue<Line> lines = new PriorityQueue<>();
        for(int l=0; l<lineCnt; l++) {
            st = new StringTokenizer(br.readLine());
            long start = Integer.parseInt(st.nextToken());
            long end = Integer.parseInt(st.nextToken());
            lines.add(new Line(start,end));
        }

        // 선 확인
        Line curLine = lines.poll();
        long s = curLine.getStart();
        long e = curLine.getEnd();
        long result = e-s;

        while(!lines.isEmpty()) {

            // 선 정보 꺼내기
            curLine = lines.poll();
            long curStart = curLine.getStart();
            long curEnd = curLine.getEnd();

            // 마지막 점 안에 선이 시작점이 들어올 경우
            if(e>=curStart) {

                // 완전 겹치는 선인 경우
                if(curEnd<=e)
                    continue;

                // 완전 겹치지는 않은 경우
                result += curEnd-e;
                e = curEnd;
            }

            // 마지막 점 안에 선이 안들어올 경우
            else {
                result += curEnd-curStart;
                s = curStart;
                e = curEnd;
            }
        }

        // 결과 확인
        System.out.println(result);
    }
}