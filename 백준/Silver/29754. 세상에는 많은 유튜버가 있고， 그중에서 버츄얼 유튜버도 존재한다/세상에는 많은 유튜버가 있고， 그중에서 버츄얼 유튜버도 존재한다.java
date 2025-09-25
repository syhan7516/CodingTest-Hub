import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

// 방송 클래스
class Broadcast implements Comparable<Broadcast> {
    int day;
    int time;

    public Broadcast(int day, int time) {
        this.day = day;
        this.time = time;
    }

    @Override
    public int compareTo(Broadcast other) {
        return this.day - other.day;
    }
}

public class Main {

    // 주 단위
    public static int WEEK_COUNT = 7;

    // 방송 수, 마지막 날, 마지막 주
    public static int broadcastCount, finalDay, finalWeek;

    // 결과 리스트
    public static ArrayList<String> resultNames;

    // 방송 정보 인덱스 저장 해시
    public static HashMap<String, Integer> indexes;

    // 방송 정보 저장 리스트
    public static ArrayList<ArrayList<Broadcast>> broadcasts;

    // 시간 변환 메서드 - 초
    public static int convertTimeToSecond(String time) {
        String[] hourAndMinute = time.split(":");
        int hourToSecond = Integer.parseInt(hourAndMinute[0]) * 60 * 60;
        int minuteToSecond = Integer.parseInt(hourAndMinute[1]) * 60;
        return hourToSecond + minuteToSecond;
    }

    // 방송 시간 계산 메서드
    public static int sumStartTimeAndEndTime(String startTime, String endTime) {
        return convertTimeToSecond(endTime) - convertTimeToSecond(startTime);
    }

    // 시간 변환 메서드 - 시
    public static int convertTimeToHour(int second) {
        return second / 3600;
    }

    // 조건 확인 메서드 - 주 5회, 60시간 확인
    public static boolean validateBroadCastCountAndTimeInWeek(int count, int second) {
        return count >= 5 && convertTimeToHour(second) >= 60;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 방송 수, 마지막 날 입력
        st = new StringTokenizer(br.readLine());
        broadcastCount = Integer.parseInt(st.nextToken());
        finalDay = Integer.parseInt(st.nextToken());
        finalWeek = (finalDay-1) / WEEK_COUNT;

        // 방송 정보 저장 해시 생성
        indexes = new HashMap<>();

        // 방송 정보 저장 리스트 생성
        broadcasts = new ArrayList<>();

        // 결과 리스트 생성
        resultNames = new ArrayList<>();

        // 방송 정보 입력
        for(int index=0; index<broadcastCount; index++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            String startTime = st.nextToken();
            String endTime = st.nextToken();

            // 초로 변환
            int time = sumStartTimeAndEndTime(startTime, endTime);

            // 기존에 없던 사람인 경우
            if(!indexes.containsKey(name)) {
                indexes.put(name, broadcasts.size());
                broadcasts.add(new ArrayList<>());
            }

            // 저장
            broadcasts.get(indexes.get(name)).add(new Broadcast(day, time));
        }

        // 방송 정보 확인
        for(String name: indexes.keySet()) {
            int hashIndex = indexes.get(name);
            Collections.sort(broadcasts.get(hashIndex));

            // 방송 정보
            Broadcast broadcast = broadcasts.get(hashIndex).get(0);
            boolean isReal = true;
            int week = (broadcast.day-1) / WEEK_COUNT;
            int broadcastCountWithInWeek = 1;
            int broadcastTimeWithInWeek = broadcast.time;
            
            // 첫 주에 방송을 안한 경우
            if(week != 0) continue;

            // 확인
            for(int index=1; index<broadcasts.get(hashIndex).size(); index++) {
                broadcast = broadcasts.get(hashIndex).get(index);

                // 마지막 날 이후인 경우
                if(broadcast.day > finalDay) break;

                // 주
                int currentWeek = (broadcast.day-1) / WEEK_COUNT;

                //
                if((currentWeek - week) > 1) {
                    isReal = false;
                }

                // 다른 주인 경우
                if(week != currentWeek) {

                    // 주를 뛰어넘었거나, 주 5회, 60시간이 안되는 경우
                    if((currentWeek - week) > 1 || !validateBroadCastCountAndTimeInWeek(broadcastCountWithInWeek, broadcastTimeWithInWeek)) {
                        isReal = false;
                        break;
                    }

                    week = currentWeek;
                    broadcastCountWithInWeek = 0;
                    broadcastTimeWithInWeek = 0;
                }

                broadcastCountWithInWeek++;
                broadcastTimeWithInWeek += broadcast.time;
            }

            // 진짜인 경우 마지막 주 확인
            if(isReal && week == finalWeek && validateBroadCastCountAndTimeInWeek(broadcastCountWithInWeek, broadcastTimeWithInWeek)) {
                resultNames.add(name);
            }
        }

        // 결과 정렬
        Collections.sort(resultNames);

        // 결과 저장
        if(resultNames.isEmpty()) sb.append(-1);
        else for(String name: resultNames) sb.append(name).append("\n");

        // 결과 출력
        System.out.println(sb.toString());
    }
}