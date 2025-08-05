import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    // 결과, 뉴런 개수, 시냅스 개수
    public static int answer, neuronCount, synapseCount;

    // 그룹 배열
    public static int[] parent;

    // 그룹 정보 셋
    public static HashSet<Integer> set;

    // find
    public static int find(int num) {
        if(parent[num] == num) {
            return num;
        }

        return parent[num] = find(parent[num]);
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 뉴런 개수, 시냅스 개수 입력
        st = new StringTokenizer(br.readLine());
        neuronCount = Integer.parseInt(st.nextToken());
        synapseCount = Integer.parseInt(st.nextToken());

        // 그룹 배열 생성 및 초기화
        parent = new int[neuronCount+1];
        for(int index=1; index<=neuronCount; index++) {
            parent[index] = index;
        }

        // 시냅스 정보 입력
        for(int index=0; index<synapseCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            // 사이클인 경우 - 끊기 연산
            if(find(from) == find(to)) {
                answer++;
            }

            // 사이클이 아닌 경우 - 뉴런 연결
            else union(from, to);
        }

        // 그룹 정보 셋 생성
        set = new HashSet<>();

        // 그룹 수 확인
        for(int index=1; index<=neuronCount; index++) {
            set.add(find(index));
        }

        // 결과 출력
        answer += set.size() == 1 ? 0 : set.size()-1;
        System.out.println(answer);
    }
}