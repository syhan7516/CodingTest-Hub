import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    // 노드 수, 관계 수, 결과, 찾을 두 노드
    public static int nodeCnt, relCnt, answer, findA, findB;

    // 연결 관계 리스트
    public static ArrayList<ArrayList<Integer>> relation;

    // 조상을 담을 리스트
    public static ArrayList<Integer> aList, bList;

    // 공통 조상 리스트 조회 메서드
    static void find(int node, ArrayList<Integer> list) {

        // 자기 자신 추가
        list.add(node);

        // 부모가 있는 경우
        if(!relation.get(node).isEmpty())
            find(relation.get(node).get(0),list);
    }

    // 공통 조상 찾기 메서드
    static void solve() {

        // 조상을 담을 리스트 생성
        aList = new ArrayList<>();
        bList = new ArrayList<>();
        
        // 조상 찾기
        find(findA,aList);
        find(findB,bList);
        
        // 더 높은 조상을 앞으로 배치
        Collections.reverse(aList);
        Collections.reverse(bList);

        // 조상 탐색
        int index = 0;

        while(index<aList.size() && index<bList.size()) {

            // 조상 가져오기
            int a = aList.get(index);
            int b = bList.get(index);

            // 같은 경우
            if(a==b)
                answer = aList.get(index);

            // 다른 경우
            else return;

            // 인덱스 증가
            index++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=1; caseIdx<=caseNum; caseIdx++) {

            // 노드 수 입력
            nodeCnt = Integer.parseInt(br.readLine());

            // 관계 리스트 생성
            relation = new ArrayList<>();
            for (int i = 0; i <= nodeCnt; i++)
                relation.add(new ArrayList<>());

            // 관계 수 입력
            relCnt = nodeCnt-1;

            // 관계 정보 입력
            for (int i = 0; i <relCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());
                relation.get(child).add(parent);
            }

            // 찾을 두 노드 입력
            st = new StringTokenizer(br.readLine());
            findA = Integer.parseInt(st.nextToken());
            findB = Integer.parseInt(st.nextToken());

            // 공통 조상 찾기
            answer = -1;
            solve();

            // 결과 저장
            sb.append(answer).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}