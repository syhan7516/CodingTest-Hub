import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// SCV 클래스
class SCV {
    int HP1;
    int HP2;
    int HP3;
    int attackCount;

    public SCV(int HP1, int HP2, int HP3, int attackCount) {
        this.HP1 = HP1;
        this.HP2 = HP2;
        this.HP3 = HP3;
        this.attackCount = attackCount;
    }
}

public class Main {

    // HP
    public static final int MAX_HP = 61;

    // 결과, SCV 개수
    public static int answer, scvCount;

    // HP 배열
    public static int[] HP;

    // 방문 여부 배열
    public static boolean[][][] visited;

    // 공격 배열
    public static int[][] attacks = {
            {9,3,1},
            {9,1,3},
            {3,1,9},
            {3,9,1},
            {1,3,9},
            {1,9,3}
    };

    // 공격하기 메서드
    public static void solve() {

        // SCV 상태 저장 큐 생성
        Queue<SCV> queue = new LinkedList<>();

        // 방문 여부 배열 생성
        visited = new boolean[MAX_HP][MAX_HP][MAX_HP];

        // 첫 HP 처리
        queue.offer(new SCV(HP[0],HP[1],HP[2], 0));
        visited[HP[0]][HP[1]][HP[2]] = true;

        // 공격 수행
        while(!queue.isEmpty()) {

            // 현재 SCV 상태
            SCV currentSCV = queue.poll();

            // SCV 다 잡은 경우
            if(currentSCV.HP1==0 && currentSCV.HP2==0 && currentSCV.HP3==0) {
                answer = currentSCV.attackCount;
                return;
            }

            // 가능한 공격 수행
            for(int index=0; index<6; index++) {
                int nextHP1 = Math.max(currentSCV.HP1-attacks[index][0],0);
                int nextHP2 = Math.max(currentSCV.HP2-attacks[index][1],0);
                int nextHP3 = Math.max(currentSCV.HP3-attacks[index][2],0);

                // 이미 방문한 경우
                if(visited[nextHP1][nextHP2][nextHP3]) continue;

                // 공격받은 상태 추가
                visited[nextHP1][nextHP2][nextHP3] = true;
                queue.offer(new SCV(nextHP1,nextHP2,nextHP3,currentSCV.attackCount+1));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // SCV 개수 입력
        scvCount = Integer.parseInt(br.readLine());

        // HP 배열 생성
        HP = new int[3];

        // HP 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<scvCount; index++) {
            HP[index] = Integer.parseInt(st.nextToken());
        }

        // 공격하기
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}