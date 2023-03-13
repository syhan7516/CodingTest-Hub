import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());
        // 테스트 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 단어 입력
            String vocaLotters[] = br.readLine().toUpperCase().split(" ");

            // 단어 합치기
            String result = "";
            for(int idx=0; idx<vocaLotters.length; idx++) {
                result += vocaLotters[idx].charAt(0);
            }

            // 결과 출력
            System.out.println("#"+(caseIdx+1)+" "+result);
        }
    }
}
