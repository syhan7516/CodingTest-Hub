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

        // 대기 목록 번호 기준, 학번 기준 해시 맵 생성
        HashMap<Integer,String> waitToNumber = new HashMap<>();
        HashMap<String,Integer> numberToWait = new HashMap<>();

        // 과목 수강 가능 인원, 대기 목록 길이 입력
        st = new StringTokenizer(br.readLine());
        int possible = Integer.parseInt(st.nextToken());
        int wait = Integer.parseInt(st.nextToken());

        // 대기 목록 입력
        for(int i=0; i<wait; i++) {

            // 학번
            String number = br.readLine();

            // 이미 존재하는 경우
            if(numberToWait.containsKey(number)) {

                // 기존 값 제거
                int delete = numberToWait.get(number);
                waitToNumber.put(delete,"no");
            }

            // 새로운 값 넣기
            numberToWait.put(number,i);
            waitToNumber.put(i,number);
        }

        // 결과 출력
        int cnt = 0;
        for(int i=0; i<wait; i++) {

            // 삭제인 경우
            if(waitToNumber.get(i).equals("no")) continue;

            // 미삭제인 경우
            else {
                sb.append(waitToNumber.get(i)).append("\n");
                cnt++;
            }

            // 신청된 인원 확인
            if(cnt==possible) break;
        }

        System.out.println(sb.toString());
    }
}