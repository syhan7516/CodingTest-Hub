import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 차수얻기 함수
    static int getZeroDegree(int degree[], boolean visted[], int personCnt) {
        for(int n=1; n<=personCnt; n++) {
            if(degree[n]==0 && visted[n]==false)
                return n;
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정렬 결과 리스트
        ArrayList<Integer> result = new ArrayList<>();

        // 사람 수 입력, 비교 수 입력
        int personCnt = Integer.parseInt(st.nextToken());
        int compareCnt = Integer.parseInt(st.nextToken());

        // 연결된 노드 정보 리스트
        ArrayList<ArrayList<Integer>> node = new ArrayList<>();
        for(int idx=0; idx<personCnt+1; idx++)
            node.add(new ArrayList<>());

        // 방문 여부 배열
        boolean visited[] = new boolean[personCnt+1];
        Arrays.fill(visited,false);

        // 진입 차수 정보 배열
        int degree[] = new int[personCnt+1];
        Arrays.fill(degree,0);

        // 비교 정보
        for(int idx=0; idx<compareCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            int startNode = Integer.parseInt(st.nextToken());
            int endNode = Integer.parseInt(st.nextToken());
            node.get(startNode).add(endNode);
            degree[endNode] += 1;
        }

        // 정렬
        int curNode = getZeroDegree(degree,visited,personCnt);
        while(result.size()!=personCnt) {
            for(int a=0; a<node.get(curNode).size(); a++) {
                int connectNode = node.get(curNode).get(a);
                degree[connectNode] -= 1;
            }

            visited[curNode] = true;
            result.add(curNode);
            curNode = getZeroDegree(degree,visited,personCnt);
        }

        // 결과 출력
        for(int element: result)
            System.out.print(element+" ");
        System.out.println();
    }
}