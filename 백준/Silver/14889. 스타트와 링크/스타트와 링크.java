import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 사람 수, 결과, 한 팀의 멤버 수
    public static int saramCnt, answer, memberCnt;

    // 선택된 선수 정보 배열
    public static boolean visited[];

    // 능력치 배열
    public static int ability[][];

    // 팀 구성하기 메서드
    static void solve(int idx, int cnt) {

        // 팀이 다 구성된 경우
        if(cnt==memberCnt) {

            // 팀
            ArrayList<Integer> team1 = new ArrayList<>();
            ArrayList<Integer> team2 = new ArrayList<>();

            for(int i=0; i<saramCnt; i++) {
                if(visited[i]) team1.add(i);
                else team2.add(i);
            }

            int teamAbility1 = 0;
            int teamAbility2 = 0;

            for(int i=0; i<team1.size()-1; i++) {
                for(int j=i+1; j<team1.size(); j++) {
                    int a = team1.get(i);
                    int b = team1.get(j);
                    teamAbility1 += (ability[a][b]+ability[b][a]);
                }
            }

            for(int i=0; i<team2.size()-1; i++) {
                for(int j=i+1; j<team2.size(); j++) {
                    int a = team2.get(i);
                    int b = team2.get(j);
                    teamAbility2 += (ability[a][b]+ability[b][a]);
                }
            }

            // 결과 갱신
            answer = Math.min(answer,Math.abs(teamAbility1-teamAbility2));

            return;
        }

        // 덜 구성된 경우
        for(int i=idx; i<saramCnt; i++) {
            if(!visited[i]) {
                visited[i] = true;
                solve(i+1,cnt+1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 사람 수 입력
        saramCnt = Integer.parseInt(br.readLine());

        // 능력치 배열 생성
        ability = new int[saramCnt][saramCnt];

        // 능력치 정보 입력
        for(int i=0; i<saramCnt; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<saramCnt; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 팀 구성하기
        memberCnt = saramCnt/2;
        visited = new boolean[saramCnt];
        answer = (int)1e9;
        solve(0,0);

        // 결과 출력
        System.out.println(answer);
    }
}