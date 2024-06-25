import java.util.*;

class Solution {
    
    // 트럭 수
    public static int truckCnt;

    // 다리 정보 큐
    public static ArrayList<Integer> bridge;
    
    // 다리 건너기 메서드
    static int solve(int time,int bridgeLen,int bridgeWeight,int []weights) {
        
        // 현재 대기 중인 트럭, 현재 트럭 수, 다리 무게
        int idx = 0;
        int curCar = 0;
        int curWeight = 0;

        while(true) {

            // 시간 갱신
            time++;

            // 트럭 이동하기
            Collections.rotate(bridge,1);

            // 트럭이 끝에 도달한 경우
            if(bridge.get(bridgeLen)!=0) {
                curWeight -= bridge.get(bridgeLen);
                curCar--;
                bridge.set(bridgeLen,0);
            }

            // 다리 위 확인하기
            if(curCar+1<=bridgeLen && curWeight+weights[idx]<=bridgeWeight) {
                bridge.set(0,weights[idx]);
                curWeight += weights[idx];
                curCar++;
                idx++;
            }

            // 종료 조건
            if(idx==truckCnt) {
                time += bridgeLen;
                return time;
            }
        }
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        // 결과
        int answer = 0;
        
        // 트럭 수 입력
        truckCnt = truck_weights.length;
        
        // 다리 정보 리스트 생성
        bridge = new ArrayList<>();
        for(int i=0; i<=bridge_length; i++)
            bridge.add(0);
        
        // 다리 건너기
        answer = solve(0,bridge_length,weight,truck_weights);
    
        return answer;    
    }
}