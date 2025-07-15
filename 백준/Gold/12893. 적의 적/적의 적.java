import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 결과, 사람 수, 관계 수
    public static int answer, saramCount, relationCount;

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 방문 여부 배열
    public static int[] visited;

    // 관계 확인 메서드
    public static void solve(int saram, int isFriend) {

        // 관계 순회
        for(int index=0; index<relations.get(saram).size(); index++) {
            
            // 적 확인
            int someone = relations.get(saram).get(index);

            // 방문하지 않은 경우
            if(visited[someone]==0) {
                visited[someone] = isFriend;
                solve(someone,isFriend*-1);
            }

            // 방문한 경우
            else {
                
                // 서로 적이지만 친구인 경우
                if(visited[saram] == visited[someone]) {
                    answer = 0;
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 사람 수, 관계 수 입력
        st = new StringTokenizer(br.readLine());
        saramCount = Integer.parseInt(st.nextToken());
        relationCount = Integer.parseInt(st.nextToken());

        // 관계 정보 리스트 생성 및 초기화
        relations = new ArrayList<>();
        for(int saram=0; saram<=saramCount; saram++) {
            relations.add(new ArrayList<>());
        }

        // 관계 정보 입력
        for(int relation=0; relation<relationCount; relation++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            relations.get(a).add(b);
            relations.get(b).add(a);
        }

        // 방문 여부 배열 생성 초기화
        visited = new int[saramCount+1];

        // 관계 확인
        answer = 1;
        for(int saram=1; saram<=saramCount; saram++) {
            
            // 방문하지 않은 경우
            if(visited[saram] == 0) {
                visited[saram] = 1;
                solve(saram,-1);
                if(answer == 0) break;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}