import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 과목 수, 선수 조건 수
    public static int subjectCnt, condition;

    // 과목별 학기 저장 배열
    public static int result[];

    // 연결 관계 리스트
    public static ArrayList<ArrayList<Integer>> relation;

    // 진입 차수 저장 배열
    public static int degree[];

    // 학기 계산하기 메서드
    static void solve() {

        // 선수 과목 조건 판단을 위한 큐 생성
        Queue<Integer> queue = new LinkedList<>();

        // 조건없는 과목 찾기
        for(int i=1; i<=subjectCnt; i++) {
            if(degree[i]==0) {
                queue.offer(i);
                result[i] = 1;
            }
        }

        // 학기
        int cnt = 2;

        // 선수 과목 듣기
        while(!queue.isEmpty()) {

            // 학기 구분을 위한 크기
            int size = queue.size();

            while(size-->0) {

                // 듣는 과목
                int subject = queue.poll();

                // 해당 과목이 선수 과목인 과목 확인
                for(int r=0; r<relation.get(subject).size(); r++) {

                    // 심화 과목
                    int nextSubject = relation.get(subject).get(r);
                    degree[nextSubject]--;

                    // 해당 과목을 들을 수 있는 경우
                    if(degree[nextSubject]==0) {
                        queue.offer(nextSubject);
                        result[nextSubject] = cnt;
                    }
                }
            }

            // 학기 증가
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 과목 수, 선수 조건 수
        st = new StringTokenizer(br.readLine());
        subjectCnt = Integer.parseInt(st.nextToken());
        condition = Integer.parseInt(st.nextToken());

        // 연결 관계 리스트 생성, 초기화
        relation = new ArrayList<>();
        for(int i=0; i<=subjectCnt; i++)
            relation.add(new ArrayList<>());

        // 진입 차수 배열 생성
        degree = new int[subjectCnt+1];

        // 조건 입력
        for(int i=0; i<condition; i++) {
            st = new StringTokenizer(br.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            relation.get(before).add(after);
            degree[after]++;
        }

        // 학기 계산하기
        result = new int[subjectCnt+1];
        solve();

        // 결과 저장
        StringBuilder sb = new StringBuilder();
        for(int r=1; r<=subjectCnt; r++)
            sb.append(result[r]).append(" ");

        // 결과 출력
        System.out.println(sb.toString());
    }
}