import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 플레이어 클래스
class Player implements Comparable<Player> {
    int level;
    String name;

    public Player(int level, String name) {
        this.level = level;
        this.name = name;
    }

    @Override
    public int compareTo(Player other) {
        return this.name.compareTo(other.name);
    }
}

// 방 클래스
class Room {
    int minLevel;
    int maxLevel;
    int capacity;
    ArrayList<Player> players = new ArrayList<>();

    public Room(int level, int capacity) {
        this.minLevel = Math.max(level-10, 1);
        this.maxLevel = Math.min(level+10, 500);
        this.capacity = capacity;
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean isMaxCapacity() {
        return this.capacity == this.players.size();
    }

    public boolean isPermit(int level) {
        return this.minLevel <= level && level <= this.maxLevel;
    }
}

public class Main {

    // 플레이어 수, 방 정원
    public static int playerCount, maximumCapacity;

    // 방 리스트
    public static ArrayList<Room> rooms;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 플레이어 수, 방 정원 입력
        st = new StringTokenizer(br.readLine());
        playerCount = Integer.parseInt(st.nextToken());
        maximumCapacity = Integer.parseInt(st.nextToken());

        // 방 정보 리스트 생성
        rooms = new ArrayList<>();

        // 플레이어 정보 입력
        for(int index=0; index<playerCount; index++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            // 게임 방 순회
            boolean isPermit = false;
            for(int roomIndex=0; roomIndex<rooms.size(); roomIndex++) {

                // 방 정보
                Room room = rooms.get(roomIndex);

                // 방이 가득 찬 경우
                if(room.isMaxCapacity()) continue;

                // 입장이 불가능한 경우
                if(!room.isPermit(level)) continue;

                // 입장
                room.addPlayer(new Player(level, name));
                isPermit = true;
                break;
            }

            // 방 참여를 못한 경우
            if(!isPermit) {
                Room room = new Room(level, maximumCapacity);
                room.addPlayer(new Player(level, name));
                rooms.add(room);
            }
        }

        // 결과 저장
        for(int roomIndex=0; roomIndex<rooms.size(); roomIndex++) {
            Room room = rooms.get(roomIndex);
            Collections.sort(room.players);

            // 방이 가득 찬 경우
            if(room.isMaxCapacity()) sb.append("Started!").append("\n");
            else sb.append("Waiting!").append("\n");

            // 참여 인원 저장
            for(Player player : room.players) {
                sb.append(player.level).append(" ").append(player.name).append("\n");
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}