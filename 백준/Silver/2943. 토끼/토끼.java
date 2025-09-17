import java.io.*;
import java.util.*;

public class Main {

    // 결과
    public static long answer;

    // 토끼 수, 일 수
    public static int rabbitCount, dayCount;

    // 멤버 수, 그룹 수
    public static int memberCount, groupCount;

    // 배열
    public static int[] boxes, cups;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 토끼 수, 일 수 입력
        st = new StringTokenizer(br.readLine());
        rabbitCount = Integer.parseInt(st.nextToken());
        dayCount = Integer.parseInt(st.nextToken());

        // 멤버 수, 그룹 수
        memberCount = (int)Math.sqrt(rabbitCount);
        groupCount = rabbitCount / memberCount + 1;

        // 배열 생성
        boxes = new int[rabbitCount];
        cups = new int[groupCount];

        // 성냥 정보 확인
        for(int day=0; day<dayCount; day++) {
            st = new StringTokenizer(br.readLine());
            int berry = Integer.parseInt(st.nextToken());
            int rabbitStartNum = Integer.parseInt(st.nextToken()) - 1;
            int rabbitEndNum = rabbitStartNum + berry;

            // 왼쪽 구간 확인
            answer = 0;
            while(rabbitStartNum < rabbitEndNum && rabbitStartNum % memberCount != 0) {
                boxes[rabbitStartNum]++;
                answer += boxes[rabbitStartNum];
                rabbitStartNum++;
            }

            // 오른쪽 구간 확인
            while(rabbitEndNum < rabbitCount && rabbitStartNum < rabbitEndNum && rabbitEndNum % memberCount != 0) {
                rabbitEndNum--;
                boxes[rabbitEndNum]++;
                answer += boxes[rabbitEndNum];
            }

            // 컵에 들어갈 성냥 확인
            while(rabbitStartNum < rabbitEndNum) {
                int cupIndex = rabbitStartNum / memberCount;
                cups[cupIndex]++;
                answer += cups[cupIndex];
                rabbitStartNum += memberCount;
            }

            sb.append(answer).append("\n");
        }

        // 결과 출력
        System.out.print(sb.toString());
    }
}