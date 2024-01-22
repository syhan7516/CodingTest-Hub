import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 컴퓨터 수, 연결 쌍 수, 결과
    public static int comCnt, pairCnt, answer;

    // 연결 정보 리스트
    public static ArrayList<ArrayList<Integer>> list;

    // 방문 여부 배열
    public static boolean visited[];

    // 바이러스 동작 메서드
    static void solve(int com) {

        // 바이러스 걸린 컴퓨터 처리
        answer++;
        visited[com] = true;

        // 연결된 컴퓨터 확인
        for(int i=0; i<list.get(com).size(); i++) {

            // 바이러스가 안걸린 컴퓨터인 경우
            if(!visited[list.get(com).get(i)]) {
                solve(list.get(com).get(i));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 컴퓨터 수 입력
        comCnt = Integer.parseInt(br.readLine());

        // 연결 쌍 수 입력
        pairCnt = Integer.parseInt(br.readLine());

        // 연결 정보 리스트 생성
        list = new ArrayList<>();
        for(int i=0; i<=comCnt; i++) {
            list.add(new ArrayList());
        }

        // 연결 정보 입력
        for(int i=0; i<pairCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list.get(from).add(to);
            list.get(to).add(from);
        }

        // 바이러스 동작
        visited = new boolean[comCnt+1];
        answer = 0;
        solve(1);

        // 결과 출력
        System.out.println(answer-1);
    }
}