import java.util.*;
import java.io.*;

public class Main {

    // 건물 층, 자리 수, 반전 수, 현재 층 (정수)
    public static int buildingFloor, numLen, changeCnt, current;

    // 현재 층 (문자열)
    public static String curFloor;

    // 문자열 처리 빌더
    public static StringBuilder sb;

    // 층 디스플레이
    public static boolean display[][] = {
            {true,true,true,false,true,true,true},
            {false,false,true,false,false,true,false},
            {true,false,true,true,true,false,true},
            {true,false,true,true,false,true,true},
            {false,true,true,true,false,true,false},
            {true,true,false,true,false,true,true},
            {true,true,false,true,true,true,true},
            {true,false,true,false,false,true,false},
            {true,true,true,true,true,true,true},
            {true,true,true,true,false,true,true}
    };

    // 층 문자열화 메서드
    public static String numToLetter(int number) {

        // 층 문자열화
        sb = new StringBuilder();
        sb.append(number);

        // 길이가 다른 경우
        if(sb.length()!=numLen) {

            // 붙여야하는 0 개수
            int zeroCnt = numLen-sb.length();

            // 앞에 부족한 만큼 0 추가
            for(int i=0; i<zeroCnt; i++)
                sb.insert(0,0);
        }

        return sb.toString();
    }

    // 현재 층과 다른 층 반전 수 확인 메서드
    public static int change(int next, String curFloor) {

        // 같은 층인 경우
        if(next==current) return changeCnt+1;

        // 다른 층 문자열화
        String nextFloor = numToLetter(next);

        // 반전 수
        int cnt = 0;

        // 비교
        for(int i=0; i<numLen; i++) {
            for(int j=0; j<7; j++) {
                if(display[nextFloor.charAt(i)-'0'][j]!=display[curFloor.charAt(i)-'0'][j])
                    cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 결과
        int answer = 0;

        // 건물 층, 자리 수, 반전 수, 현재 층 입력
        st = new StringTokenizer(br.readLine());
        buildingFloor = Integer.parseInt(st.nextToken());
        numLen = Integer.parseInt(st.nextToken());
        changeCnt = Integer.parseInt(st.nextToken());
        current = Integer.parseInt(st.nextToken());

        // 현재 층 문자열화
        String curFloor = numToLetter(current);

        // 각 층 확인
        for(int i=1; i<=buildingFloor; i++) {

            // 현재 층과 다른 층 반전 수 확인
            int cnt = change(i,curFloor);

            // 반전 수 최대치를 넘지 않은 경우
            if(cnt<=changeCnt)
                answer++;
        }

        // 결과 출력
        System.out.println(answer);
    }
}