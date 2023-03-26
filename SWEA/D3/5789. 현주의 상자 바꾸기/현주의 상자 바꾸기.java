import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 숫자의 개수, 회 입력
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());


            // 상자 번호 매기기
            int box[] = new int[N+1];
            for(int b=0; b<Q; b++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                for(int n=start; n<=end; n++) {
                    box[n] = b+1;
                }
            }

            // 결과 출력
            System.out.print("#"+(caseIdx+1)+" ");
            for(int idx=1; idx<box.length; idx++)
                System.out.print(box[idx]+" ");
            System.out.println();
        }
    }
}