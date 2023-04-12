import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static StringBuilder sb = new StringBuilder();

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Integer>> relation;
    // 방문 정보 배열
    public static boolean visited[];
    // 해킹 수 결과 배열
    public static int result[];
    // 사람 수, 신뢰 관계 수, 해킹 수, 최대 해킹 수
    public static int saramCnt, relCnt, cnt, maxHack;

    // bfs
    static void bfs(int node) {
        // 기본 셋팅
        Queue<Integer> nodes = new LinkedList<>();
        visited[node] = true;
        nodes.offer(node);

        // 해킹 시작
        while(!nodes.isEmpty()) {
            int curNode = nodes.poll();
            for(int n : relation.get(curNode)) {
                int checkNode = n;
                // 해킹 여부 확인
                if(!visited[checkNode]) {
                    visited[checkNode] = true;
                    nodes.offer(checkNode);
                    cnt += 1;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사람 수, 신뢰 관계 수 입력
        saramCnt = Integer.parseInt(st.nextToken());
        relCnt = Integer.parseInt(st.nextToken());

        // 선언 & 생성
        relation = new ArrayList<>();
        result = new int[saramCnt+1];
        for(int r=0; r<=saramCnt; r++) {
            relation.add(new ArrayList<>());
        }

        // 관계 정보 입력
        for(int r=0; r<relCnt; r++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            relation.get(B).add(A);
        }

        // 각 컴퓨터 기준 해킹 시작
        maxHack = -1;
        for(int r=1; r<=saramCnt; r++) {
            visited = new boolean[saramCnt+1];
            cnt = 0;
            bfs(r);

            // 해당 컴퓨터 해킹 수 저장
            result[r] = cnt;
            // 최대 해킹 수 갱신
            maxHack = Math.max(maxHack, cnt);
        }

        // 결과 확인
        for(int n=1; n<=saramCnt; n++) {
            if(maxHack==result[n])
                sb.append(n+" ");
        }
        System.out.println(sb.toString());
    }
}