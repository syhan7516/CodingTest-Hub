import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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

            // 단어장 만들기
            char alpha[][] = new char[5][15];
            for(int idx=0; idx<5; idx++) {
                Arrays.fill(alpha[idx],'.');
            }

            // 단어 입력
            for(int idx=0; idx<5; idx++) {
                String letter = br.readLine();
                for(int l=0; l<letter.length(); l++) {
                    alpha[idx][l] = letter.charAt(l);
                }
            }

            // 세로 읽기
            sb.append("#"+(caseIdx+1)+" ");
            for(int a=0; a<15; a++) {
                for(int b=0; b<5; b++) {
                    if(alpha[b][a]!='.')
                        sb.append(alpha[b][a]);
                }
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}