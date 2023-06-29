import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    // 사람 수, 관계 수, 결과
    public static int humanCnt, relationCnt, result;
    // 방문 배열
    public static boolean visited[];
    // 관계 정보 리스트
    public static ArrayList<ArrayList<Integer>> relation;

    // 관계 확인 함수
    static void solve(int node) {

        // 연결된 관계 확인
        for(int n=0; n<relation.get(node).size(); n++) {

            // 확인 대상
            int compareNode = relation.get(node).get(n);

            // 미방문한 경우
            if(!visited[compareNode]) {
                visited[compareNode] = true;
                solve(compareNode);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테이스 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 사람 수, 관계 수 입력
            st = new StringTokenizer(br.readLine());
            humanCnt = Integer.parseInt(st.nextToken());
            relationCnt = Integer.parseInt(st.nextToken());

            // 관계 리스트 만들기
            relation = new ArrayList<>();
            for(int r=0; r<=humanCnt; r++)
                relation.add(new ArrayList<>());

            // 관계 정보 입력
            for(int r=0; r<relationCnt; r++) {
                st = new StringTokenizer(br.readLine());
                int firRel = Integer.parseInt(st.nextToken());
                int secRel = Integer.parseInt(st.nextToken());
                relation.get(firRel).add(secRel);
                relation.get(secRel).add(firRel);
            }

            // 관계 확인
            result = 0;
            visited = new boolean[humanCnt+1];
            for(int n=1; n<=humanCnt; n++) {

                // 미방문인 경우
                if(!visited[n]) {
                    visited[n] = true;
                    solve(n);
                    result++;
                }
            }

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}