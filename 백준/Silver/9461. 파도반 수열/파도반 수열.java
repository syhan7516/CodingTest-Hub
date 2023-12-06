import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 수열 정보 배열
        long arr[] = new long[101];

        // 수열 초기 값
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        arr[5] = 2;
        arr[6] = 3;

        // 배열 정보 채우기
        for(int i=7; i<101; i++) {
            arr[i] = arr[i-1]+arr[i-5];
        }

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 정수 입력
            int number = Integer.parseInt(br.readLine());

            // 결과 저장
            sb.append(arr[number]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}