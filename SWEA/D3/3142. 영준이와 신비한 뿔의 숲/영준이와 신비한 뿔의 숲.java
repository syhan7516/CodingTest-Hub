import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 뿔의 수, 동물 수 입력
            st = new StringTokenizer(br.readLine());
            int hornCnt = Integer.parseInt(st.nextToken());
            int animalCnt = Integer.parseInt(st.nextToken());

            // 각 동물의 수 구하기
            int unicon  = animalCnt*2 - hornCnt;
            int twin = animalCnt - unicon;

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+unicon+" "+twin+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}