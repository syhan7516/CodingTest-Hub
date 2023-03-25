import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int find(int group[], int node) {
        if(group[node]==node) {
            return node;
        }
        else {
            return group[node] = find(group,group[node]);
        }
    }

    static void union(int group[], int firNode, int secNode) {
        int firNodeRoot = find(group,firNode);
        int secNodeRoot = find(group,secNode);
        group[firNodeRoot] = secNodeRoot;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 국가 수, 비행기 수
            st = new StringTokenizer(br.readLine());
            int cityCnt = Integer.parseInt(st.nextToken());
            int airPlaneCnt = Integer.parseInt(st.nextToken());

            // 각 집합 초기화
            int group[] = new int[cityCnt+1];
            for(int idx=0; idx<cityCnt+1; idx++) {
                group[idx] = idx;
            }

            // 비행기 확인
            int count = 0;
            for(int idx=0; idx<airPlaneCnt; idx++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                // 집합 확인
                if(find(group,start)!=find(group,end)) {
                    union(group,start,end);
                    count += 1;
                }
            }

            // 결과 확인
            System.out.println(count);
        }
    }
}