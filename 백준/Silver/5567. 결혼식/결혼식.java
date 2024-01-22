import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 동기 수, 결과
    public static int cnt, answer;

    // 방문 여부 배열
    public static boolean vistied[];

    // 동기 연관 관계 리스트
    public static ArrayList<ArrayList<Integer>> list;

    // 초대 수 구하기 메서드
    static void solve() {

        // 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 상근이 처리
        vistied[1] = true;
        queue.offer(1);

        // 깊이
        for(int i=0; i<2; i++) {

            int size = queue.size();

            while(size-->0) {

                // 현재 친구
                int current = queue.poll();

                // 친구의 친구 확인
                for(int j=0; j<list.get(current).size(); j++) {

                    // 미방문 친구인 경우
                    if(!vistied[list.get(current).get(j)]) {
                        vistied[list.get(current).get(j)] = true;
                        queue.offer(list.get(current).get(j));
                        answer++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 동기 수 입력
        cnt = Integer.parseInt(br.readLine());

        // 리스트 길이 입력
        int listLen = Integer.parseInt(br.readLine());

        // 리스트 생성
        list = new ArrayList<>();
        for(int i=0; i<=cnt; i++)
            list.add(new ArrayList<>());

        // 관계 입력
        for(int i=0; i<listLen; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }

        // 초대 수 구하기
        vistied = new boolean[cnt+1];
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}