//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//
//public class Main {
//
//    // 가로, 세로 크기, 별의 개수
//    public static int rowSize, colSize, starCount;
//
//    // 위치
//    public static int myStartY, myStartX, myEndY, myEndX;
//    public static int yourStartY, yourStartX, yourEndY, yourEndX;
//
//    // 하늘 배열
//    public static int[][] sky;
//
//    // 위치 입력 메서드
//    public static void inputPoint(StringTokenizer st, int y, int x) {
//        y = Integer.parseInt(st.nextToken());
//        x = Integer.parseInt(st.nextToken());
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        // 가로, 세로 크기, 별의 개수 입력
//        st = new StringTokenizer(br.readLine());
//        rowSize = Integer.parseInt(st.nextToken());
//        colSize = Integer.parseInt(st.nextToken());
//        starCount = Integer.parseInt(st.nextToken());
//
//        // 하늘 배열 생성
//        sky = new int[rowSize+1][colSize+1];
//
//        // 별의 위치 입력
//        for(int index=0; index<starCount; index++) {
//            st = new StringTokenizer(br.readLine());
//            int row = Integer.parseInt(st.nextToken());
//            int col = Integer.parseInt(st.nextToken());
//            sky[row][col] = -1;
//        }
//
//        // 위치 입력
//        inputPoint(new StringTokenizer(br.readLine()), myStartY, myStartX);
//        inputPoint(new StringTokenizer(br.readLine()), myEndY, myEndX);
//        inputPoint(new StringTokenizer(br.readLine()), yourStartY, yourStartX);
//        inputPoint(new StringTokenizer(br.readLine()), yourEndY, yourEndX);
//
//        // 위치 정리
//        for(int rowIndex=Math.min(myStartY, myEndY); rowIndex<=Math.max(myStartY, myEndY); rowIndex++) {
//            for(int colIndex=Math.min(myStartX, myEndX); colIndex<=Math.max(myStartX, myEndX); colIndex++) {
//
//            }
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;

        // 해시 생성
        HashMap<String, Integer> keyTypeStringMap = new HashMap<>();
        HashMap<Integer, String> keyTypeIntegerMap = new HashMap<>();
        keyTypeStringMap.put("{}", 0);
        keyTypeStringMap.put("{{}}", 1);
        keyTypeIntegerMap.put(0, "{}");
        keyTypeIntegerMap.put(1, "{{}}");

        // 15까지 생성
        for(int num=2; num<=15;num++) {
            sb = new StringBuilder();
            for(int index=0; index<num; index++) {
                sb.append(keyTypeIntegerMap.get(index)).append(",");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.insert(0,"{").append("}");
            keyTypeStringMap.put(sb.toString(), num);
            keyTypeIntegerMap.put(num, sb.toString());
        }

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        sb = new StringBuilder();
        for(int caseNum=0; caseNum<caseCount; caseNum++) {
            int a = keyTypeStringMap.get(br.readLine());
            int b = keyTypeStringMap.get(br.readLine());
            sb.append(keyTypeIntegerMap.get(a+b)).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}