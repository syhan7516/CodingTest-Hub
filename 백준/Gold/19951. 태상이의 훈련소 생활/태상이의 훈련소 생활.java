import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 칸 수, 조교 수
    public static int areaCount, trainerCount;

    // 구역 배열, 누적 배열
    public static int ground[], sum[];

    // 구역, 누적 배열 생성 메서드
    public static void createArray() {
        ground = new int[areaCount+1];
        sum = new int[areaCount+2];
    }

    // 구역 높이 입력
    public static void inputAreaHeight(StringTokenizer st) {

        for(int index=1; index<=areaCount; index++) {
            ground[index] = Integer.parseInt(st.nextToken());
        }
    }

    // 조교 명령 입력 메서드
    public static void inputTrainerOrder(StringTokenizer st) {
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        sum[start] += height;
        sum[end+1] += -height;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 칸, 조교 수 입력
        st = new StringTokenizer(br.readLine());
        areaCount = Integer.parseInt(st.nextToken());
        trainerCount = Integer.parseInt(st.nextToken());

        // 구역, 누적 배열 생성
        createArray();

        // 구역 높이 입력
        inputAreaHeight(new StringTokenizer(br.readLine()));

        // 조교 명령 입력
        for(int order=1; order<=trainerCount; order++) {
            inputTrainerOrder(new StringTokenizer(br.readLine()));
        }

        // 흙 파기
        int currentHeightSum = 0;
        for(int index=1; index<ground.length; index++) {

            // 명령이 있었던 경우
            if(sum[index]!=0)
                currentHeightSum += sum[index];

            // 결과 저장
            sb.append(ground[index]+currentHeightSum).append(" ");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}