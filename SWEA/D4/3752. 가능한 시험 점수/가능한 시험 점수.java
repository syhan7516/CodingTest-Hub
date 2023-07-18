import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

    // 결과, 배점 수
    public static int result, scoreCnt;
    // 배점 배열
    public static int kinds[];
    // 배점 결과
    public static HashSet<Integer> set;
    // 모든 점수 배열
    public static boolean visited[][];

    // 배점 조합
    static void solve() {

        // 점수 배점 큐
        Queue<Integer> queue = new LinkedList<>();

        // 첫 문제
        queue.offer(kinds[0]);
        queue.offer(0);
        visited[0][kinds[0]] = true;
        visited[0][0] = true;

        // 점수 확인
        for(int a=1; a<kinds.length; a++) {

            // 큐 크기
            int curSize = queue.size();

            // 크기 만큼 수행
            for(int b=0; b<curSize; b++) {
                int curScore = queue.poll();
                int nextScore = curScore+kinds[a];

                // 미방문 경우
                if(!visited[a][nextScore]) {
                    visited[a][nextScore] = true;
                    queue.offer(nextScore);
                }

                if(!visited[a][curScore]) {
                    visited[a][curScore] = true;
                    queue.offer(curScore);
                }
            }
        }

        // 점수 파악
        while(!queue.isEmpty()) {
            set.add(queue.poll());
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 배점 수 입력
            scoreCnt = Integer.parseInt(br.readLine());

            // 배점 정보 입력
            kinds = new int[scoreCnt];
            st = new StringTokenizer(br.readLine());
            for(int s=0; s<kinds.length; s++) {
                kinds[s] = Integer.parseInt(st.nextToken());
            }

            // 배점 조합
            set = new HashSet<>();
            visited = new boolean[101][10001];
            result = 0;
            solve();
            result = set.size();

            // 결과 저장
            sb.append("#"+(caseIdx+1)+" "+result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}