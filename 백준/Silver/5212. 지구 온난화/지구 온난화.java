import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 가로, 세로 크기
    public static int rowSize, colSize;

    // 지도 최대, 최소 크기
    public static int maxRow, maxCol, minRow, minCol;

    // 지도, 미래 지도
    public static char[][] currentMap, futureMap;

    // 방향 벡터
    public static int[] dy = {0,1,0,-1};
    public static int[] dx = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 가로, 세로 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 지도 생성
        currentMap = new char[rowSize][colSize];
        futureMap = new char[rowSize][colSize];

        // 지도 정보 입력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            String line = br.readLine();
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                currentMap[rowIndex][colIndex] = line.charAt(colIndex);
                futureMap[rowIndex][colIndex] = currentMap[rowIndex][colIndex];
            }
        }

        // 지도 최대, 최소 크기 초기화
        maxRow = -1;
        maxCol = -1;
        minRow = rowSize;
        minCol = colSize;

        // 50년 후 확인
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            for(int colIndex=0; colIndex<colSize; colIndex++) {

                // 땅인 경우
                if(currentMap[rowIndex][colIndex] == 'X') {

                    // 바다 개수
                    int ocean = 0;

                    // 인접 위치 확인
                    for(int dir=0; dir<4; dir++) {
                        int nextY = rowIndex + dy[dir];
                        int nextX = colIndex + dx[dir];

                        // 바다인 경우 - 1
                        if(nextY<0 || nextY>rowSize-1 || nextX<0 || nextX>colSize-1) {
                            ocean++;
                            continue;
                        }

                        // 바다인 경우 - 2
                        if(currentMap[nextY][nextX] == '.') {
                            ocean++;
                        }
                    }

                    // 바다가 많은 경우
                    if(ocean >= 3) {
                        futureMap[rowIndex][colIndex] = '.';
                    }

                    // 잠기지 않은 경우
                    else {
                        maxRow = Math.max(maxRow, rowIndex);
                        maxCol = Math.max(maxCol, colIndex);
                        minRow = Math.min(minRow, rowIndex);
                        minCol = Math.min(minCol, colIndex);
                    }
                }
            }
        }

        // 결과 저장
        for(int rowIndex=minRow; rowIndex<=maxRow; rowIndex++) {
            for(int colIndex=minCol; colIndex<=maxCol; colIndex++) {
                sb.append(futureMap[rowIndex][colIndex]);
            }
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}