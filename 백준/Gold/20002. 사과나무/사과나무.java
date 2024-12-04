import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 결과, 과수원 크기
    public static int answer, groundSize;

    // 과수원 배열, 누적합 배월
    public static int[][] ground, prefixSum;

    // 사과 수확하기 메서드
    public static void solve() {

        // 수확 크기
        int size = 0;

        // 수확 가능한 곳 확인
        while(size++<groundSize) {

            for(int rowIndex=size; rowIndex<=groundSize; rowIndex++) {
                for(int colIndex=size; colIndex<=groundSize; colIndex++) {

                    // 수확 결과
                    int result = prefixSum[rowIndex][colIndex]-prefixSum[rowIndex-size][colIndex]
                            -prefixSum[rowIndex][colIndex-size]+prefixSum[rowIndex-size][colIndex-size];

                    // 결과 비교
                    answer = Math.max(answer,result);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 과수원 크기 입력
        groundSize = Integer.parseInt(br.readLine());

        // 과수원, 누적합 배열 생성
        ground = new int[groundSize+1][groundSize+1];
        prefixSum = new int[groundSize+1][groundSize+1];

        // 과수원 정보 입력
        for(int rowIndex=1; rowIndex<=groundSize; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=1; colIndex<=groundSize; colIndex++) {
                ground[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
                prefixSum[rowIndex][colIndex] =
                        prefixSum[rowIndex-1][colIndex]
                                +prefixSum[rowIndex][colIndex-1]
                                -prefixSum[rowIndex-1][colIndex-1]
                                +ground[rowIndex][colIndex];
            }
        }

        // 사과 수확하기
        answer = Integer.MIN_VALUE;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}