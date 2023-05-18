import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Human {
    private int num;
    private int cnt;

    public Human(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }

    public int getNum() {
        return num;
    }

    public int getCnt() {
        return cnt;
    }
}

public class Main {

    // 회원 인원 수
    public static int human;
    // 회원 인원 관계 리스트
    public static ArrayList<ArrayList<Integer>> relation;
    // 방문 여부 배열
    public static boolean visited[];
    // 점수
    public static int score;
    // 각 후보 점수 저장 배열, 결과
    public static int [] scores, result;

    // bfs
    static void bfs(int client) {
        Queue<Human> humans = new LinkedList<>();
        score = 0;
        visited = new boolean[human+1];
        int memberCnt = human;
        humans.offer(new Human(client,0));
        visited[client] = true;
        memberCnt--;

        while(!humans.isEmpty()) {
            // 현재 인원 확인
            Human curHuman = humans.poll();
            int curNum = curHuman.getNum();
            int curCnt = curHuman.getCnt();

            for(int h=0; h<relation.get(curNum).size(); h++) {
                int connectRel = relation.get(curNum).get(h);
                if(!visited[connectRel]) {
                    visited[connectRel] = true;
                    humans.offer(new Human(connectRel,curCnt+1));
                    memberCnt--;
                    // 모든 인원이 확인된 경우
                    if(memberCnt==0) {
                        score = curCnt+1;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 회원 수 입력
        human = Integer.parseInt(br.readLine());

        // 관계 리스트 생성
        relation = new ArrayList<>();
        for(int r=0; r<=human; r++)
            relation.add(new ArrayList<>());

        // 관계 입력
        while(true) {

            // 입력
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            // 종료 조건
            if(first==-1 && second==-1)
                break;

            relation.get(first).add(second);
            relation.get(second).add(first);
        }

        // 관계 확인
        scores = new int[human+1];
        result = new int[2];
        result[1] = Integer.MAX_VALUE;
        for(int r=1; r<=human; r++) {
            bfs(r);
            scores[r] = score;

            // 후보 갱신
            if(result[1]>=score) {
                if(result[1]>score) {
                    result[1] = score;
                    result[0] = 1;
                }
                else result[0]++;
            }
        }

        // 결과 출력
        System.out.println(result[1]+" "+result[0]);
        for(int h=1; h<=human; h++) {
            if(scores[h]==result[1])
                System.out.print(h+" ");
        }
    }
}