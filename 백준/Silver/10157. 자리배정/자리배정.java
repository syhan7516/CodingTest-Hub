import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        int colSize = Integer.parseInt(st.nextToken());
        int rowSize = Integer.parseInt(st.nextToken());

        // 공연장 만들기
        int stage[][] = new int[rowSize+1][colSize+1];

        // 찾을 번호 입력
        int findNum = Integer.parseInt(br.readLine());

        // 최대 자리 확인
        boolean flag = true;
        if(rowSize*colSize<findNum) {
            flag = false;
        }

        // 방향 벡터
        int dy[] = {1,0,-1,0};
        int dx[] = {0,1,0,-1};
        int dir = 0, x = 1, y = 1, curNum = 2;
        stage[y][x] = 1;

        // 좌석 배치
        if(flag) {
            while(true) {

                // 종료 조건
                if(curNum>findNum)
                    break;

                // 이동할 좌석
                int nextY = y+dy[dir];
                int nextX = x+dx[dir];

                // 이동가능한지 확인
                if(nextY>rowSize || nextY<1 || nextX>colSize || nextX<1 || stage[nextY][nextX]!=0) {
                    dir += 1;
                    if(dir>3) dir=0;
                    continue;
                }

                // 이동 후 좌석 배치
                y = nextY;
                x = nextX;

                stage[y][x] = curNum++;
            }
        }

        // 결과 출력
        if(!flag)
            System.out.println(0);
        else
            System.out.println(x+" "+y);
    }
}