import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = 0;

        // 가로, 세로, 사람 수 입력
        st = new StringTokenizer(br.readLine());
        int rowSize = Integer.parseInt(st.nextToken());
        int colSize = Integer.parseInt(st.nextToken());
        int saram = Integer.parseInt(st.nextToken());

        // 예매 정보 배열 생성
        char[][] board = new char[rowSize][colSize];

        // 예매 정보 입력
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            board[rowIndex] = br.readLine().toCharArray();
        }

        // 예매 가능 여부 확인
        for(int rowIndex=0; rowIndex<rowSize; rowIndex++) {
            for(int colIndex=0; colIndex<colSize; colIndex++) {
                if(board[rowIndex][colIndex] == '0') {
                    boolean possible = true;
                    for(int seat=1; seat<saram; seat++) {
                        if(colIndex+seat > colSize-1 || board[rowIndex][colIndex+seat] == '1') {
                            possible = false;
                            break;
                        }
                    }

                    if(possible) {
                        answer++;
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}