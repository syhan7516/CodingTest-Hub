import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 숫자 클래스
class Num implements Comparable<Num> {
    int number;
    int count;

    public Num(int number, int count) {
        this.number = number;
        this.count = count;
    }

    @Override
    public int compareTo(Num other) {
        if(this.count==other.count)
            return this.number - other.number;
        return this.count - other.count;
    }
}

public class Main {

    // 결과, 위치, 목표 값, 크기
    public static int answer, resultRow, resultCol, resultValue, rowSize, colSize;

    // 배열
    public static int arr[][];

    // 행 연산 메서드
    public static void operatorRow() {

        // 세로 크기
        int currentColSize = 0;

        // 배열 생성
        int resultArr[][] = new int[101][101];

        // 숫자 정보 확인
        for(int rowIndex=1; rowIndex<=rowSize; rowIndex++) {

            // 개수 해시 생성
            HashMap<Integer,Integer> numCount = new HashMap<>();

            for(int colIndex=1; colIndex<=colSize; colIndex++) {

                // 빈 값인 경우
                if(arr[rowIndex][colIndex]==0) continue;

                int number = arr[rowIndex][colIndex];

                // 값이 있는 경우
                if(numCount.containsKey(number))
                    numCount.put(number,numCount.get(number)+1);

                // 값이 없는 경우
                else numCount.put(number,1);
            }

            // 리스트 생성
            ArrayList<Num> list = new ArrayList<>();
            for(int key: numCount.keySet()) {
                list.add(new Num(key, numCount.get(key)));
            }

            // 세로 길이 확인
            currentColSize = Math.max(currentColSize,list.size()*2);

            // 정렬
            Collections.sort(list);

            // 배열 갱신
            for(int index=0; index<list.size(); index++) {
                Num num = list.get(index);
                resultArr[rowIndex][index*2+1] = num.number;
                resultArr[rowIndex][index*2+2] = num.count;
            }
        }

        // 세로 크기, 배열 변경
        colSize = currentColSize;
        arr = resultArr;
    }

    // 열 연산 메서드
    public static void operatorCol() {

        // 가로 크기
        int currentRowSize = 0;

        // 배열 생성
        int resultArr[][] = new int[101][101];

        // 숫자 정보 확인
        for(int colIndex=1; colIndex<=colSize; colIndex++) {

            // 개수 해시 생성
            HashMap<Integer,Integer> numCount = new HashMap<>();

            for(int rowIndex=1; rowIndex<=rowSize; rowIndex++) {

                // 빈 값인 경우
                if(arr[rowIndex][colIndex]==0) continue;

                int number = arr[rowIndex][colIndex];

                // 값이 있는 경우
                if(numCount.containsKey(number))
                    numCount.put(number,numCount.get(number)+1);

                    // 값이 없는 경우
                else numCount.put(number,1);
            }

            // 리스트 생성
            ArrayList<Num> list = new ArrayList<>();
            for(int key: numCount.keySet()) {
                list.add(new Num(key, numCount.get(key)));
            }

            // 가로 길이 확인
            currentRowSize = Math.max(currentRowSize,list.size()*2);

            // 정렬
            Collections.sort(list);

            // 배열 갱신
            for(int index=0; index<list.size(); index++) {
                Num num = list.get(index);
                resultArr[index*2+1][colIndex] = num.number;
                resultArr[index*2+2][colIndex] = num.count;
            }
        }

        // 가로 크게, 배열 변경
        rowSize = currentRowSize;
        arr = resultArr;
    }

    // 연산 메서드
    public static void solve() {

        // 연산 횟수
        int operatorCount = 0;

        while(operatorCount<=100) {

            // 목표 값 확인
            if(arr[resultRow][resultCol]==resultValue) {
                answer = operatorCount;
                return;
            }
            
            // 행, 열 크기 확인
            if(rowSize>=colSize)
                operatorRow();
            
            else
                operatorCol();
            
            // 횟수 증가
            operatorCount++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 위치, 목표 값 입력
        st = new StringTokenizer(br.readLine());
        resultRow = Integer.parseInt(st.nextToken());
        resultCol = Integer.parseInt(st.nextToken());
        resultValue = Integer.parseInt(st.nextToken());

        // 배열 생성
        arr = new int[101][101];

        // 배열 입력
        for(int rowIndex=1; rowIndex<=3; rowIndex++) {
            st = new StringTokenizer(br.readLine());
            for(int colIndex=1; colIndex<=3; colIndex++) {
                arr[rowIndex][colIndex] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 크기
        rowSize = 3;
        colSize = 3;

        // 연산 수행
        answer = -1;
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}