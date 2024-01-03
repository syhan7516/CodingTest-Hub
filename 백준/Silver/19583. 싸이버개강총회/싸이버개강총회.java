import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 시작, 종료, 스트리밍 종료 시간 입력
        st = new StringTokenizer(br.readLine());
        String start = st.nextToken();
        String end = st.nextToken();
        String stream = st.nextToken();

        // 결과
        int answer = 0;

        // 시작 시간 셋
        HashSet<String> startSet = new HashSet<>();
        
        // 종료 시간 셋
        HashSet<String> endSet = new HashSet<>();

        // 입력
        String str = null;

        // 채팅 시간 확인
        while((str = br.readLine()) != null) {
            
            // 시작과 같거나 작을 경우
            if(start.compareTo(str.split(" ")[0])>=0) {
                startSet.add(str.split(" ")[1]);
            }
            
            // 시작보다 같거나 크면서 스트리밍 종료 시간보다 작거나 같을 경우
            else if(end.compareTo(str.split(" ")[0])<=0 && stream.compareTo(str.split(" ")[0])>=0 ) {
                endSet.add(str.split(" ")[1]);
            }
        }
        
        // 양방향으로 이름 확인
        for(String data: endSet) {
            if(startSet.contains(data)) {
                answer ++;
            }
        }
        
        // 결과 출력
        System.out.println(answer);
    }
}