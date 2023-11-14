import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Belt {

    // 로봇 여부, 내구도
    boolean isRobot;
    int durability;

    public Belt(boolean isRobot, int durability) {
        this.isRobot = isRobot;
        this.durability = durability;
    }
}

public class Main {

    // 벨트 리스트
    public static ArrayList<Belt> belts;

    // 벨트 길이, 종료 조건, 현재 멈춘 벨트 개수, 작동 횟수
    public static int beltLen, beltStopCnt, curBeltStop, term;

    // 컨베이어 벨트 작동 메서드
    static void solve() {

        while(true) {

            // 벨트 회전
            Collections.rotate(belts,1);

            // 로봇 마지막에 있으면 내리기
            if(belts.get(beltLen-1).isRobot) {
                belts.get(beltLen-1).isRobot = false;
            }

            // 로봇 이동
            for(int i=beltLen-2; i>0; i--) {
                // 현재 벨트 정보
                Belt curBelt = belts.get(i);

                // 현재 벨트에 로봇이 없는 경우
                if(!curBelt.isRobot) continue;
                
                // 다음 벨트가 내구도가 있으면서 로봇이 없는 경우
                if(!belts.get(i+1).isRobot && belts.get(i+1).durability>0) {
                    curBelt.isRobot = false;
                    belts.get(i+1).isRobot = true;
                    belts.get(i+1).durability--;

                    // 내구도 0일 경우 멈추기
                    if(belts.get(i+1).durability==0) {
                        curBeltStop++;

                        // 종료 조건 도달한 경우
                        if(beltStopCnt==curBeltStop) return;
                    }
                }
            }

            // 로봇 마지막에 있으면 내리기
            if(belts.get(beltLen-1).isRobot) {
                belts.get(beltLen-1).isRobot = false;
            }

            // 올리는 위치 확인
            if(belts.get(0).durability>0) {
                belts.get(0).isRobot = true;
                belts.get(0).durability--;

                // 내구도 0일 경우 멈추기
                if(belts.get(0).durability==0) {
                    curBeltStop++;

                    // 종료 조건 도달한 경우
                    if(beltStopCnt==curBeltStop) return;
                }
            }

            // 작동 횟수 증가
            term++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 벨트 길이, 종료 조건 입력
        st = new StringTokenizer(br.readLine());
        beltLen = Integer.parseInt(st.nextToken());
        beltStopCnt = Integer.parseInt(st.nextToken());

        // 벨트 생성
        belts = new ArrayList<>();

        // 벨트 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<beltLen*2; i++) {
            int curDurability = Integer.parseInt(st.nextToken());
            belts.add(new Belt(false,curDurability));
        }

        // 컨베이어 벨트 작동
        curBeltStop = 0;
        term = 1;
        solve();

        // 결과 출력
        System.out.println(term);
    }
}