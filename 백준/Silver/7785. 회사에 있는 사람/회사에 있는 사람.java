import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 로그 저장 해시 셋
        TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());

        // 로그 기록 수 입력
        int logCnt = Integer.parseInt(br.readLine());

        // 로그 입력
        for(int i=0; i<logCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String exist = st.nextToken();

            // 출근
            if(exist.equals("leave")) set.remove(name);

            // 퇴근
            else set.add(name);
        }

        // 로그 확인
        for(String name: set)
            System.out.println(name);
    }
}