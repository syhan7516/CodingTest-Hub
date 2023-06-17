import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 인원 수 입력
        int humanCnt = Integer.parseInt(br.readLine());

        // 인원 정보 입력
        int humans[] = new int[humanCnt];

        st = new StringTokenizer(br.readLine());
        for(int idx=0; idx<humanCnt; idx++) {
            humans[idx] = Integer.parseInt(st.nextToken());
        }

        // 결과
        long result = 0;

        // 포인터
        int firPoint = 0;
        int secPoint = humanCnt-1;

        // 능력치 확인
        while(firPoint<secPoint) {

            // 계산 & 갱신
            long stats = (secPoint-firPoint-1) * Math.min(humans[firPoint],humans[secPoint]);
            result = Math.max(result,stats);

            // 포인터 갱신
            if(humans[firPoint]<=humans[secPoint]) {
                firPoint++;
            }

            else {
                secPoint--;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}