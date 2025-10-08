import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // gcd
    public static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 음식 개수, 사람 수 입력
        st = new StringTokenizer(br.readLine());
        int foodCount = Integer.parseInt(st.nextToken());
        int saram = Integer.parseInt(st.nextToken());

        // 결과 출력
        System.out.println(saram - gcd(foodCount, saram));
    }
}