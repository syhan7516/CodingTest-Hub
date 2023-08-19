import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    // 관계 정보 리스트
    public static ArrayList<ArrayList<Integer>> contacts;

    // 데이터 길이, 시작점, 결과
    public static int dataLen, start, result[];

    // 방문 여부 배열
    public static boolean visisted[];

    // 비상 연락 수행 메서드
    static void solve() {

        // 비상 연락 큐
        Queue<Integer> queue = new LinkedList<>();

        // 시작점 처리
        queue.offer(start);
        visisted[start] = true;

        // 깊이 관리
        int depth = 0;

        // 큐가 빌 때까지 수행
        while(!queue.isEmpty()) {

            // 현재 큐 크기, 깊이 크기 증가
            int size = queue.size();
            depth++;

            // 깊이 만큼 수행
            while(size-->0) {

                // 현재 사람 정보
                int current = queue.poll();
                int curSize = contacts.get(current).size();

                // 연락하기
                for(int i=0; i<curSize; i++) {

                    // 연락받는 사람
                    int next = contacts.get(current).get(i);

                    // 연락이 안된 사람이 있는 경우
                    if(!visisted[next]) {
                        visisted[next] = true;
                        queue.offer(next);

                        // 깊이가 깊으면서 연락망 번호가 큰 경우
                        if(result[0]<depth || (result[0]==depth && result[1]<next)) {
                            result[0] = depth;
                            result[1] = next;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = 10;

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 관계 정보 리스트 생성
            contacts = new ArrayList<>();
            for(int i=0; i<=100; i++) {
                contacts.add(new ArrayList<>());
            }

            // 데이터 길이, 시작점 입력
            st = new StringTokenizer(br.readLine());
            dataLen = Integer.parseInt(st.nextToken())/2;
            start = Integer.parseInt(st.nextToken());

            // 관계 정보 입력
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<dataLen; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                contacts.get(from).add(to);
            }

            // 비상 연락 수행
            visisted = new boolean[101];
            result = new int[2];
            solve();

            // 결과 저장
            sb.append("#").append(caseIdx+1).append(" ").append(result[1]).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}