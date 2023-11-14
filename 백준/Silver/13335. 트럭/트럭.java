import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    // 다리 길이, 다리 하중, 트럭 수, 시간
    public static int bridgeLen, bridgeWeight, truckCnt, time;

    // 다리 정보 큐
    public static ArrayList<Integer> bridge;

    // 트럭 무게 배열, 트럭 위치 배열
    public static int [] weights;

    // 다리 건너기 메서드
    static void solve() {

        // 현재 대기 중인 트럭, 현재 트럭 수, 다리 무게
        int idx = 0;
        int curCar = 0;
        int curWeight = 0;

        while(true) {

            // 시간 갱신
            time++;

            // 트럭 이동
            Collections.rotate(bridge,1);

            // 트럭이 끝에 도달한 경우
            if(bridge.get(bridgeLen)!=0) {
                curWeight -= bridge.get(bridgeLen);
                curCar--;
                bridge.set(bridgeLen,0);
            }

            // 다리 위 확인
            if(curCar+1<=bridgeLen && curWeight+weights[idx]<=bridgeWeight) {
                bridge.set(0,weights[idx]);
                curWeight += weights[idx];
                curCar++;
                idx++;
            }

            // 종료 조건
            if(idx==truckCnt) {
                time += bridgeLen;
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 트럭 수, 다리 하중, 다리 길이 입력
        st = new StringTokenizer(br.readLine());
        truckCnt = Integer.parseInt(st.nextToken());
        bridgeLen = Integer.parseInt(st.nextToken());
        bridgeWeight = Integer.parseInt(st.nextToken());

        // 다리 정보 리스트 생성
        bridge = new ArrayList<>();
        for(int i=0; i<=bridgeLen; i++)
            bridge.add(0);
        
        // 트럭 무게 배열 생성
        weights = new int[truckCnt];

        // 트럭 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<truckCnt; i++)
            weights[i] = Integer.parseInt(st.nextToken());

        // 다리 건너기
        time = 0;
        solve();

        // 결과 출력
        System.out.println(time);
    }
}