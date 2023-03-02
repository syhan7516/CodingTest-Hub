import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 케이스 수 입력
        int caseNum = Integer.parseInt(st.nextToken());
        // 케이스 수만큼 작업 반복
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {
            // 결과
            boolean result = true;

            // 방향 벡터
            int dx[] = {1,0,-1,0};
            int dy[] = {0,1,0,-1};

            // 가로, 세로 길이 입력
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            // 판 만들기
            char board[][] = new char[row][col];

            // 판 칠하기 1
            for(int r=0; r<row; r++) {
                st = new StringTokenizer(br.readLine());
                String letters = st.nextToken();
                for(int c=0; c<col; c++) {
                    board[r][c] = letters.charAt(c);
                }
            }

            // 판 칠하기 2
            for(int r=0; r<row; r++) {
                for (int c = 0; c < col; c++) {
                    if (board[r][c] == '?') {
                        for (int dir = 0; dir < 4; dir++) {
                            int checkY = r + dy[dir];
                            int checkX = c + dx[dir];
                            if (checkY < 0 || checkY > row - 1 || checkX < 0 || checkX > col - 1 || board[checkY][checkX] == '?')
                                continue;

                            if (board[r][c] == '?' && board[checkY][checkX] == '#') {
                                board[r][c] = '.';
                            } else if (board[r][c] == '?' && board[checkY][checkX] == '.') {
                                board[r][c] = '#';
                            } else if (board[r][c] != '?' && board[checkY][checkX] == board[r][c])
                                result = false;
                        }
                    }
                    else {
                        for (int dir = 0; dir < 4; dir++) {
                            int checkY = r + dy[dir];
                            int checkX = c + dx[dir];
                            if (checkY < 0 || checkY > row - 1 || checkX < 0 || checkX > col - 1 || board[checkY][checkX] == '?')
                                continue;

                            if (board[r][c] == board[checkY][checkX])
                                result = false;
                        }
                    }
                }
            }
            // 결과 출력
            System.out.print("#"+(caseIdx+1)+" ");
            if(result==true)
                System.out.println("possible");
            else
                System.out.println("impossible");
        }
    }
}