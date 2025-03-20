import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 입력
    public static StringTokenizer st;

    // 결과, 사람 수, 파티 수, 진실을 아는 사람 수
    public static int answer, saramCount, partyCount, truthCount;

    // 파티 리스트
    public static ArrayList<ArrayList<Integer>> parties;

    // 집합 배열
    public static int[] parent;

    // 파티 참여 여부
    public static boolean[] visited;

    // find
    public static int find(int saram) {

        // 자기 자신인 경우
        if(parent[saram]==saram)
            return saram;

        return parent[saram] = find(parent[saram]);
    }

    // union
    public static void union(int saram1, int saram2) {

        // find
        saram1 = find(saram1);
        saram2 = find(saram2);

        // union
        if(saram1<saram2) parent[saram2] = saram1;
        else parent[saram1] = saram2;
    }

    // 집합 배열 생성, 초기화 메서드
    public static void createAndInitParentArray() {
        parent = new int[saramCount+1];
        for(int index=1; index<=saramCount; index++) {
            parent[index] = index;
        }
    }

    // 파티 참여 가능 여부 배열 생성 메서드
    public static void createVisitedArray() {
        visited = new boolean[partyCount];
    }

    // 파티 리스트 생성 및 초기화 메서드
    public static void createAndInitPartiesList() {
        parties = new ArrayList<>();
        for(int index=0; index<partyCount; index++) {
            parties.add(new ArrayList<>());
        }
    }

    // 진실을 아는 사람 수 입력 메서드
    public static void inputTruthKnowingSaram(StringTokenizer st) {
        truthCount = Integer.parseInt(st.nextToken());
        for(int truth=0; truth<truthCount; truth++) {
            int truthSaram = Integer.parseInt(st.nextToken());
            union(0,truthSaram);
        }
    }

    // 결과 확인 메서드
    public static void checkVisitedResult() {
        for(int index=0; index<partyCount; index++) {
            if(!visited[index]) answer++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 사람 수, 파티 수 입력
        st = new StringTokenizer(br.readLine());
        saramCount = Integer.parseInt(st.nextToken());
        partyCount = Integer.parseInt(st.nextToken());

        // 집합 배열 생성, 초기화
        createAndInitParentArray();

        // 파티 참여 가능 여부 배열 생성
        createVisitedArray();

        // 파티 리스트 생성 및 초기화
        createAndInitPartiesList();

        // 진실을 아는 사람 수 입력
        inputTruthKnowingSaram(new StringTokenizer(br.readLine()));

        // 파티 정보 입력
        for(int party=0; party<partyCount; party++) {
            st = new StringTokenizer(br.readLine());

            // 파티 참여 수 입력
            int truthSaramCount = Integer.parseInt(st.nextToken());

            // 파티 참여 사람
            int firstSaram = Integer.parseInt(st.nextToken());
            if(find(firstSaram)==0) visited[party] = true;
            parties.get(party).add(firstSaram);

            // 파티 참여 인원 정보 입력
            for(int saramIndex=1; saramIndex<truthSaramCount; saramIndex++) {

                // 파티 참여 사람
                int partySaram = Integer.parseInt(st.nextToken());

                // 진실을 아는 사람인 경우
                if(find(partySaram)==0) visited[party] = true;

                // 합치기
                union(firstSaram,partySaram);
                parties.get(party).add(partySaram);
            }
        }

        // 변경이 없을 때까지 반복
        while(true) {

            boolean flag = false;

            // 파티 순회
            for(int index=0; index<parties.size(); index++) {

                // 파티 참여가 가능한 경우
                if(!visited[index]) {

                    // 파티 참여 사람
                    int firstSaram = parties.get(index).get(0);
                    if(find(firstSaram)==0) visited[index] = true;

                    // 파티 참여 인원 정보 입력
                    for(int saramIndex=1; saramIndex<parties.get(index).size(); saramIndex++) {

                        // 파티 참여 사람
                        int partySaram = parties.get(index).get(saramIndex);

                        // 진실을 아는 사람인 경우
                        if(find(partySaram)==0) {
                            visited[index] = true;
                            flag = true;
                        }

                        // 합치기
                        union(firstSaram,partySaram);
                    }
                }
            }

            // 변경이 없는 경우
            if(!flag) break;
        }

        // 결과 확인
        checkVisitedResult();

        // 결과 출력
        System.out.println(answer);
    }
}