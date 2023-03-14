import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 테스트 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 당첨금
            int money = 0;

            // 당첨 번호 수, 복권 수 입력
            st = new StringTokenizer(br.readLine());
            int winNumCnt = Integer.parseInt(st.nextToken());
            int buyNumCnt = Integer.parseInt(st.nextToken());

            // 당첨 번호, 당첨금 입력
            String winNums[][] = new String[winNumCnt][2];
            for(int idx=0; idx<winNumCnt; idx++) {
                st = new StringTokenizer(br.readLine());
                winNums[idx][0] = st.nextToken();
                winNums[idx][1] = st.nextToken();
            }

            // 복권 번호 입력
            String buyNums[] = new String[buyNumCnt];
            for(int idx=0; idx<buyNumCnt; idx++) {
                st = new StringTokenizer(br.readLine());
                buyNums[idx] = st.nextToken();
            }

            // 복권 확인
            for(int win=0; win<winNumCnt; win++) {
                for(int buy=0; buy<buyNumCnt; buy++) {
                    // 당첨 여부
                    boolean flag = true;
                    // 한자리씩 확인
                    for(int p=0; p<8; p++) {
                        char n = winNums[win][0].charAt(p);
                        // 자리가 *인 경우
                        if(n=='*')
                            continue;
                        // 숫자인 경우
                        else
                            // 숫자가 다른 경우
                            if(n!=buyNums[buy].charAt(p)) {
                                flag = false;
                                break;
                            }
                    }
                    // 복권이 맞을 경우
                    if(flag==true)
                        money += Integer.parseInt(winNums[win][1]);
                }
            }

            // 결과 확인
            System.out.println("#"+(caseIdx+1)+" "+money);
        }
    }
}
