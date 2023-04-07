import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 사람의 수, 파티의 수, 진실을 아는 사람 수
    public static int N, partyCnt, truthCnt;
    // 대표 번호 테이블
    public static int parent[];
    // 파티 정보 리스트
    public static ArrayList<ArrayList<Integer>> party;

    // 결과
    public static int result;

    // Find 함수 정의
    static int parentFind(int node) {
        // 종료 조건
        if(parent[node] == node)
            return node;

        // 대표 번호와 자신의 번호가 다를 경우
        return parent[node] = parentFind(parent[node]);
    }

    // Union 함수 정의
    static void union(int firNum, int secNum) {
        int rootFirNum = parentFind(firNum);
        int rootSecNum = parentFind(secNum);

        // 작은 수를 가진 대표 번호의 집합에 속하기
        if(rootFirNum<rootSecNum)
            parent[rootSecNum] = rootFirNum;
        else
            parent[rootFirNum] = rootSecNum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사람의 수, 파티의 수 입력
        N = Integer.parseInt(st.nextToken());
        partyCnt = Integer.parseInt(st.nextToken());

        // 진실을 아는 사람과 그 수 입력
        st = new StringTokenizer(br.readLine());
        truthCnt = Integer.parseInt(st.nextToken());

        // 대표 번호 테이블 선언 & 초기화
        parent = new int[N+2];
        for(int p=0; p<=N+1; p++)
            parent[p] = p;

        // 진실을 아는 사람이 존재할 경우
        if(truthCnt!=0) {
            for(int t=0; t<truthCnt; t++) {
                int num = Integer.parseInt(st.nextToken());
                // 진실을 아는 사람 그룹
                union(0,num);
            }
        }

        // 파티 정보 입력
        party = new ArrayList<>();
        for(int a=0; a<partyCnt; a++) {

            // 해당 파티 인원 수 입력
            st = new StringTokenizer(br.readLine());
            int entranceCnt = Integer.parseInt(st.nextToken());
            party.add(new ArrayList<>());

            // 해당 파티 참여 인원 입력
            for(int b=0; b<entranceCnt; b++) {
                int h = Integer.parseInt(st.nextToken());
                party.get(a).add(h);

                // 진실을 아는 사람인지 확인
                union(N+1,h);
            }

            // 집합 초기화
            parent[N+1] = N+1;
        }

        // 모든 참여자 재확인
        for(int p=1; p<=N; p++)
            parentFind(p);

        // 파티 확인
        for(int a=0; a<party.size(); a++) {

            // 진실을 아는 사람 포함 여부
            boolean flag = true;

            // 각 파티 확인
            for(int b=0; b<party.get(a).size(); b++) {

                // 각 파티 인원 확인
                int h = party.get(a).get(b);

                // 진실을 아는 사람이 존재할 경우
                if(parent[h]==0) {
                    flag = false;
                    break;
                }
            }

            // 진실을 아는 사람이 없을 경우
            if(flag) {
                result += 1;
            }
        }

        // 결과 출력
        System.out.println(result);
    }
}