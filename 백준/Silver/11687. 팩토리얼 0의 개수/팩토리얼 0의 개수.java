import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 0개수 구하기 메서드
    public static int findZero(int value) {

        // 0개수
        int currentZeroCount = 0;

        // 5 ~ 숫자 (5, 25, 125, 625, ...)
        for(int num=5; num<=value; num*=5) {
            currentZeroCount += value / num;
        }

        return currentZeroCount;
    }

    // 0개수를 만족하는 최솟값 구하기 메서드
    public static int binarySearch(int zeroCount, int left, int right) {

        // 동일 여부
        boolean possible = false;

        // 탐색 수행
        while(left <= right) {

            // 값 설정
            int mid = (left+right) / 2;

            // 0 개수가 더 많은 경우
            if(zeroCount < findZero(mid)) {
                right = mid - 1;
            }

            // 0 개수가 같은 경우
            else if(zeroCount == findZero(mid)) {
                right = mid - 1;
                possible = true;
            }

            // 0 개수가 더 적은 경우
            else left = mid + 1;
        }

        // 같은 개수를 찾았던 경우
        if(possible) return left;

        // 없었던 경우
        else return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 0 개수 입력
        int zeroCount = Integer.parseInt(br.readLine());

        // 결과
        int answer = binarySearch(zeroCount, 1, 1000000000);

        // 결과 출력
        System.out.println(answer);
    }
}