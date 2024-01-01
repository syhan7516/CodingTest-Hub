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

        // 메모장 역할 맵
        HashMap<String,String> map = new HashMap<>();

        // 사이트 주소 수, 비밀번호 찾으려는 수 입력
        st = new StringTokenizer(br.readLine());
        int siteCnt = Integer.parseInt(st.nextToken());
        int findCnt = Integer.parseInt(st.nextToken());

        // 사이트 주소, 비밀번호 입력
        for(int i=0; i<siteCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String password = st.nextToken();
            map.put(site,password);
        }

        // 비밀번호 찾기
        for(int i=0; i<findCnt; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}