import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 방 크기, 시간, 클리너 위치
    public static int rowSize, colSize, totalTime, cleaner1, cleaner2;

    // 방
    public static int room[][];

    // 방향 벡터
    public static int dy[] = {0,1,0,-1};
    public static int dx[] = {1,0,-1,0};

    // 클리너 찾기 메서드
    public static void findCleaner() {

        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                if(room[rowIndex][colIndex]==-1) {
                    cleaner1 = rowIndex;
                    cleaner2 = rowIndex+1;
                    return;
                }
            }
        }
    }

    // 미세먼지 확산 메서드
    public static int[][] diffusion() {

        // 확산 정보 배열 생성
        int dust[][] = new int[rowSize][colSize];

        // 방 확인
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            for(int colIndex=0; colIndex<colSize; colIndex++) {

                // 미세먼지인 경우
                if(room[rowIndex][colIndex]>0) {

                    // 퍼짐 정도
                    int areaCount = 0;

                    // 한 구간 확산 정도
                    int dustValue = room[rowIndex][colIndex]/5;

                    // 방향 확인
                    for(int dir=0; dir<4; dir++) {
                        int nextY = rowIndex+dy[dir];
                        int nextX = colIndex+dx[dir];

                        // 범위 확인
                        if(nextY<0 || nextX<0 || nextY>rowSize-1 || nextX>colSize-1) continue;

                        // 공기청정기인 경우
                        if(room[nextY][nextX]==-1) continue;

                        dust[nextY][nextX] += dustValue;
                        areaCount++;
                    }

                    dust[rowIndex][colIndex] += room[rowIndex][colIndex]-(dustValue*areaCount);
                }
            }
        }

        dust[cleaner1][0] = -1;
        dust[cleaner2][0] = -1;
        return dust;
    }

    // 공기 청정기 작동 메서드
    public static void operatorCleaner() {

        // 반시계
        for (int rowIndex=cleaner1-1; rowIndex>0; rowIndex--) {
            room[rowIndex][0] = room[rowIndex-1][0];
        }

        for (int colIndex=0; colIndex<colSize-1; colIndex++) {
            room[0][colIndex] = room[0][colIndex+1];
        }

        for (int rowIndex=0; rowIndex<cleaner1; rowIndex++) {
            room[rowIndex][colSize-1] = room[rowIndex+1][colSize-1];
        }

        for (int colIndex=colSize-1; colIndex>1; colIndex--) {
            room[cleaner1][colIndex] = room[cleaner1][colIndex-1];
        }

        room[cleaner1][1] = 0;

        for (int rowIndex=cleaner2+1; rowIndex<rowSize-1; rowIndex++) {
            room[rowIndex][0] = room[rowIndex+1][0];
        }

        for (int colIndex=0; colIndex<colSize-1; colIndex++) {
            room[rowSize-1][colIndex] = room[rowSize-1][colIndex+1];
        }

        for (int rowIndex=rowSize-1; rowIndex>cleaner2; rowIndex--) {
            room[rowIndex][colSize-1] = room[rowIndex-1][colSize-1];
        }

        for (int colIndex=colSize-1; colIndex>1; colIndex--) {
            room[cleaner2][colIndex] = room[cleaner2][colIndex-1];
        }

        room[cleaner2][1] = 0;
    }

    // 먼지 확인 메서드
    public static int getCountDust() {

        // 먼지 개수
        int count = 0;

        // 방 확인
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                if(room[rowIndex][colIndex]>0)
                    count += room[rowIndex][colIndex];
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 방 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        totalTime = Integer.parseInt(st.nextToken());

        // 방 생성
        room = new int[rowSize][colSize];

        // 방 정보 입력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                room[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
            }
        }

        // 클리너 찾기
        findCleaner();

        // 작동
        for(int time=0; time<totalTime; time++) {

            // 미세먼지 확산
            room = diffusion();

            // 공기청정기 작동
            operatorCleaner();
        }

        // 결과 출력
        System.out.println(getCountDust());
    }
}