import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 주사위 개수
    public static int answer, diceCnt;

    // 주사위 정보 배열
    public static int dice[][];

    // 주사위 위, 아래 매칭 배열
    public static int upDownMatch[] = {5,3,4,1,2,0};

    // 다른 가장 큰 면 찾기 메서드
    public static int maxSide(int down, int up) {

        // 면 확인
        for(int i=6; i>0; i--) {
            if(i!=down && i!=up)
                return i;
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 주사위 개수 입력
        diceCnt = Integer.parseInt(br.readLine());

        // 주사위 정보 배열 생성
        dice = new int[diceCnt][6];

        // 주사위 정보 입력
        for(int i=0; i<diceCnt; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<6; j++)
                dice[i][j] = Integer.parseInt(st.nextToken());
        }

        // 주사위 선택
        for(int i=0; i<6; i++) {

            // 주사위 각 면의 합
            int sum = 0;

            int down = dice[0][i];
            int up = dice[0][upDownMatch[i]];

            for(int j=0; j<diceCnt; j++) {

                for(int k=0; k<6; k++) {

                    // 면 선택
                    if(dice[j][k]==up) {
                        down = up;
                        up = dice[j][upDownMatch[k]];

                        // 다른 가장 큰 면 찾기
                        sum += maxSide(down,up);
                        break;
                    }
                }
            }

            // 기존 최대 값과 비교
            answer = Math.max(answer,sum);
        }

        // 결과 출력
        System.out.println(answer);
    }
}