import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // N 입력
            int N = Integer.parseInt(br.readLine());

            // 삼각형 정보 저장 배열
            int arr[][] = new int[N][N];

            // 초기 값
            arr[0][0] = 1;

            // 삼각형 정보 입력
            for(int i=1; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(j==0 || j==i)
                        arr[i][j] = 1;
                    else {
                        arr[i][j] = arr[i-1][j-1]+arr[i-1][j];
                    }
                }
            }

            // 결과 저장
            sb.append("#").append(caseIdx+1).append("\n");
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(arr[i][j]==0) continue;
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}