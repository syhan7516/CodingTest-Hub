import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 크기 입력
        int size = Integer.parseInt(br.readLine());

        // 타일 배열 생성
        int tile[] = new int[1001];
        tile[1] = 1;
        tile[2] = 2;

        // 개수 구하기
        for(int count=3; count<=size; count++) {
            tile[count] = (tile[count-1]+tile[count-2])%10007;
        }

        // 결과 출력
        System.out.println(tile[size]);
    }
}