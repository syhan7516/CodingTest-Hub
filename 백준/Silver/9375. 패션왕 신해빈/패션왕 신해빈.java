import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 의상 수 입력
            int dressCnt = Integer.parseInt(br.readLine());

            // 종류별 개수 해시 생성
            HashMap<String,Integer> map = new HashMap<>();

            // 종류 해시 셋 생성
            HashSet<String> set = new HashSet<>();

            // 의상 정보 입력
            for(int i=0; i<dressCnt; i++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String kind = st.nextToken();

                // 종류가 이미 존재하는 경우
                if(set.contains(kind)) {
                    map.put(kind, map.get(kind)+1);
                }

                // 종류가 없는 경우
                else {
                    set.add(kind);
                    map.put(kind,1);
                }
            }

            // 조합 확인
            int combination = 1;
            for(String dress : set) {
                combination = combination*(map.get(dress)+1);
            }

            // 결과 저장
            sb.append(combination-1).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}