import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// Clock 클래스
class Clock implements Comparable<Clock> {
    String time;
    double angle;

    public Clock(String time, double angle) {
        this.time = time;
        this.angle = angle;
    }

    @Override
    public int compareTo(Clock other) {
        if(this.angle == other.angle) {
            return this.time.compareTo(other.time);
        }

        return Double.compare(this.angle, other.angle);
    }
}

public class Main {

    // 시간을 각도로 변환
    public static double getAngle(String time) {
        
        // 시, 분 분리
        String[] hourAndMinute = time.split(":");

        // 각도 변환을 위한 타입 변경
        double hour = Double.parseDouble(hourAndMinute[0]);
        double minute = Double.parseDouble(hourAndMinute[1]);

        // 12시간 기준으로 변환
        if(hour > 12) {
            hour -= 12;
        }

        // 시침 각도
        hour = hour * 30 + 0.5 * minute;

        // 분침 각도
        minute = minute * 6;

        // 시침과 분침 사이 최소 각도
        double differenceAngleHourAndMinute1 = Math.abs(minute - hour);
        double differenceAngleHourAndMinute2 = 360 - differenceAngleHourAndMinute1;

        return Math.min(differenceAngleHourAndMinute1, differenceAngleHourAndMinute2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=0; caseNum<caseCount; caseNum++) {

            // 시간 저장 배열 생성
            Clock[] clocks = new Clock[5];

            // 시간 입력
            st = new StringTokenizer(br.readLine());
            for(int index=0; index<5; index++) {
                String time = st.nextToken();
                double angle = getAngle(time);
                clocks[index] = new Clock(time, angle);
            }

            // 정렬
            Arrays.sort(clocks);
            
            // 결과 출력
            System.out.println(clocks[2].time);
        }
    }
}