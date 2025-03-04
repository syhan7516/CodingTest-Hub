import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 구역 클래스
class Area {
    int jungle;
    int ocean;
    int ice;

    public Area(int jungle, int ocean, int ice) {
        this.jungle = jungle;
        this.ocean = ocean;
        this.ice = ice;
    }
}

public class Main {

    // 가로, 세로 크기, 조사 대상 개수
    public static int rowSize, colSize, targetCount;

    // 행성 배열
    public static char planet[][];

    // 영역 누적 배열
    public static Area prefixSum[][];

    // 영역 누적 배열 생성 메서드
    public static void createPrefixSumArray() {
        prefixSum = new Area[rowSize+1][colSize+1];
        for(int index=0; index<=colSize; index++) {
            prefixSum[0][index] = new Area(0,0,0);
        }
        for(int index=0; index<=rowSize; index++) {
            prefixSum[index][0] = new Area(0,0,0);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 가로, 세로 크기 입력
        st = new StringTokenizer(br.readLine());
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());

        // 대상 영역 개수 입력
        targetCount = Integer.parseInt(br.readLine());

        // 해성 배열 생성
        planet = new char[rowSize+1][colSize+1];

        // 영역 누적 배열 생성
        createPrefixSumArray();

        // 행성 정보 입력
        for(int rowIndex=1; rowIndex<=rowSize; rowIndex++) {
            String line = br.readLine();
            for(int colIndex=1; colIndex<=colSize; colIndex++) {
                planet[rowIndex][colIndex] = line.charAt(colIndex-1);
                int jungle = prefixSum[rowIndex][colIndex-1].jungle+prefixSum[rowIndex-1][colIndex].jungle-prefixSum[rowIndex-1][colIndex-1].jungle;
                int ocean = prefixSum[rowIndex][colIndex-1].ocean+prefixSum[rowIndex-1][colIndex].ocean-prefixSum[rowIndex-1][colIndex-1].ocean;
                int ice = prefixSum[rowIndex][colIndex-1].ice+prefixSum[rowIndex-1][colIndex].ice-prefixSum[rowIndex-1][colIndex-1].ice;
                prefixSum[rowIndex][colIndex] = new Area(jungle,ocean,ice);
                if(planet[rowIndex][colIndex]=='J') prefixSum[rowIndex][colIndex].jungle++;
                if(planet[rowIndex][colIndex]=='O') prefixSum[rowIndex][colIndex].ocean++;
                if(planet[rowIndex][colIndex]=='I') prefixSum[rowIndex][colIndex].ice++;
            }
        }

        // 조사 영역 입력
        for(int index=0; index<targetCount; index++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int jungle = prefixSum[endY][endX].jungle-prefixSum[endY][startX-1].jungle-prefixSum[startY-1][endX].jungle+prefixSum[startY-1][startX-1].jungle;
            int ocean = prefixSum[endY][endX].ocean-prefixSum[endY][startX-1].ocean-prefixSum[startY-1][endX].ocean+prefixSum[startY-1][startX-1].ocean;
            int ice = prefixSum[endY][endX].ice-prefixSum[endY][startX-1].ice-prefixSum[startY-1][endX].ice+prefixSum[startY-1][startX-1].ice;
            sb.append(jungle).append(" ").append(ocean).append(" ").append(ice).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}