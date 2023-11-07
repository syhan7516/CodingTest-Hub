import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    // A^exponent
    static long pow(long a, long b, long c) {

        // 지수가 1일 경우
        if(b==1) return a%c;

        // 지수의 절반
        long d = pow(a, b/2,c);

        if(b%2==1) return (d * d % c) * a % c;
        return d * d % c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // a, b, c 입력
        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        System.out.println(pow(a,b,c));
    }
}