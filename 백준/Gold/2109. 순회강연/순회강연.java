import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

// 강연 클래스
class Lecture {

    int day;
    int money;

    public Lecture(int day, int money) {
        this.day = day;
        this.money = money;
    }
}

public class Main {

    // 결과, 강연 개수
    public static int answer, lectureCnt;

    // 강연 배열
    public static Lecture[] lectures;

    // 강연 일정 배열
    public static boolean days[];

    // 강연 순회 메서드
    public static void solve() {

        // 강연 확인
        for(int i=0; i<lectures.length; i++) {

            // 강의 정보
            int day = lectures[i].day;
            int money = lectures[i].money;

            // 빈 일정 확인
            for(int j=day; j>0; j--) {
                if(!days[j]) {
                    days[j] = true;
                    answer += money;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 강연 개수 입력
        lectureCnt = Integer.parseInt(br.readLine());

        // 강연 배열 생성
        lectures = new Lecture[lectureCnt];

        // 강연 정보 입력
        for(int i=0; i<lectureCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int money = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(day,money);
        }

        // 강연 비용 기준 정렬
        Arrays.sort(lectures, (a,b) -> b.money - a.money);

        // 강연 일정 배열 생성
        days = new boolean[10001];

        // 강연 순회
        answer = 0;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}