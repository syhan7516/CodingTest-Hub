import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 총 시간, 총 체력
    public static int result, totalTime, totalHp;
    
    // DP 배열
    public static int DP[][];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 총 시간, 체력 입력
        st = new StringTokenizer(br.readLine());
        totalTime = Integer.parseInt(st.nextToken());
        totalHp = Integer.parseInt(st.nextToken());
        
        // DP 배열 생성
        DP = new int[totalTime+1][totalHp+1];

        // 자두 담기
        for (int time=1; time<=totalTime; time++) {
            
            // 위치 입력
            int point = Integer.parseInt(br.readLine());

            // 체력 순회
            for (int hp=0; hp<=totalHp; hp++) {

                // 이동을 안한 경우
                if(hp==0) {

                    // 위치 1
                    if(point==1) DP[time][hp] = DP[time-1][hp]+1;

                    // 위치 2
                    else DP[time][hp] = DP[time-1][hp];

                    continue;
                }

                // 이동 - 짝수
                if (hp%2==0) {

                    // 위치 1
                    if(point==1)
                        DP[time][hp] = Math.max(DP[time-1][hp]+1, DP[time-1][hp-1]);

                    // 위치 2
                    else
                        DP[time][hp] = Math.max(DP[time-1][hp], DP[time-1][hp-1]+1);
                }

                // 이동 - 홀수
                else {

                    // 위치 1
                    if(point==1)
                        DP[time][hp] = Math.max(DP[time-1][hp-1]+1, DP[time-1][hp]);

                    // 위치 2
                    else
                        DP[time][hp] = Math.max(DP[time-1][hp-1], DP[time-1][hp]+1);
                }
            }
        }

        // 결과
        result = 0;
        for(int hp=0; hp<=totalHp; hp++)
            result = Math.max(result, DP[totalTime][totalHp]);

        // 결과 출력
        System.out.println(result);
    }
}