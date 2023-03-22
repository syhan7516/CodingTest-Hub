import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 결과
            int result = 0;

            // 거리 입력
            int d = Integer.parseInt(br.readLine());
            // 거리 변환
            double distance = d * 0.001;

            // 거리 점수 측정
            if(distance<0.1)
                result = 0;
            else if(distance>=0.1 && distance<1)
                result = 1;
            else if(distance>=1 && distance<10)
                result = 2;
            else if(distance>=10 && distance<100)
                result = 3;
            else if(distance>=100 && distance<1000)
                result = 4;
            else
                result = 5;

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}