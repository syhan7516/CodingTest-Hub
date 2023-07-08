import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 로그 수 입력
        int logCnt = Integer.parseInt(br.readLine());

        // 사람 정보 해시
        HashMap<String,String> inout = new HashMap<>();

        // 로그 입력
        for(int l=0; l<logCnt; l++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String ox = st.nextToken();
            inout.put(name,ox);
        }

        // 키 배열
        String names[] = inout.keySet().toArray(new String[0]);
        
        // 이름 역순 정렬
        Arrays.sort(names);
        
        // 역순으로 사람들 확인
        for(int s=names.length-1; s>=0; s--) {
            
            // 출근한 경우
            if(inout.get(names[s]).equals("enter"))
                System.out.println(names[s]);
        }
    }
}