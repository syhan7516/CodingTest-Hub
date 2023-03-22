import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 결과, 총 인원 수 입력
    public static int result, totalCnt;
    // 팀 능력치 배열
    public static int ability[][];
    // 팀 표시 배열
    public static boolean teamCheck[];

    // 능력치 차이
    static void getDiffAbility() {
        // 각 팀의 총점
        int abilityA = 0;
        int abilityB = 0;
        for(int a=0; a<totalCnt-1; a++) {
            for(int b=a+1; b<totalCnt; b++) {
                if(teamCheck[a]==true && teamCheck[b]==true) {
                    abilityA += (ability[a][b] + ability[b][a]);
                    continue;
                }

                if(teamCheck[a]==false && teamCheck[b]==false) {
                    abilityB += (ability[a][b] + ability[b][a]);
                }
            }
        }

        // 두 팀의 능력치 차이
        int diff = Math.abs(abilityA-abilityB);

        // 차이가 0인 경우
        if(diff == 0) {
            System.out.println(diff);
            System.exit(0);
        }

        // 가장 박빙인 능력치 저장
        result = Math.min(result,diff);
    }

    // 팀 배정 함수
    static void playerTrade(int depth, int a) {
        // 인원 수만큼 뽑았을 경우
        if(depth==totalCnt/2) {
            getDiffAbility();
            return;
        }

        // 팀 배정
        for(int trade=a; trade<totalCnt; trade++) {
            teamCheck[trade] = true;
            playerTrade(depth+1,trade+1);
            teamCheck[trade] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 결과
        result = Integer.MAX_VALUE;

        // 총 인원 수 입력
        totalCnt = Integer.parseInt(st.nextToken());
        teamCheck = new boolean[totalCnt];

        // 능력치 입력
        ability = new int[totalCnt][totalCnt];
        for(int row=0; row<totalCnt; row++) {
            st = new StringTokenizer(br.readLine());
            for(int col=0; col<totalCnt; col++) {
                ability[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        // 팀 배정
        int depth = 0;
        playerTrade(depth,0);

        // 결과 출력
        System.out.println(result);
    }
}