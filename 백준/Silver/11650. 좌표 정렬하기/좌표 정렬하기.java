import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 좌표 클래스
class Point implements Comparable<Point> {
    private int x;
    private int y;

    public Point(int x ,int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int compareTo(Point other) {
        if(this.x < other.x)
            return -1;

        else if(this.x == other.x) {
            if(this.y < other.y)
                return -1;
            return 1;
        }

        return 1;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 좌표 저장 리스트
        ArrayList<Point> point = new ArrayList<>();

        // 좌표 개수
        int pointCnt = Integer.parseInt(st.nextToken());

        // 좌표 입력
        for(int idx=0; idx<pointCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            point.add(new Point(x,y));
        }

        // 좌표 정렬
        Collections.sort(point);

        // 결과 출력
        for(int idx=0; idx<point.size(); idx++) {
            Point curPoint = point.get(idx);
            int curX = curPoint.getX();
            int curY = curPoint.getY();
            System.out.println(curX + " " + curY);
        }
    }
}