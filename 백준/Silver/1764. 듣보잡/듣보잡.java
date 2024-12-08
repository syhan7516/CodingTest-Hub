import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 듣도 못한 사람 수, 보도 못한 사람 수 입력
        st = new StringTokenizer(br.readLine());
        int notHeardCount = Integer.parseInt(st.nextToken());
        int notLookCount = Integer.parseInt(st.nextToken());

        // 명단 리스트 생성
        ArrayList<String> nameList = new ArrayList<>();

        // 명단 해시 생성
        HashMap<String,Boolean> nameMap = new HashMap<>();

        // 듣도 못한 사람, 보도 못한 사람 정보 입력
        for(int heard=0; heard<notHeardCount; heard++) {
            String name = br.readLine();
            nameMap.put(name,true);
        }

        for(int look=0; look<notLookCount; look++) {
            String name = br.readLine();
            if(nameMap.containsKey(name)) {
                nameList.add(name);
            }
        }

        // 결과 저장, 출력
        Collections.sort(nameList);
        sb.append(nameList.size()).append("\n");
        for(String name: nameList) sb.append(name).append("\n");
        System.out.println(sb.toString());
    }
}