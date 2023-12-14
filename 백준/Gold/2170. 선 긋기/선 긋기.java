import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 선 클래스
class Line implements Comparable<Line> {
    int start;
    int end;

    public Line(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int compareTo(Line other) {
        if(this.start<other.start)
            return -1;
        else if(this.start==other.start) {
            if(this.end<other.end)
                return -1;
        }

        return 1;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 선 개수 입력
        int lineCnt = Integer.parseInt(br.readLine());

        // 선 저장 우선 순위 큐 생성
        PriorityQueue<Line> priQ = new PriorityQueue<>();
        
        // 선 정보 입력
        for(int i=0; i<lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            priQ.offer(new Line(start,end));
        }
        
        // 선 확인
        long answer = 0;
        Line current = priQ.poll();
        int start = current.start;
        int end = current.end;
        
        while(!priQ.isEmpty()) {
            
            // 확인 할 선
            current = priQ.poll();

            // 끝이 속하는 경우
            if(end>=current.end) continue;

            // 끝이 넘어서는 경우
            else {

                // 시작이 속하거나 동일한 경우
                if(end>=current.start) {
                    end = current.end;
                }

                // 시작이 끝을 넘어선 경우
                else {
                    answer += (end-start);
                    start = current.start;
                    end = current.end;
                }
            }
        }

        // 나머지 선 길이 합치기
        answer += (end-start);

        // 결과 출력
        System.out.println(answer);
    }
}