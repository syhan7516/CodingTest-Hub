import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 스위치 개수 입력
        int switchCnt = Integer.parseInt(br.readLine());

        // 스위치 상태 배열
        boolean state[] = new boolean[switchCnt+1];

        // 스위치 상태 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int s=1; s<=switchCnt; s++) {

            // 1인 경우
            if(Integer.parseInt(st.nextToken())==1)
                state[s] = true;
        }

        // 학생 수 입력
        int studentCnt = Integer.parseInt(br.readLine());

        // 학생 정보 입력
        for(int s=0; s<studentCnt; s++) {
            st = new StringTokenizer(br.readLine());

            // 성별 입력
            int gender = Integer.parseInt(st.nextToken());

            // 위치 입력
            int point = Integer.parseInt(st.nextToken());
            
            // 남자인 경우
            if(gender==1) {

                // 스위치 변경
                for(int c=point; c<=switchCnt; c+=point)
                    state[c] = !state[c];
            }

            // 여자인 경우
            else {

                // 좌우 대칭 확인
                int dist = 0;
                int start = point;
                int end = point;

                while(true) {

                    // 거리 계산 변수
                    start = point-dist;
                    end = point+dist;

                    // 거리 범위 확인
                    if(start<1 || end>switchCnt)
                        break;

                    // 서로 다른지 확인
                    if(state[start]!=state[end])
                        break;

                    // 거리 증가
                    dist++;
                }

                // 스위치 변경
                for(int c=start+1; c<=end-1; c++) {
                    state[c] = !state[c];
                }
            }
        }

        // 결과 출력
        for(int c=1; c<=switchCnt; c++) {
            
            // 출력
            System.out.print(((state[c]) ? 1 : 0)+" ");

            // 20개 초과인 경우
            if(c%20==0) System.out.println();
        }
    }
}