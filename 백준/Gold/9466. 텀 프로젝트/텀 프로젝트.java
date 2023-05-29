import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 학생 수
    public static int studentCnt;
    // 학생 관계도 배열
    public static int student[];
    // 확인 배열
    public static boolean visited[];
    public static boolean finished[];
    // 결과 노드 수
    public static int cnt;

    // dfs
    static void dfs(int studentNum) {
        // 방문 처리
        visited[studentNum] = true;

        // 선택 학생
        int select = student[studentNum];

        // 방문하지 않은 경우
        if(!visited[select])
            dfs(select);

        // 완전 방문 처리가 아닌 경우
        else if(!finished[select]) {
            for(int f=select; f!=studentNum; f=student[f]) {
                cnt++;
            }

            cnt++;
        }

        // 완전 방문 완료 처리
        finished[studentNum] = true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            cnt = 0;

            // 학생 수 입력
            studentCnt = Integer.parseInt(br.readLine());

            // 학생 관계 입력
            student = new int[studentCnt+1];
            st = new StringTokenizer(br.readLine());
            for(int s=1; s<=studentCnt; s++) {
                student[s] = Integer.parseInt(st.nextToken());
            }

            // 확인
            visited = new boolean[studentCnt+1];
            finished = new boolean[studentCnt+1];
            for(int s=1; s<=studentCnt; s++) {
                // 방문하지 않은 경우
                if(!visited[s]) dfs(s);
            }

            // 결과 저장
            int result = studentCnt-cnt;
            sb.append(result+"\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}