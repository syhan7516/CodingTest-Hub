import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    // 결과, 클래스 개수, 클래스 번호
    public static int answer, classCount, classNum;

    // 클래스 번호 저장 해시 맵
    public static Map<String,Integer> classNums;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 클래스 저장 메서드
    public static void classSaveToMap(String classNode) {
        if(!classNums.containsKey(classNode)) {
            classNums.put(classNode, classNum++);
        }
    }

    // 탐색 메서드
    public static void solve(int classNode, int targetParent) {

        // 형변환이 가능한 경우
        if(classNode == targetParent) {
            answer = Math.max(answer, 1);
            return;
        }

        // 연결 클래스 확인
        for(int index=0; index<relations.get(classNode).size(); index++) {
            int connectedClassNode = relations.get(classNode).get(index);

            // 방문 처리
            solve(connectedClassNode, targetParent);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 클래스 개수 입력
        classCount = Integer.parseInt(br.readLine());

        // 해시 맵 생성
        classNums = new HashMap<>();

        // 연결 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<=classCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 연결 정보 입력
        classNum = 1;
        for(int index=0; index<classCount-1; index++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent = st.nextToken();

            // 클래스 저장
            classSaveToMap(child);
            classSaveToMap(parent);

            // 부모 저장
            int childIndex = classNums.get(child);
            int parentIndex = classNums.get(parent);
            relations.get(childIndex).add(parentIndex);
        }

        // 타켓 클래스 입력
        st = new StringTokenizer(br.readLine());
        int targetChild = classNums.get(st.nextToken());
        int targetParent = classNums.get(st.nextToken());

        // 탐색
        answer = 0;
        solve(targetChild, targetParent);
        solve(targetParent, targetChild);

        // 결과
        System.out.println(answer);
    }
}