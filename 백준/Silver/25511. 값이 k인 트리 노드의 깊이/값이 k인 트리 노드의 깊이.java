import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 결과, 정점 개수, 목표 수
    public static int answer, nodeCount, targetNum;

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Integer>> relations;

    // 깊이 정보 배열
    public static int[] deepLevel;

    // 깊이 확인 메서드
    public static void solve(int node, int deep) {
        deepLevel[node] = deep;
        for(int index=0; index<relations.get(node).size(); index++) {
            int connectedNode = relations.get(node).get(index);
            solve(connectedNode,deep+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 정점 개수, 목표 수 입력
        st = new StringTokenizer(br.readLine());
        nodeCount = Integer.parseInt(st.nextToken());
        targetNum = Integer.parseInt(st.nextToken());

        // 관계 정보 리스트 생성
        relations = new ArrayList<>();
        for(int index=0; index<nodeCount; index++) {
            relations.add(new ArrayList<>());
        }

        // 관계 정보 입력
        for(int index=0; index<nodeCount-1; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            relations.get(from).add(to);
        }

        // 깊이 정보 배열 생성
        deepLevel = new int[nodeCount];
        Arrays.fill(deepLevel, -1);

        // 깊이 확인
        solve(0,0);

        // 각 노드 숫자 부여
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<nodeCount; index++) {
            int number = Integer.parseInt(st.nextToken());
            if(targetNum == number) {
                answer = deepLevel[index];
                break;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}