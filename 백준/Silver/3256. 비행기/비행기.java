import java.io.*;
import java.util.*;

public class Main {

    // 결과, 승객 수
    public static int answer, count;

    // 좌석 정보 배열
    public static int[] seats;

    // 비행기 좌석 배열
    public static int[] airplane = new int[1001];

    // 해시
    public static Map<Integer, Integer> map;

    // 빈 여부 확인 메서드
    public static boolean isEmpty() {
        for(int seat: airplane) {
            if(seat != -1) return false;
        }

        return true;
    }

    // 좌석 확인 메서드
    public static int iteratorSeats(String condition) {

        // 시간
        int time = 0;

        // 탐색 수행
        while(condition.equals("insert") ? airplane[0] != -1 : !isEmpty()) {

            // 비행기 좌석 확인
            for (int seatIndex=1000; seatIndex>0; seatIndex--) {

                // 짐을 싣는 중인 경우
                if(seatIndex == airplane[seatIndex]) {

                    // 시간 감소
                    map.put(seatIndex, map.getOrDefault(seatIndex, 0) - 1);

                    // 짐을 다 실은 경우
                    if(map.get(seatIndex) != null && map.get(seatIndex) == 0) {
                        map.remove(seatIndex);
                        airplane[seatIndex] = -1;
                    }
                }

                // 이동
                if(seatIndex<=airplane[seatIndex-1] && airplane[seatIndex]==-1) {
                    airplane[seatIndex] = airplane[seatIndex - 1];
                    airplane[seatIndex - 1] = -1;
                    if (seatIndex == airplane[seatIndex]) {
                        map.put(seatIndex, 5);
                    }
                }
            }

            time++;
        }

        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 승객 수 입력
        count = Integer.parseInt(br.readLine());

        // 좌석 정보 배열 생성
        seats = new int[count];

        // 좌석 정보 입력
        for(int index=0; index<count; index++) {
            seats[index] = Integer.parseInt(br.readLine().trim());
        }

        // 비행기 좌석 설정
        Arrays.fill(airplane, -1);

        // 해시 생성
        map = new HashMap<>();

        // 승객 확인
        answer = -1;
        for(int index=0; index<count; index++) {
            airplane[0] = seats[index];
            answer += iteratorSeats("insert");
        }

        // 모두 자리에 앉기
        answer += iteratorSeats("move");

        // 결과 출력
        System.out.println(answer);
    }
}