import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과
    public static int answer;

    // 능력치 배열
    public static int[][] ability;

    // 방문 여부 배열
    public static boolean[] visited;

    // 선수 배치 메서드
    public static void solve(int player, int totalAbility) {

        // 배치가 완료된 경우
        if(player==11) {
            answer = Math.max(answer, totalAbility);
            return;
        }

        // 선수 배치하기
        for(int position=0; position<ability.length; position++) {
            if(!visited[position] && ability[player][position]!=0) {
                visited[position] = true;
                solve(player+1,totalAbility+ability[player][position]);
                visited[position] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseIndex=0; caseIndex<caseCount; caseIndex++) {

            // 능력치 배열 생성
            ability = new int[11][11];

            // 방문 여부 배열 생성
            visited = new boolean[11];

            // 선수 능력치 입력
            for(int player=0; player<ability.length; player++) {
                st = new StringTokenizer(br.readLine());
                for(int position=0; position<ability.length; position++) {
                    ability[player][position] = Integer.parseInt(st.nextToken());
                }
            }

            // 선수 배치
            answer = 0;
            solve(0,0);

            // 결과 저장
            sb.append(answer).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}