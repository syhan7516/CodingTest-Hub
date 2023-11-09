import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 계란의 수, 깰 수 있는 최소 계란 수
    public static int eggCnt, answer;

    // 계란 정보 배열
    public static int eggs[][];

    // 계란 깨기 메서드
    static void solve(int egg) {

        // 계란을 모두 친 경우
        if(egg==eggCnt) {

            // 깨진 계란 개수 확인
            int cnt = 0;

            for(int i=0; i<eggCnt; i++)
                if(eggs[i][0]<=0) cnt++;

            // 결과 갱신
            answer = Math.max(answer,cnt);
            return;
        }

        // 들고 있는 계란이 깨진 경우
        if(eggs[egg][0]<=0) {
            solve(egg+1);
        }

        // 멀쩡한 계란인 경우
        else {
            
            // 계란 친 여부
            boolean flag = false;
            
            for(int i=0; i<eggCnt; i++) {

                // 자신인 경우
                if(egg==i) continue;

                // 자신이 아니면서 계란이 깨지지 않은 경우
                if(eggs[i][0]>0) {

                    // 부딪히기
                    eggs[egg][0] -= eggs[i][1];
                    eggs[i][0] -= eggs[egg][1];
                    flag = true;

                    // 다음 계란 확인
                    solve(egg+1);

                    // 복구하기
                    eggs[egg][0] += eggs[i][1];
                    eggs[i][0] += eggs[egg][1];

                }
            }

            // 마지막 계란이 깨진 경우
            if(!flag) solve(egg+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 계란 수 입력
        eggCnt = Integer.parseInt(br.readLine());

        // 계란 정보 배열 생성
        eggs = new int[eggCnt][2];

        // 계란 정보 입력
        for(int i=0; i<eggCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            eggs[i][0] = a;
            eggs[i][1] = b;
        }

        // 계란 깨기
        answer = 0;

        // 계란이 하나가 아닌 경우
        if(eggCnt!=1) solve(0);

        // 결과 출력
        System.out.println(answer);
    }
}