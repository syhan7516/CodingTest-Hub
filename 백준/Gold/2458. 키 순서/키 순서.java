import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    // 학생 수, 관계 수, 자신보다 작은 사람 수, 자신보다 큰 사람 수, 확인된 수, 결과
    public static int studentCnt, relCnt, tallCnt, smallCnt, cnt, answer;

    // 키 큰 관계 리스트, 키 작은 관계 리스트
    public static ArrayList<ArrayList<Integer>> taller, smaller;

    // 학생 확인 여부 배열
    public static boolean visited[];

    // 자신보다 큰 학생 수 구하기 메서드
    static void getTallerCnt(int student) {

        // 해당 학생의 관계 확인
        for(int r=0; r<taller.get(student).size(); r++) {

            // 아직 확인 안된 학생인 경우
            if(!visited[taller.get(student).get(r)]) {
                cnt++;
                visited[taller.get(student).get(r)] = true;
                getTallerCnt(taller.get(student).get(r));
            }
        }
    }
    
    // 자신보다 작은 학생 수 구하기 메서드
    static void getSmallerCnt(int student) {

        // 해당 학생의 관계 확인
        for(int r=0; r<smaller.get(student).size(); r++) {

            // 아직 확인 안된 학생인 경우
            if(!visited[smaller.get(student).get(r)]) {
                cnt++;
                visited[smaller.get(student).get(r)] = true;
                getSmallerCnt(smaller.get(student).get(r));
            }
        }
    }

    // 키 순서 확인 메서드
    static void solve() {

        // 학생 순서대로 확인
        for(int i=1; i<=studentCnt; i++) {

            tallCnt = 0;
            smallCnt = 0;

            // 자신보다 저 큰 학생수 구하기
            visited = new boolean[studentCnt+1];
            visited[i] = true;
            cnt = 0;
            getTallerCnt(i);
            int totalCnt = cnt;

            // 자신보다 더 작은 학생 수 구하기
            visited = new boolean[studentCnt+1];
            visited[i] = true;
            cnt = 0;
            getSmallerCnt(i);
            totalCnt += cnt;

            // 키 위치 확인
            if(totalCnt==studentCnt-1) answer++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 학생 수, 관계 수 입력
        st = new StringTokenizer(br.readLine());
        studentCnt = Integer.parseInt(st.nextToken());
        relCnt = Integer.parseInt(st.nextToken());

        // 관계 리스트 생성
        taller = new ArrayList<>();
        smaller = new ArrayList<>();

        // 초기화
        for(int i=0; i<=studentCnt; i++) {
            taller.add(new ArrayList<>());
            smaller.add(new ArrayList<>());
        }

        // 관계 정보 입력
        for(int i=0; i<relCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            taller.get(from).add(to);
            smaller.get(to).add(from);
        }

        // 키 순서 확인
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}