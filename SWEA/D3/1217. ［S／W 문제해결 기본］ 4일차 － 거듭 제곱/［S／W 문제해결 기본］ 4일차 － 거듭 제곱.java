import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    // 거듭 제곱 함수
    static int recursive(int firNum, int secNum) {

        // 종료 조건
        if(secNum==0)
            return 1;

        // 곱하기
        return firNum * recursive(firNum,secNum-1);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int count = 1;

        while(true) {
            // 종료 조건
            if(count==11)
                break;

            // 테스트 케이스 숫자 입력
            int caseNum = Integer.parseInt(br.readLine());

            // 숫자 두 개 입력
            st = new StringTokenizer(br.readLine());
            int firNum = Integer.parseInt(st.nextToken());
            int secNum = Integer.parseInt(st.nextToken());

            // 거듭 제곱 구하기
            int result = recursive(firNum,secNum);

            // 결과 저장
            sb.append("#"+count+" "+result+"\n");

            count++;
        }


        // 결과 출력
        System.out.println(sb.toString());
    }
}