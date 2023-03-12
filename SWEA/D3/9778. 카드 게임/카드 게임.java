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
            // 카드 덱
            int dec[] = {0,0,4,4,4,4,4,4,4,4,16,4};

            // 현재 소유한 카드 입력
            int cnt = Integer.parseInt(br.readLine());
            int cardSum = 0;
            for(int idx=0; idx<cnt; idx++) {
                String cardNum = br.readLine();
                int number = Integer.parseInt(cardNum);
                dec[number] -= 1;
                cardSum += number;
            }

            // 카드 계산
            int up = 0;
            int down = 0;
            for(int card=2; card<=11; card++) {
                if((cardSum+card)>21)
                    up += dec[card];
                else
                    down += dec[card];
            }

            // 결과 출력
            System.out.print("#"+(caseIdx+1)+" ");
            if(up > down)
                System.out.println("STOP");
            else
                System.out.println("GAZUA");
        }
    }
}