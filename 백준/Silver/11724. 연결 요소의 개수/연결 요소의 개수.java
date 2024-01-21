import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 정점의 개수, 간선의 개수, 연결 요소 개수
    public static int vCnt, eCnt, ccCnt;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> list;

    // 방문 여부 배열
    public static boolean visited[];

    // 연결 요소 찾기 메서드
    static void solve(int node) {

        for(int i=0; i<list.get(node).size(); i++) {

            // 연결된 요소가 미방문 정점인 경우
            if(!visited[list.get(node).get(i)]) {
                visited[list.get(node).get(i)] = true;
                solve(list.get(node).get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점, 간선 개수 입력
        st = new StringTokenizer(br.readLine());
        vCnt = Integer.parseInt(st.nextToken());
        eCnt = Integer.parseInt(st.nextToken());

        // 연결 정보 리스트 생성
        list = new ArrayList<>();
        for(int i=0; i<=vCnt; i++)
            list.add(new ArrayList<>());

        // 연결 정보 입력
        for(int i=0; i<eCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }

        // 연결 요소 찾기
        ccCnt = 0;
        visited = new boolean[vCnt+1];
        for(int i=1; i<=vCnt; i++) {

            // 방문한 정점이 아닌 경우
            if(!visited[i]) {
                visited[i] = true;
                solve(i);
                ccCnt++;
            }
        }

        // 결과 출력
        System.out.println(ccCnt);
    }
}