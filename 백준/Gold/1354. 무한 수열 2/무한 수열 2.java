import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static long N;
    public static int P, Q, X, Y;
    public static HashMap<Long, Long> map;

    public static void put(long key) {
        if(key <= 0L) map.put(key, 1L);
        else {
            map.put(key, get(key / P - X) + get(key / Q - Y));
        }
    }

    public static long get(long key) {
        if(!map.containsKey(key)) put(key);
        return map.get(key);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N, P, Q, X, Y 입력
        st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        map = new HashMap<>();

        // 결과 출력
        System.out.println(get(N));
    }
}