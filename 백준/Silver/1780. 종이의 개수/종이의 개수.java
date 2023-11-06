import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 행렬의 크기
    public static int size;

    // 행렬
    public static int board[][];

    // -1, 0, 1의 개수
    public static int minusCnt = 0;
    public static int zeroCnt = 0;
    public static int plusCnt = 0;

    // 모두 같은 색인지 확인하는 메서드
    public static boolean colorCheck(int row, int col, int size) {
        
        // 시작 지점 색
        int color = board[row][col];

        // 검사
        for(int i=row; i<row+size; i++) {
            for (int j=col; j<col+size; j++) {

                // 다른 색인 경우
                if (color != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 종이 자르기 메서드
    public static void partition(int row, int col, int size) {

        // 같은 색인 경우 수 더하기
        if (colorCheck(row, col, size)) {

            // -1
            if(board[row][col]==-1) {
                minusCnt++;
            }

            // 0
            else if(board[row][col]==0) {
                zeroCnt++;
            }

            // 1
            else {
                plusCnt++;
            }
            return;
        }

        // 크기 갱신
        int newSize = size / 3;

        // 9등분 재귀
        partition(row,col,newSize);
        partition(row,col+newSize,newSize);
        partition(row,col+2*newSize,newSize);

        partition(row+newSize,col,newSize);
        partition(row+newSize,col+newSize,newSize);
        partition(row+newSize,col+2*newSize,newSize);

        partition(row+2*newSize,col,newSize);
        partition(row+2*newSize,col+newSize,newSize);
        partition(row+2*newSize,col+2*newSize,newSize);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 행렬의 크기 입력
        size = Integer.parseInt(br.readLine());

        // 행렬 생성
        board = new int[size][size];

        // 행렬 정보 입력
        for (int i=0; i<size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<size; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 종이 자르기
        partition(0, 0, size);

        // 결과 출력
        System.out.println(minusCnt);
        System.out.println(zeroCnt);
        System.out.println(plusCnt);
    }
}