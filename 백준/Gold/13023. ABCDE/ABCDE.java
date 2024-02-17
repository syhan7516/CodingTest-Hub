import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 사람 수, 관계 수, 결과
    public static int saramCnt, relCnt, answer;

    // 친구 관계 확인 여부 배열
    public static boolean visited[];

    // 친구 관계 리스트
    public static ArrayList<ArrayList<Integer>> relation;

    // 관계 확인 메서드
    static void solve(int node, int cnt) {

        // 원하는 관계인 경우
        if(cnt==5) {
            answer = 1;
            return;
        }

        // 현재 확인 친구
        ArrayList<Integer> friends = relation.get(node);
        
        // 관계 확인
        for(int i=0; i<friends.size(); i++) {
            if(!visited[friends.get(i)]) {
                visited[friends.get(i)] = true;
                solve(friends.get(i),cnt+1);
                if(answer==1) return;
                visited[friends.get(i)] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 사람, 관계 수 입력
        st = new StringTokenizer(br.readLine());
        saramCnt = Integer.parseInt(st.nextToken());
        relCnt = Integer.parseInt(st.nextToken());

        // 관계 리스트 생성
        relation = new ArrayList<>();
        for(int i=0; i<saramCnt; i++)
            relation.add(new ArrayList<>());

        // 관계 정보 입력
        for(int i=0; i<relCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relation.get(from).add(to);
            relation.get(to).add(from);
        }

        // 관계 확인
        visited = new boolean[saramCnt];
        answer = 0;
        for(int i=0; i<saramCnt; i++) {
            visited[i] = true;
            solve(i,1);
            visited[i] = false;
        }

        // 결과 출력
        System.out.println(answer);
    }
}