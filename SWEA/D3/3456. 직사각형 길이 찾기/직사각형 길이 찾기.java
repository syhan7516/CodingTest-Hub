import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 변수 길이 저장 배열
            boolean edgeLen[] = new boolean[101];

            // 직사각형 세 변의 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int e=0; e<3; e++) {
                int edge = Integer.parseInt(st.nextToken());

                // 이미 입력받은 경우
                if(edgeLen[edge])
                    edgeLen[edge] = false;
                // 아닌 경우
                else
                    edgeLen[edge] = true;
            }

            // 남은 변의 길이 확인
            sb.append("#"+(caseIdx+1)+" ");
            for(int l=1; l<=100; l++) {
                if(edgeLen[l]) {
                    sb.append(l+"\n");
                    break;
                }
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}