import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 우울 정도 클래스
class Bad implements Comparable<Bad> {
    int startDay;
    int count;

    public Bad(int startDay, int count) {
        this.startDay = startDay;
        this.count = count;
    }

    @Override
    public int compareTo(Bad other) {
        return other.count - this.count;
    }
}

public class Main {

    // 결과, 일 수
    public static int answer, dayCount;

    // 우울 기간, 우울 최대 기간, 우울 시작 일
    public static int badCount, maxBadCount, badStartDay;

    // 기분 배열
    public static int[] degree;

    // 꽃 선물 여부 배열
    public static boolean[] visited;

    // 우울 정도 우선 순위 큐
    public static PriorityQueue<Bad> queue;

    // 우울 기간 확인 메서드
    public static void checkBadTerm() {
        // 최장 우울 기간 갱신
        maxBadCount = Math.max(maxBadCount, badCount);

        // 범위 설정
        int end = badStartDay - badCount * 2;
        for(int badDay=badStartDay-1; badDay>=end; badDay--) {

            // 범위를 벗어난 경우
            if(badDay < 1) break;

            // 꽃을 주지 않은 날인 경우
            if(!visited[badDay]) {
                visited[badDay] = true;
                answer++;
            }
        }

        queue.offer(new Bad(badStartDay, badCount));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 일 수 입력
        dayCount = Integer.parseInt(br.readLine());

        // 기분 배열 생성
        degree = new int[dayCount+1];

        // 꽃 선물 여부 배열 생성
        visited = new boolean[dayCount+1];

        // 우울 정도 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 기분 입력
        badCount = 0;
        maxBadCount = 0;
        badStartDay = 0;
        st = new StringTokenizer(br.readLine());
        for(int day=1; day<=dayCount; day++) {
            degree[day] = Integer.parseInt(st.nextToken());

            // 우울한 날인 경우
            if(degree[day] < 0) {
                badCount++;

                // 우울한 날의 시작인 경우
                if(degree[day-1] >= 0) {
                    badStartDay = day;
                    badCount = 1;
                }
            }

            // 좋은 날인 경우
            else {

                // 전날 우울했던 경우
                if(degree[day-1] < 0) {

                    // 우울 기간 확인
                    checkBadTerm();
                }
            }
        }

        if(degree[dayCount] < 0) {
            checkBadTerm();
        }

        // 가장 우울했던 날 확인
        int maxAdditionalCount = 0;
        while(!queue.isEmpty() && queue.peek().count == maxBadCount) {
            Bad bad = queue.poll();

            // 추가로 준 꽃 확인
            int additionalCount = 0;
            int end = bad.startDay - bad.count * 3;
            for(int badDay=bad.startDay-1; badDay>=end; badDay--) {
                if(badDay < 1) break;
                if(!visited[badDay]) {
                    additionalCount++;
                }
            }


            // 추가로 준 최대 꽃 갱신
            maxAdditionalCount = Math.max(maxAdditionalCount, additionalCount);
        }

        // 결과 출력
        System.out.println(answer+maxAdditionalCount);
    }
}