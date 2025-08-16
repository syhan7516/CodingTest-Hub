import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLData;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 범위 입력
        st = new StringTokenizer(br.readLine());
        long startNum = Long.parseLong(st.nextToken());
        long endNum = Long.parseLong(st.nextToken());

        // 범위 사이 숫자 개수
        int count = (int)(endNum - startNum + 1);

        // 범위 사이 배열 생성
        boolean[] visited = new boolean[count];

        // 제곱 수가 범위 이하일 때까지 확인
        for(long num=2; num*num<=endNum; num++) {

            // 대상 제곱 수
            long square = num * num;

            // 시작 범위로부터 제곱 수의 첫 배수
            long squareNum = ((startNum + square - 1) / square) * square;

            // 범위 사이 숫자 확인
            for(long multipleSquareNum=squareNum; multipleSquareNum<=endNum; multipleSquareNum+=square) {
                int index = (int)(multipleSquareNum - startNum);
                if(!visited[index]) {
                    visited[index] = true;
                    count--;
                }
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}