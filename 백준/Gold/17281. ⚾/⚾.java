import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 이닝수, 총 점수
    public static int termCnt, totalScore;
    // 선수 획득 점수 배열
    public static int playerResult[][];
    // 선수 배치 배열
    public static int postition[] = new int[10];
    // 방문 배열
    public static boolean visisted[] = new boolean[10];

    // 게임 진행
    static void gameStart() {
        int curTerm = 1;
        int playerNum = 1;
        boolean ground[] = new boolean[4];
        int outCnt = 0;
        int score = 0;

        // 이닝만큼 경기
        while (curTerm < termCnt+1) {
            // 플레이어 한 번씩 다 친 경우
            if (playerNum == 10)
                playerNum = 1;
            // 이닝 순서에 맞게 선수 출전
            int prs = playerResult[curTerm][postition[playerNum]];
            // 아웃
            if (prs == 0) {
                outCnt += 1;
            }
            // 홈런
            else if (prs == 4) {
                for(int g=1; g<4; g++) {
                    if(ground[g]==true)
                        score += 1;
                }
                Arrays.fill(ground,false);
                score += 1;
            }
            // 안타
            else {
                for(int g=3; g>0; g--) {
                    if(ground[g]==true) {
                        int result = g + prs;
                        if(result>3) {
                            score += 1;
                            ground[g]=false;
                        }
                        else {
                            ground[g]=false;
                            ground[result]=true;
                        }
                    }
                }
                ground[prs]=true;
            }

            if (outCnt == 3) {
                outCnt = 0;
                curTerm += 1;
                Arrays.fill(ground, false);
            }

            playerNum += 1;
        }

        totalScore = Math.max(totalScore,score);
    }

    // 선수 배치 함수
    static void getPosition(int depth) {
        if(depth==10) {
            gameStart();
            return;
        }

        if(depth==4) {
            getPosition(depth+1);
            return;
        }

        for(int idx=1; idx<=9; idx++) {
            if(visisted[idx]==false ) {
                visisted[idx] = true;
                postition[depth] = idx;
                getPosition(depth+1);
                visisted[idx] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 이닝수 입력
        termCnt = Integer.parseInt(st.nextToken());
        // 점수 입력
        playerResult = new int[termCnt+1][10];
        for(int idx=1; idx<=termCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            for(int player=1; player<=9; player++) {
                playerResult[idx][player] = Integer.parseInt(st.nextToken());
            }
        }
        // 선수 배치
        visisted[1] = true;
        postition[4] = 1;
        int depth = 1;
        for(int idx=1; idx<=9; idx++) {
            if(idx==1)
                continue;
            visisted[idx] = true;
            postition[depth] = idx;
            getPosition(depth+1);
            visisted[idx] = false;
        }

        // 결과 출력
        System.out.println(totalScore);
    }
}