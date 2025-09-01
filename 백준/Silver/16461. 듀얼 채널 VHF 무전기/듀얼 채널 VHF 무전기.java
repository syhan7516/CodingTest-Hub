import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 주파수 범위
    public static final double MIN_RAGNE = 144.000;
    public static final double MAX_RAGNE = 146.000;

    // 주파수 정보
    public static double A, B, targetChannel;

    // 전략 2
    public static int upStrategy(double channel) {

        int upCount = 0;
        double upChannel = channel;
        while(upChannel != targetChannel && upCount < 6) {

            upChannel = Math.round((upChannel + 0.02) * 1000) / 1000.0;
            upCount++;

            if(upChannel > MAX_RAGNE) upChannel = MIN_RAGNE;
        }

        return upCount;
    }

    // 전략 3
    public static int downStrategy(double channel) {

        int downCount = 0;
        double downChannel = channel;
        while(downChannel != targetChannel && downCount < 6) {

            downChannel = Math.round((downChannel - 0.02) * 1000) / 1000.0;
            downCount++;

            if(downChannel < MIN_RAGNE) downChannel = MAX_RAGNE;
        }

        return downCount;
    }

    // 탐색 메서드
    public static int solve(double channel) {

        // 현재 주파수와 목표 주파수가 동일한 경우
        if(channel == targetChannel) {
            return 0;
        }

        // 전략 2
        int upCount = Math.min(Math.min(upStrategy(channel), upStrategy(A)+1), upStrategy(B)+1);

        // 전략 3
        int downCount = Math.min(Math.min(downStrategy(channel), downStrategy(A)+1), downStrategy(B)+1);

        return Math.min(upCount, downCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=0; caseNum<caseCount; caseNum++) {

            // 주파수 정보 입력
            st = new StringTokenizer(br.readLine());
            A = Double.parseDouble(st.nextToken());
            B = Double.parseDouble(st.nextToken());
            double currentChannel = st.nextToken().charAt(0) == 'A' ? A : B;
            targetChannel = Double.parseDouble(st.nextToken());

            // 탐색
            sb.append(solve(currentChannel)).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}