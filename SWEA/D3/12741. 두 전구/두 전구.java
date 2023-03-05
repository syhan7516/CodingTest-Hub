import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(st.nextToken());
        // 케이스 수만큼 반복
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 전구 배열
            int bulb[] = new int[101];
            Arrays.fill(bulb,0);
 
            // A전구 정보 &  B전구 정보 입력
            st = new StringTokenizer(br.readLine());
            int startA = Integer.parseInt(st.nextToken());
            int endA = Integer.parseInt(st.nextToken());
            int startB = Integer.parseInt(st.nextToken());
            int endB = Integer.parseInt(st.nextToken());
 
            // 전구 켜기
            for(int a=startA; a<=endA; a++)
                bulb[a] += 1;
            for(int b=startB; b<=endB; b++)
                bulb[b] += 1;
 
            // 전구 확인
            int time = 0;
            for(int check=0; check<101; check++) {
                if(bulb[check]==2)
                    time += 1;
            }
 
            // 결과 출력
            time -= 1;
            if(time<0)
                time = 0;
            System.out.println("#"+(caseIdx+1)+" "+(time));
        }
    }
}