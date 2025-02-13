import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 선물 클래스
class Present implements Comparable<Present> {
    int time;
    char color;

    public Present(int time, char color) {
        this.time = time;
        this.color = color;
    }

    @Override
    public int compareTo(Present other) {
        if(this.time == other.time)
            return this.color - other.color;

        return this.time - other.time;
    }
}

public class Main {

    // 결과
    public static StringBuilder sb;

    // 포장 시간, 손님 수, 포장이 끝나는 시간
    public static int smTime, jsTime, clientCount, smPresentEndTime, jsPresentEndTime;

    // 상민, 지수 포장한 선물 리스트
    public static ArrayList<Integer> smPresents, jsPresents;

    // 선물 순서 저장 우선 순위 큐
    public static PriorityQueue<Present> queue;

    // 끝나는 시간보다 주문 시간이 더 빠른지 확인하는 메서드
    public static boolean isPossiblePresent(int orderTime, int presentEndTime) {
        return orderTime >= presentEndTime;
    }

    // 포장 색깔 파랑인지 확인하는 메서드
    public static boolean isBlue(char color) {
        return color == 'B';
    }

    // 포장 색깔 빨강인지 확인하는 메서드
    public static boolean isRed(char color) {
        return color == 'R';
    }

    // 선물 포장 메서드
    public static int makePresent(int orderTime, char orderColor) {

        if(isBlue(orderColor)) {
            if(isPossiblePresent(orderTime,smPresentEndTime)) {
                queue.offer(new Present(orderTime,orderColor));
            }

            else {
                orderTime = smPresentEndTime;
                queue.offer(new Present(orderTime,orderColor));
            }

            orderTime += smTime;
            smPresentEndTime = orderTime;
        }

        else {
            if(isPossiblePresent(orderTime,jsPresentEndTime))
                queue.offer(new Present(orderTime,orderColor));

            else {
                orderTime = jsPresentEndTime;
                queue.offer(new Present(orderTime,orderColor));
            }

            orderTime += jsTime;
            jsPresentEndTime = orderTime;
        }

        return orderTime;
    }

    // 포장 정보 저장 메서드
    public static void checkPresent(ArrayList<Integer> presents) {

        // 개수 저장
        sb.append(presents.size()).append("\n");

        // 선물 정보 저장
        for(int prsent=0; prsent<presents.size(); prsent++)
            sb.append(presents.get(prsent)).append(" ");
        sb.append("\n");
    }

    // 포장 정보 저장 메서드
    public static void solve() {

        // 포장 확인
        int order = 1;
        while(!queue.isEmpty()) {

            // 선물 꺼내기
            Present present = queue.poll();

            // 색깔이 파랑인 경우
            if(isBlue(present.color))
                smPresents.add(order++);

            // 색깔이 빨강인 경우
            else jsPresents.add(order++);
        }

        // 상민이 포장 정보 저장
        checkPresent(smPresents);

        // 지수 포장 정보 저장
        checkPresent(jsPresents);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 포장 시간, 손님 수 입력
        st = new StringTokenizer(br.readLine());
        smTime = Integer.parseInt(st.nextToken());
        jsTime = Integer.parseInt(st.nextToken());
        clientCount = Integer.parseInt(st.nextToken());

        // 선물 순서 저장 우선 순위 큐 생성
        queue = new PriorityQueue<>();

        // 포장이 끝나는 시간
        smPresentEndTime = 0;
        jsPresentEndTime = 0;

        // 포장 정보 입력
        for(int client=0; client<clientCount; client++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char color = st.nextToken().charAt(0);
            int presentCount = Integer.parseInt(st.nextToken());

            for(int index=0; index<presentCount; index++)
                time = makePresent(time,color);
        }

        // 포장한 선물 리스트 생성
        smPresents = new ArrayList<>();
        jsPresents = new ArrayList<>();

        // 포장 확인
        sb = new StringBuilder();
        solve();

        // 결과 확인
        System.out.println(sb.toString());
    }
}