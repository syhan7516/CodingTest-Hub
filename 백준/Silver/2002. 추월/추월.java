import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 차 개수 입력
        int carCount = Integer.parseInt(br.readLine());

        // 차 순서 저장 배열 생성
        String[] carOrders = new String[carCount];

        // 차 정보 해시 맵 생성
        HashMap<String, Integer> cars = new HashMap<>();

        // 진입 차 순서 입력
        for(int index=0; index<carCount; index++) {
            String car = br.readLine();
            carOrders[index] = car;
            cars.put(car, index);
        }

        // 나가는 차 순서 입력
        int answer = 0;
        int order = 0;
        for(int index=0; index<carCount; index++) {
            String car = br.readLine();

            // 이미 지나간 차 처리
            while(!cars.containsKey(carOrders[order])) order++;

            // 순서가 다른 경우
            if(order != cars.get(car)) {
                answer++;
                cars.remove(car);
            }

            else order++;
        }

        // 결과 출력
        System.out.println(answer);
    }
}