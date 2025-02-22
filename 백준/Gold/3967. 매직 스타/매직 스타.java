import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// 좌표 클래스
class Point {
    int y;
    int x;

    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {

    // 결과 저장 빌더
    public static StringBuilder sb;

    // 결과 여부
    public static boolean flag = false;

    // 매직스타 배열
    public static int star[][];

    // x좌표 저장 리스트
    public static ArrayList<Point> points;

    // 선택된 숫자 리스트
    public static ArrayList<Integer> selected;

    // 방문 여부 배열
    public static boolean visited[];

    // 1
    public static boolean topToLeftDown() {
        return (star[0][4]+star[1][3]+star[2][2]+star[3][1])==26;
    }

    // 2
    public static boolean topToRightDown() {
        return (star[0][4]+star[1][5]+star[2][6]+star[3][7])==26;
    }

    // 3
    public static boolean topLeftToRight() {
        return (star[1][1]+star[1][3]+star[1][5]+star[1][7])==26;
    }

    // 4
    public static boolean bottomLeftToRight() {
        return (star[3][1]+star[3][3]+star[3][5]+star[3][7])==26;
    }

    // 5
    public static boolean bottomToLeftUp() {
        return (star[4][4]+star[3][3]+star[2][2]+star[1][1])==26;
    }

    // 6
    public static boolean bottomToRightUp() {
        return (star[4][4]+star[3][5]+star[2][6]+star[1][7])==26;
    }

    // 매직스타인지 확인하는 메서드
    public static boolean isMagicStar() {
        return (topToLeftDown() && topToRightDown() && topLeftToRight() && bottomLeftToRight() && bottomToLeftUp() && bottomToRightUp());
    }

    // 결과 저장 메서드
    public static void saveMaginStar() {

        // 빌더 생성
        sb = new StringBuilder();

        // 문자 확인
        for(int rowIndex=0; rowIndex<star.length; rowIndex++) {
            for (int colIndex=0; colIndex<star[rowIndex].length; colIndex++) {

                // 적절히 변환해서 저장
                if(star[rowIndex][colIndex]==0)
                    sb.append('.');
                else
                    sb.append((char)(star[rowIndex][colIndex]+'A'-1));
            }
            sb.append("\n");
        }
    }

    // 숫자 넣기 메서드
    public static void solve(int count) {

        // 이미 결과가 있는 경우
        if(flag) return;

        // 모두 선택된 경우
        if(count==points.size()) {

            // 숫자 넣기
            for(int index=0; index<points.size(); index++) {
                Point point = points.get(index);
                star[point.y][point.x] = selected.get(index);
                if(isMagicStar()) {
                    saveMaginStar();
                    flag = true;
                }
            }

            return;
        }

        // 선택하기
        for(int index=1; index<=12; index++) {
            if(!visited[index]) {
                visited[index] = true;
                selected.add(index);
                solve(count+1);
                visited[index] = false;
                selected.remove(selected.size()-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 매직스타 배열 생성
        star = new int[5][9];

        // 방문 여부 배열 생성
        visited = new boolean[13];

        // 위치 저장 리스트 생성
        points = new ArrayList<>();

        // 매직스타 정보 입력
        for(int rowIndex=0; rowIndex<5; rowIndex++) {
            String line = br.readLine();
            for(int colIndex=0; colIndex<9; colIndex++) {

                // 문자 정보
                char alpha = line.charAt(colIndex);

                // 문자에 따라 적절히 저장
                if(alpha=='.')
                    star[rowIndex][colIndex] = 0;

                else if(alpha=='x') {
                    points.add(new Point(rowIndex,colIndex));
                    star[rowIndex][colIndex] = -1;
                }

                else {
                    int num = alpha-'A'+1;
                    star[rowIndex][colIndex] = num;
                    visited[num] = true;
                }
            }
        }

        // 숫자 넣기
        selected = new ArrayList<>();
        solve(0);

        // 결과 출력
        System.out.println(sb.toString());
    }
}