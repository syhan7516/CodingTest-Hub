import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 도감 해시 맵
        HashMap<String,String> map = new HashMap<>();

        // 도감 포켓몬 개수, 문제 개수 입력
        st = new StringTokenizer(br.readLine());
        int poketCnt = Integer.parseInt(st.nextToken());
        int problemCnt = Integer.parseInt(st.nextToken());

        // 포켓몬 입력
        for(int i=1; i<=poketCnt; i++) {
            String number = String.valueOf(i);
            String poket = br.readLine();
            map.put(number,poket);
            map.put(poket,number);
        }

        // 문제 입력
        for(int i=0; i<problemCnt; i++) {
            String problem = br.readLine();
            sb.append(map.get(problem)).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}