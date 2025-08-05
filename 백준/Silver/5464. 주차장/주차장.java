import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 공간 수, 자동차 수 입력
        st = new StringTokenizer(br.readLine());
        int areaCount = Integer.parseInt(st.nextToken());
        int carCount = Integer.parseInt(st.nextToken());

        // 주차 공간 가격 배열 생성
        int[] parkingAreaPrice = new int[areaCount+1];

        // 자동차 배열 생성
        int[][] cars = new int[carCount+1][2];

        // 주차 공간 우선 순위 큐 생성
        PriorityQueue<Integer> parkingArea = new PriorityQueue<>();
        for(int index=1; index<=areaCount; index++) {
            parkingArea.offer(index);
        }

        // 자동차 대기 큐 생성
        Queue<Integer> carWaitingQueue = new LinkedList<>();

        // 각 주차 공간 가격 입력
        for(int index=1; index<=areaCount; index++) {
            parkingAreaPrice[index] = Integer.parseInt(br.readLine());
        }

        // 각 자동차 무게 입력
        for(int index=1; index<=carCount; index++) {
            cars[index][0] = Integer.parseInt(br.readLine());
        }

        // 차량 확인
        int answer = 0;
        int order = carCount * 2;
        for(int index=0; index<order; index++) {

            // 차량 입력
            int carNum = Integer.parseInt(br.readLine());

            // 주차인 경우
            if(carNum > 0) {

                // 주차 공간 확인 - 주차 공간이 없는 경우
                if(parkingArea.isEmpty()) {
                    carWaitingQueue.offer(carNum);
                }

                // 주차 공간 확인 - 주차 공간이 있는 경우
                else {

                    // 공간 확인 - 해당 공간에 차 주차 - 요금 계산
                    int area = parkingArea.poll();
                    cars[carNum][1] = area;
                    answer += parkingAreaPrice[area] * cars[carNum][0];
                }
            }

            // 출차인 경우
            else {

                // 차량 확인
                carNum *= -1;

                // 대기 차가 없는 경우 - 빈 공간 저장
                if(carWaitingQueue.isEmpty()) {
                   parkingArea.offer(cars[carNum][1]);
                }

                // 대기 차가 있는 경우 - 대기 차 확인 - 기존 차 공간 대기 차 할당 - 요금 계산
                else {
                    int car = carWaitingQueue.poll();
                    cars[car][1] = cars[carNum][1];
                    answer += parkingAreaPrice[cars[carNum][1]] * cars[car][0];
                }
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}