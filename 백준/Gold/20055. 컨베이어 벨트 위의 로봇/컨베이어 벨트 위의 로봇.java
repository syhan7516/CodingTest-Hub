import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 벨트 클래스
class Belt {
    private boolean robot;
    private int life;

    public Belt(boolean robot, int life) {
        this.robot = robot;
        this.life = life;
    }

    public boolean getRobot() {
        return this.robot;
    }

    public int getLife() {
        return this.life;
    }

    public void changeRobot() {
        this.robot = !robot;
    }

    public void changeLife() {
        this.life -= 1;
    }
}

public class Main {

    // 로봇 올리기 함수
    static void raiseRobot() {
        Belt curBelt = beltList.get(0);

        // 내구도 점검하기
        if((curBelt.getLife()!=0)) {
            curBelt.changeRobot();
            curBelt.changeLife();

            // 내구도 0인지 확인
            if(curBelt.getLife()==0)
                curDurability += 1;
        }
    }

    // 내리는 구간 확인 함수
    static void checkGetOffBelt() {
        Belt curBelt = beltList.get(beltLen-1);

        // 로봇 점검하기
        if(curBelt.getRobot()) {
            curBelt.changeRobot();
        }
    }

    // 로봇 옆으로 이동 함수
    static void moveRobot() {

        // 벨트 전체 확인
        for(int b=beltLen-2; b>=0; b--) {
            Belt curBelt = beltList.get(b);
            Belt nextBelt = beltList.get((b+1));

            // 현재 벨트에 로봇 존재 & 다음 벨트에 로봇이 없으면서 내구도가 존재할 경우
            if(curBelt.getRobot() && !nextBelt.getRobot() && nextBelt.getLife()!=0) {

                // 로봇 이동
                curBelt.changeRobot();
                nextBelt.changeRobot();

                // 로봇이 이동한 벨트 내구도 감소
                nextBelt.changeLife();

                // 이동된 벨트 내구도 0인지 확인
                if(nextBelt.getLife()==0)
                    curDurability += 1;
            }
        }
    }

    // 컨베이어 벨트 길이, 내구도 제한 개수, 현재 내구도 현황, 현재 단계 수
    public static int beltLen, durability, curDurability, curStage;

    // 벨트 정보 리스트
    public static ArrayList<Belt> beltList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 컨베이어 벨트 길이, 내구도 제한 개수 입력
        beltLen = Integer.parseInt(st.nextToken());
        durability = Integer.parseInt(st.nextToken());

        // 벨트 생성
        beltList = new ArrayList<>();

        // 각 벨트 정보 입력
        st = new StringTokenizer(br.readLine());
        for(int b=0; b<beltLen*2; b++) {
            int n = Integer.parseInt(st.nextToken());
            beltList.add(new Belt(false,n));
        }

        // 작업 수행
        curDurability = 0;
        curStage = 0;

        while(true) {

            // 단계 증가
            curStage += 1;

            // 벨트 회전
            Collections.rotate(beltList,1);

            // 내리는 구간 확인
            checkGetOffBelt();

            // 로봇 옆으로 이동
            moveRobot();

            // 내리는 구간 확인
            checkGetOffBelt();

            // 로봇 올리기
            raiseRobot();

            // 현재 내구도 확인
            if(curDurability>=durability)
                break;
        }

        // 결과 출력
        System.out.println(curStage);
    }
}