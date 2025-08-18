import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 범위 클래스
class Range {
    int start;
    int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=0; caseNum<caseCount; caseNum++) {

            // 최종 이동 횟수
            int totalMoveCount = 0;

            // 우선 순위 큐 생성 (끝 지점 기준으로 정렬)
            PriorityQueue<Range> queue = new PriorityQueue<Range>(
                    (a, b) -> a.end - b.end
            );

            // 이동 수 입력
            int moveCount = Integer.parseInt(br.readLine());

            // 범위 저장 배열 생성
            Range[] ranges = new Range[moveCount];

            // 이동 정보 입력
            for(int move=0; move<moveCount; move++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                // 방 번호 → 복도 번호 변환
                start = (start - 1) / 2;
                end = (end - 1) / 2;

                ranges[move] = new Range(Math.min(start, end), Math.max(start, end));
            }

            // 정렬 (시작점 우선, 같으면 길이 기준)
            Arrays.sort(ranges, (a, b) -> {
                if(a.start == b.start) {
                    return (a.end - a.start) - (b.end - b.start);
                }
                return a.start - b.start;
            });

            // 확인
            for(int range=0; range<ranges.length; range++) {
                Range currentRange = ranges[range];

                // 현재 작업의 시작점보다 작은 구간 제거
                while(!queue.isEmpty() && currentRange.start > queue.peek().end) {
                    queue.poll();
                }

                // 현재 작업 추가
                queue.offer(currentRange);

                // 동시에 겹친 최대 작업 수 업데이트
                totalMoveCount = Math.max(totalMoveCount, queue.size());
            }

            // 결과 저장
            sb.append((totalMoveCount * 10)).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}