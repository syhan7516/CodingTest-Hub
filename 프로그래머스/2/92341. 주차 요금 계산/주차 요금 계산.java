import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
    
        StringTokenizer st;
        
        HashSet<String> set = new HashSet<>();

        // 출차 여부 확인 해시
        HashMap<String,Integer> in = new HashMap<>();

        // 누적 시간 저장 해시
        HashMap<String,Integer> sum = new HashMap<>();

        // 기록 확인
        for(int i=0; i<records.length; i++) {
        
            st = new StringTokenizer(records[i]);

            // 기록 입력
            String time[] = st.nextToken().split(":");
            String car = st.nextToken();
            set.add(car);
            st.nextToken();

            // 기록 변환
            int m = Integer.parseInt(time[0])*60;
            m += Integer.parseInt(time[1]);

            // 출입 여부 확인
            if(in.containsKey(car)) {
                int t = m-in.get(car);
                sum.put(car,sum.getOrDefault(car,0)+t);
                in.remove(car);
            }

            else {

                // 기록 저장
                in.put(car,m);
            }
        }

        // 차 정렬
        String arr[] = new String[set.size()];
        int idx = 0;
        
        for(String data: set) {
            arr[idx] = data;
            idx++;
        }
        
        Arrays.sort(arr);

        // 결과
        int[] answer = new int[arr.length];

        // 요금 계산
        for(int i=0; i<arr.length; i++) {

            // 아직 주차되어있는 경우
            if(in.containsKey(arr[i])) {
                int t = (23*60)+59-in.get(arr[i]);
                sum.put(arr[i],sum.getOrDefault(arr[i],0)+t);
            }
            
            // 이용 시간이 기본 요금일 경우
            if(sum.get(arr[i])<=fees[0])
                answer[i] = fees[1];
                
            // 이용 시간이 기본 요금을 넘은 경우
            else {
                answer[i] = fees[1]+(int)Math.ceil((double)(sum.get(arr[i])-fees[0])/fees[2])*fees[3];
            }
        }
        
        // 결과 반환
        return answer;
    }
}