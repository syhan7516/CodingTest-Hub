import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 옷 종류 개수 입력
            int kindCnt = Integer.parseInt(br.readLine());

            // 해시 생성
            HashMap<String,Integer> cloth = new HashMap<>();

            // 옷 종류 입력
            for(int k=0; k<kindCnt; k++) {

                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String kinds = st.nextToken();

                // 이미 옷 종류가 존재할 경우
                if(cloth.containsKey(kinds)) {
                    cloth.put(kinds, cloth.get(kinds)+1);
                }
                // 아닌 경우
                else {
                    cloth.put(kinds, 1);
                }
            }

            // 옷 확인
            int result = 1;
            for(int element: cloth.values()) {
                result *= element+1;
            }

            // 결과 출력
            System.out.println(result-1);
        }
    }
}