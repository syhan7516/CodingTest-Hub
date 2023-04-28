import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 다리 건설 경우의 수
    public static int DP[][] = new int[31][31];
    
    // 다리 짓기 함수
    static int makeBrige(int n, int r) {
        
        // 이미 저장된 값일 경우
        if(DP[n][r]>0)
            return DP[n][r];

        // 개수와 결과 수가 같거나 0일 경우
        if (n == r || r == 0)
            return DP[n][r] = 1;

        // 다리 짓기
        return DP[n][r] = makeBrige(n-1,r-1)+makeBrige(n-1,r);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 테스트 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 사이트 수 입력
            st = new StringTokenizer(br.readLine());
            int firSite = Integer.parseInt(st.nextToken());
            int secSite = Integer.parseInt(st.nextToken());

            // 다리 짓기
            int result = makeBrige(secSite,firSite);
            
            // 결과 출력
            System.out.println(result);
        }
    }
}
