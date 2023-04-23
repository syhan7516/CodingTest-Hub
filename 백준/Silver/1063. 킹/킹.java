import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ThingPoint {
    private int y;
    private int x;

    public ThingPoint(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public void setPoint(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 이동 가능여부 확인 함수
    static boolean moveCheck(int y, int x) {
        if(y<1 || y>8 || x<1 || x>8)
            return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 킹의 이동 정보
        String kingDir[] = {"R","L","B","T","RT","LT","RB","LB"};
        int kingMove[][] = {{0,1},{0,-1},{-1,0},{1,0},{1,1},{1,-1},{-1,1},{-1,-1}};

        // 보드판
        int board[][] = new int[9][9];

        // 킹의 위치, 돌의 위치, 이동 횟수 입력
        st = new StringTokenizer(br.readLine());
        String kingPoint = st.nextToken();
        String stonePoint = st.nextToken();
        int moveCnt = Integer.parseInt(st.nextToken());

        int kingY = kingPoint.charAt(1)-'0';
        int kingX = kingPoint.charAt(0)-64;
        ThingPoint king = new ThingPoint(kingY,kingX);

        int stoneY = stonePoint.charAt(1)-'0';
        int stoneX = stonePoint.charAt(0)-64;
        ThingPoint stone = new ThingPoint(stoneY,stoneX);

        // 말 움직이기
        while(moveCnt>0) {

            // 종료 조건
            if(moveCnt==0)
                break;

            // 이동 정보 입력 & 찾기
            int moveNum = -1;
            String moveKey = br.readLine();
            for(int m=0; m<kingDir.length; m++) {
                if(kingDir[m].equals(moveKey)) {
                    moveNum = m;
                    break;
                }
            }

            // 이동 가능 여부 확인
            int nextKingY = king.getY()+kingMove[moveNum][0];
            int nextKingX = king.getX()+kingMove[moveNum][1];

            // 킹이 이동 가능한 경우
            if(moveCheck(nextKingY,nextKingX)) {
                // 돌과 같은 곳인 경우
                if(nextKingY==stone.getY() && nextKingX==stone.getX()) {
                    int nextStoneY = stone.getY()+kingMove[moveNum][0];
                    int nextStoneX = stone.getX()+kingMove[moveNum][1];
                    // 돌이 이동 가능한 경우
                    if(moveCheck(nextStoneY,nextStoneX)) {
                        king.setPoint(nextKingY,nextKingX);
                        stone.setPoint(nextStoneY,nextStoneX);
                    }
                }
                // 돌과 같은 위치가 아닌 경우
                else
                    king.setPoint(nextKingY,nextKingX);
            }

            // 이동 횟수 감소
            moveCnt--;
        }

        // 결과 출력
        System.out.println((char)(king.getX()+64)+""+king.getY());
        System.out.println((char)(stone.getX()+64)+""+stone.getY());
    }
}