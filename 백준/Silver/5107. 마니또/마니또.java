import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    // 결과, 인원 수
    public static int answer, saramCount;

    // 해시 맵
    public static HashMap<String, String> manitos;

    // 인덱스 매핑 해시 맵
    public static HashMap<String, Integer> indexes;

    // 방문 여부 배열
    public static boolean[] visited;

    // 이름 리스트
    public static ArrayList<String> names;

    // 연결 고리 확인 메서드
    public static void solve(int index) {
        while(!visited[index]) {
            visited[index] = true;
            String target = manitos.get(names.get(index));
            index = indexes.get(target);
        }
    }

    // 이름 저장 메서드
    public static void saveName(String name) {
        if(names.contains(name)) return;
        names.add(name);
        indexes.put(name, names.size()-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 케이스 수행
        int caseNum = 1;
        while(true) {

            // 인원 수 입력
            saramCount = Integer.parseInt(br.readLine());

            // 인원 수가 0명인 경우
            if(saramCount == 0) break;

            // 마니또 해시 생성
            manitos = new HashMap<>();

            // 인덱스 매핑 해시 생성
            indexes = new HashMap<>();

            // 이름 배열 생성
            names = new ArrayList<>();

            // 이름 입력
            for(int index=0; index<saramCount; index++) {
                st = new StringTokenizer(br.readLine());
                String fromName = st.nextToken();
                String toName = st.nextToken();
                manitos.put(fromName, toName);

                // 이름 저장
                saveName(fromName);
                saveName(toName);
            }

            // 방문 여부 배열 생성
            visited = new boolean[names.size()];

            // 연결 고리 확인
            answer = 0;
            for(int index=0; index<saramCount; index++) {
                if(!visited[index]) {
                    solve(index);
                    answer++;
                }
            }

            // 결과 저장
            sb.append(caseNum++).append(" ").append(answer).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}