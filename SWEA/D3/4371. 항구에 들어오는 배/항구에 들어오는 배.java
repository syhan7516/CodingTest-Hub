import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 배가 들어오는 날의 수 입력
            int dayNum = Integer.parseInt(br.readLine());

            // 좋은 날 입력
            ArrayList<Integer> days = new ArrayList<>();
            for(int d=0; d<dayNum; d++)
                days.add(Integer.parseInt(br.readLine()));

            // 배 확인
            int count = 0;
            HashSet daySet = new HashSet();
            daySet.add(1);

            for(int d=1; d<dayNum; d++) {

                // 다 확인한 경우
                if(daySet.containsAll(days))
                    break;

                // 이미 좋은 날로 확인된 경우
                if(daySet.contains(days.get(d)))
                    continue;

                // 아닌 경우
                else {
                    count += 1;
                    int start = days.get(d);
                    int end = days.get(days.size()-1);
                    int period = start-1;
                    for(int n=start; n<=end; n+=period) {
                        daySet.add(n);
                    }
                }
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+count+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}