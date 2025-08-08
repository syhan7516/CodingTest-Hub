import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 맥주 클래스
class Beer {
    int preferScore;
    int alcohol;

    public Beer(int preferScore, int alcohol) {
        this.preferScore = preferScore;
        this.alcohol = alcohol;
    }
}

public class Main {

    // 결과
    public static long answer;

    // 행사 일 수, 선호도, 맥주 개수, 선택된 맥주 선호도 합
    public static int eventDays, targetPreferScore, beerTypeCount, totalPreferScore;

    // 알코올 낮은 순 우선 순위 큐
    public static PriorityQueue<Beer> alcoholAscendingOrderQueue;

    // 선호 낮은 순 우선 순위 큐
    public static PriorityQueue<Beer> preferAscendingOrderQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 행사 일 수, 선호도, 맥주 개수 입력
        st = new StringTokenizer(br.readLine());
        eventDays = Integer.parseInt(st.nextToken());
        targetPreferScore = Integer.parseInt(st.nextToken());
        beerTypeCount = Integer.parseInt(st.nextToken());

        // 우선 순위 큐 생성
        alcoholAscendingOrderQueue = new PriorityQueue<>((a, b) -> a.alcohol - b.alcohol);
        preferAscendingOrderQueue = new PriorityQueue<>((a, b) -> a.preferScore - b.preferScore);

        // 맥주 정보 입력

        for(int index=0; index<beerTypeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int preferScore = Integer.parseInt(st.nextToken());
            int alcohol = Integer.parseInt(st.nextToken());
            alcoholAscendingOrderQueue.offer(new Beer(preferScore, alcohol));
        }

        // 맥주 확인
        answer = Long.MAX_VALUE;
        totalPreferScore = 0;
        while(!alcoholAscendingOrderQueue.isEmpty()) {
            Beer beer = alcoholAscendingOrderQueue.poll();
            totalPreferScore += beer.preferScore;
            preferAscendingOrderQueue.offer(beer);

            // 맥주 개수가 행사 일 수와 동일한 경우
            if(preferAscendingOrderQueue.size() == eventDays) {

                // 목표 선호도 이상인 경우 - 알코올 확인
                if(totalPreferScore >= targetPreferScore) {
                    answer = Math.min(answer, beer.alcohol);
                    break;
                }

                // 선호도 낮은 맥주 하나 제거
                totalPreferScore -= preferAscendingOrderQueue.poll().preferScore;
            }
        }

        // 결과 출력
        System.out.println(answer == Long.MAX_VALUE ? -1 : answer);
    }
}