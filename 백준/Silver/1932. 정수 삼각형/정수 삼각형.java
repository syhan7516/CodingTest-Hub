import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 삼각형 크기 입력
        int size = Integer.parseInt(br.readLine());

        // 삼각형 배열, 합 배열 생성
        int triangle[][] = new int[size+1][size+1];
        int DP[][] = new int[size+1][size+1];

        // 삼각형 정보 입력
        for(int height=1; height<=size; height++){
            st = new StringTokenizer(br.readLine());
            for(int width=1; width<=height; width++){
                triangle[height][width] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기 설정
        DP[1][1] = triangle[1][1];

        // 각 위치 최대 합구하기
        int answer = DP[1][1];
        for(int height=2; height<=size; height++){
            for(int width=1; width<=height; width++){
                DP[height][width] = Math.max(DP[height-1][width-1],DP[height-1][width])+triangle[height][width];
                answer = Math.max(answer,DP[height][width]);
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}