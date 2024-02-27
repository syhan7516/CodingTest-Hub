import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 이닝 수, 결과
    public static int iningCnt, answer;

    // 이닝 결과 배열
    public static int iningResult[][];

    // 타자 순서 배열
    public static int order[];

    // 선택 여부 배열
    public static boolean visited[];

    // 게임 수행 메서드
    static void game() {

        // 점수
        int score = 0;

        // 현재 타자
        int current = 0;

        // 이닝 진행
        for(int i=1; i<=iningCnt; i++) {

            // 아웃
            int outCnt = 0;

            // 경기장 현황
            boolean status[] = new boolean[4];

            while(true) {

                // 3아웃인 경우
                if(outCnt==3)
                    break;

                // 다음 선수
                current++;
                if(current>9) current = 1;

                // 진행
                int res = iningResult[i][order[current]];

                // 0 - 아웃인 경우
                if(res==0) outCnt++;

                // 4
                else if(res==4) {
                    for(int p=3; p>0; p--) {

                        // 타석에 선수가 있는 경우
                        if(status[p]) score++;
                        status[p] = false;
                    }
                    
                    // 자기 자신 처리
                    score++;
                }

                // 1,2,3
                else {
                    for(int p=3; p>0; p--) {

                        // 타석에 선수가 있는 경우
                        if(status[p]) {
                            
                            // 이동
                            status[p] = false;
                            
                            // 홈에 들어간 경우
                            if(p+res>3) score++;

                            // 홈에 못들어간 경우
                            else status[p+res] = true;
                        }
                    }

                    // 자기 자신 처리
                    status[res] = true;
                }
            }
        }

        // 결과 갱신
        answer = Math.max(answer,score);
    }

    // 타자 순서 배치하기 메서드
    static void solve(int idx, int cnt) {

        // 다 선택한 경우
        if(cnt==10) {

            // 게임 수행
            game();

            return;
        }

        // 아닌 경우 - 4번 타자인 경우
        if(idx==4) solve(idx+1,cnt+1);

        // 아닌 경 - 그 외 타자인 경우
        else {
            for(int i=1; i<10; i++) {

                // 그 외 타자인 경우
                if(!visited[i]) {
                    visited[i] = true;
                    order[idx] = i;
                    solve(idx+1,cnt+1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 이닝 수 입력
        iningCnt = Integer.parseInt(br.readLine());

        // 이닝 결과 배열 생성
        iningResult = new int[iningCnt+1][10];

        // 이닝 결과 입력
        for(int i=1; i<=iningCnt; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<10; j++) {
                iningResult[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 타자 순서 배치하기
        answer = 0;
        order = new int[10];
        visited = new boolean[10];
        order[4] = 1;
        visited[1] = true;
        solve(1,1);

        // 결과 출력
        System.out.println(answer);
    }
}