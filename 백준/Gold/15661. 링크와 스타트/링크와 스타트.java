import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 결과, 사람 수
    public static int answer, humanCount;

    // 능력치 배열
    public static int ability[][];

    // start, link 팀
    public static ArrayList<Integer> startTeam, linkTeam;

    // 팀 구분하여 능력치 비교 메서드
    public static void solve(int order) {

        // 다 구성한 경우
        if(order>humanCount) {

            // 팀원이 없는 경우
            if(startTeam.size()==0 || linkTeam.size()==0)
                return;

            // 능력치 비교
            int startTeamAbility = 0;
            int linkTeamAbility = 0;

            // start 팀 능력치 구하기
            for(int i=0; i<startTeam.size()-1; i++) {
                for(int j=i+1; j<startTeam.size(); j++) {
                    startTeamAbility += ability[startTeam.get(i)][startTeam.get(j)];
                    startTeamAbility += ability[startTeam.get(j)][startTeam.get(i)];
                }
            }

            // link 팀 능력치 구하기
            for(int i=0; i<linkTeam.size()-1; i++) {
                for(int j=i+1; j<linkTeam.size(); j++) {
                    linkTeamAbility += ability[linkTeam.get(i)][linkTeam.get(j)];
                    linkTeamAbility += ability[linkTeam.get(j)][linkTeam.get(i)];
                }
            }
            
            // 결과 갱신
            answer = Math.min(answer,Math.abs(startTeamAbility-linkTeamAbility));
            return;
        }

        // 선택 O
        startTeam.add(order);
        solve(order+1);
        startTeam.remove(startTeam.get(startTeam.size()-1));
        linkTeam.add(order);
        solve(order+1);
        linkTeam.remove(linkTeam.get(linkTeam.size()-1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 서럼 수 입력
        humanCount = Integer.parseInt(br.readLine());

        // 능력치 배열 생성
        ability = new int[humanCount+1][humanCount+1];

        // 능력치 입력
        for(int i=1; i<=humanCount; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=humanCount; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 팀 구분하여 능력치 비교
        answer = Integer.MAX_VALUE;
        startTeam = new ArrayList<>();
        linkTeam = new ArrayList<>();
        solve(1);

        // 결과 출력
        System.out.println(answer);
    }
}