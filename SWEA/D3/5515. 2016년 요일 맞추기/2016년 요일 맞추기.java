import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 각 달의 일 정보 배열
    public static int daysOfMonth[] = {0,31,29,31,30,31,30,31,31,30,31,30,31};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 달과 일 입력
            st = new StringTokenizer(br.readLine());
            int month = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());

            // 요일 계산
            int totalDay = 0;
            while(true) {

                // 종료 조건
                if(month==1)
                    break;

                // 해당 달의 일 수 더하기
                totalDay += daysOfMonth[month-1];

                // 달 감소
                month--;
            }

            // 나머지 일 수 구하기
            totalDay += day;

            // 요일 구하기
            int result = (totalDay+3)%7;

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}