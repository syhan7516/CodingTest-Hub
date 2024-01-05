import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 걸그룹 수, 문제 수 입력
        st = new StringTokenizer(br.readLine());
        int groupCnt = Integer.parseInt(st.nextToken());
        int problemCnt = Integer.parseInt(st.nextToken());

        // 멤버 소속 그룹 정보 저장 해시 생성
        HashMap<String, String> members = new HashMap<>();

        // 걸그룹 멤버 저장 리스트 생성
        ArrayList<ArrayList<String>> names = new ArrayList<>();
        for (int i = 0; i < groupCnt; i++)
            names.add(new ArrayList<>());

        // 그룹 정보 입력
        for (int i = 0; i < groupCnt; i++) {
            String groupName = br.readLine();
            members.put(groupName, String.valueOf(i));
            int memberCnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < memberCnt; j++) {
                String name = br.readLine();
                members.put(name, groupName);
                names.get(i).add(name);
            }
        }

        // 문제, 종류 입력
        for(int i=0; i<problemCnt; i++) {
            String problem = br.readLine();
            int kind = Integer.parseInt(br.readLine());

            // 0 (팀 이름) -> 멤버
            if(kind==0) {
                ArrayList<String> result = names.get(Integer.parseInt(members.get(problem)));
                Collections.sort(result);
                for(String data: result)
                    sb.append(data).append("\n");
            }

            // 1 (멤버 이름) -> 그룹명
            else {
                sb.append(members.get(problem)).append("\n");
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}