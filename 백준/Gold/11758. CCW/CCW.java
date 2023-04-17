import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 좌표 평면 만들기
        int point[][] = new int[3][2];

        // 각 좌표 값 저장
        for(int p=0; p<3; p++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            point[p][0] = y;
            point[p][1] = x;
        }

        // 좌표 확인
        // CCW 공식 : x1y2 + x2y3 + x3y1 - (y1x2 + y2x3 + y3x1)
        int result = 0;
        result += (point[0][1]*point[1][0]) + (point[1][1]*point[2][0]) + (point[2][1]*point[0][0]);
        result -= (point[0][0]*point[1][1]) + (point[1][0]*point[2][1]) + (point[2][0]*point[0][1]);

        // 결과 출력
        if(result>0)
            System.out.println(1);
        else if(result<0)
            System.out.println(-1);
        else
            System.out.println(0);
    }
}