import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 선수 클래스
class Player implements Comparable<Player> {
    int position;
    int ability;

    public Player(int position, int ability) {
        this.position = position;
        this.ability = ability;
    }

    @Override
    public int compareTo(Player other) {
        return other.ability - this.ability;
    }
}

public class Main {

    // 팀 가치, 선수 수, 기간
    public static int answer, playerCount, term;

    // 선발 선수 배열
    public static Player[] players;

    // 우선 순위 큐
    public static PriorityQueue<Player>[] queue;

    // 선수 선발 메서드
    public static void selectBestPlayers() {
        for(int index=1; index<queue.length; index++) {

            // 대기 선수가 존재할 경우
            if(!queue[index].isEmpty()) {

                if(players[index].ability < queue[index].peek().ability) {
                    Player player = queue[index].poll();
                    answer -= players[index].ability;

                    if(players[index].position == index) {
                        queue[index].offer(players[index]);
                    }

                    players[index] = player;
                    answer += player.ability;
                }
            }
        }
    }

    // 가치 하락 메서드
    public static void degradeBestPlayersAbility() {
        for(int index=1; index<players.length; index++) {
            if(players[index].ability > 0) {
                players[index].ability--;
                answer--;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 선수 수, 기간 입력
        st = new StringTokenizer(br.readLine());
        playerCount = Integer.parseInt(st.nextToken());
        term = Integer.parseInt(st.nextToken());

        // 선발 선수 배열 생성
        players = new Player[12];
        for(int index=0; index<players.length; index++) {
            players[index] = new Player(-1, 0);
        }

        // 우선 순위 큐 생성
        queue = new PriorityQueue[12];
        for(int index=1; index<queue.length; index++) {
            queue[index] = new PriorityQueue<>();
        }

        // 선수 정보 입력
        for(int index=0; index<playerCount; index++) {
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int ability = Integer.parseInt(st.nextToken());
            queue[position].offer(new Player(position, ability));
        }

        while(term-->0) {

            // 선수 선발
            selectBestPlayers();

            // 가치 하락
            degradeBestPlayersAbility();

            // 선수 선발
            selectBestPlayers();
        }

        // 결과 출력
        System.out.println(answer);
    }
}