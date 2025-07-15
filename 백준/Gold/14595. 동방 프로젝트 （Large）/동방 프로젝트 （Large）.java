import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 결과, 방 개수, 행동 수
    public static int answer, roomCount, actCount;

    // 그룹 정보 배열
    public static int[] groups;

    // find
    public static int find(int room) {
        if(groups[room] == room) {
            return room;
        }

        return groups[room] = find(groups[room]);
    }

    // find
    public static void union(int room1, int room2) {
        room1 = find(room1);
        room2 = find(room2);

        if(room1<room2) groups[room1] = room2;
        else groups[room2] = room1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 방 개수, 행동 수 입력
        roomCount = Integer.parseInt(br.readLine());
        actCount = Integer.parseInt(br.readLine());

        // 그룹 정보 배열 생성 및 초기화
        groups = new int[roomCount+1];
        for(int room=1; room<=roomCount; room++) {
            groups[room] = room;
        }

        // 행동 정보 입력
        for(int act=0; act<actCount; act++) {
            st = new StringTokenizer(br.readLine());
            int startRoom = Integer.parseInt(st.nextToken());
            int endRoom = Integer.parseInt(st.nextToken());
            union(startRoom,endRoom);
        }

        // 방 확인
        answer = 1;
        int startRoom = 1;
        int endRoom = groups[startRoom];
        for(int room=2; room<=roomCount; room++) {

            if(groups[room]<=endRoom) continue;
            
            if(room<=endRoom && groups[room]>endRoom) {
                endRoom = groups[room];
            }

            if(room>endRoom) {
                startRoom = room;
                endRoom = groups[room];
                answer++;
            }
        }

        // 결과 출력
        System.out.println(answer);
    }
}