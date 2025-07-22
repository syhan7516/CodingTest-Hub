import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 친구 클래스
class Friend {
    int point;
    int speed;

    public Friend(int point, int speed) {
        this.point = point;
        this.speed = speed;
    }
}

public class Main {

    // 친구 수
    public static int friendCount;

    // 남은 시간
    public static double existTime;

    // 친구 배열
    public static Friend[] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 친구 수, 남은 시간 입력
        st = new StringTokenizer(br.readLine());
        friendCount = Integer.parseInt(st.nextToken());
        existTime = Double.parseDouble(st.nextToken());

        // 친구 배열 생성
        friends = new Friend[friendCount];

        // 친구 위치 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<friendCount; index++) {
            friends[index] = new Friend(Integer.parseInt(st.nextToken()),0);
        }

        // 친구 속도 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<friendCount; index++) {
            friends[index].speed = Integer.parseInt(st.nextToken());
        }

        // 이동 범위 확인
        double maxLeft = 0;
        double minRight = 1000000001;
        
        for(int index=0; index<friendCount; index++) {
            minRight = Math.min(minRight,Math.round((friends[index].point+friends[index].speed*existTime)*10000)/10000.0); 
            maxLeft = Math.max(maxLeft,Math.round((friends[index].point-friends[index].speed*existTime)*10000)/10000.0);
        }
        
        // 가능 여부 확인
        if(minRight>=maxLeft) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}