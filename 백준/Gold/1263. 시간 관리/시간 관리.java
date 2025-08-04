import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 업무 클래스
class Work {
    int during;
    int deadLine;

    public Work(int during, int deadLine) {
        this.during = during;
        this.deadLine = deadLine;
    }
}

public class Main {

    // 업무 개수
    public static int workCount;

    // 업무 배열
    public static Work[] works;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 업무 개수 입력
        workCount = Integer.parseInt(br.readLine());

        // 업무 배열 생성
        works = new Work[workCount];

        // 시간 정보 입력
        for(int index=0; index<workCount; index++) {
            st = new StringTokenizer(br.readLine());
            int during = Integer.parseInt(st.nextToken());
            int deadLine = Integer.parseInt(st.nextToken());
            works[index] = new Work(during, deadLine);
        }

        // 걸리는 시간 기준으로 오름차순 정렬
        Arrays.sort(works, (a,b) -> a.during - b.during);

        // 끝내야할 시간 기준으로 내림차순 정렬
        Arrays.sort(works, (a,b) -> b.deadLine - a.deadLine);

        // 업무 확인
        int startWorkTime = 1000000;
        for(int index=0; index<workCount; index++) {
            int during = works[index].during;
            int deadLine = works[index].deadLine;

            // 현재 업무 시간이 해당 업무 마무리 시간보다 큰 경우
            if(startWorkTime > deadLine) {
                startWorkTime = deadLine - during;
            }

            // 아닌 경우
            else {
                startWorkTime -= during;
            }
        }

        // 결과 출력
        System.out.println(startWorkTime < 0 ? -1 : startWorkTime);
    }
}