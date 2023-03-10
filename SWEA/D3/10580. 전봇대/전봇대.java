import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(st.nextToken());
        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 결과
            int count = 0;

            // 전선의 수 입력
            st = new StringTokenizer(br.readLine());
            int lineCnt = Integer.parseInt(st.nextToken());

            // 두 전봇대
            int A[] = new int[lineCnt];
            int B[] = new int[lineCnt];

            // 전선의 정보
            for(int idx=0; idx<lineCnt; idx++) {
                st = new StringTokenizer(br.readLine());
                int startLine = Integer.parseInt(st.nextToken());
                int endLine = Integer.parseInt(st.nextToken());
                A[idx] = startLine;
                B[idx] = endLine;
            }

            // 전선 확인
            for(int a=0; a<lineCnt-1; a++) {
                for(int b=a+1; b<lineCnt; b++) {
                    if((A[a] > A[b] && B[a] < B[b]) || (A[a] < A[b] && B[a] > B[b]))
                        count += 1;
                }
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+count);
        }
    }
}