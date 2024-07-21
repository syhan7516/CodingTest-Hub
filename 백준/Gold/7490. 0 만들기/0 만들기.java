import java.util.*;
import java.io.*;

public class Main {

    // 결과 저장 빌더
    public static StringBuilder sb;

    // 선택된 수 저장 리스트
    public static ArrayList<Integer> selected;

    // 연산 배열
    public static int calc[] = {-3,-1,-2};

    // 연산 수행 메서드
    public static boolean calculate() {

        // 연산 결과
        int sum = 0;

        // 이전 숫자
        int preNum = 0;

        // 이전 연산
        int preCal = -1;

        // 공백 여부
        boolean flag = false;

        // 저장된 리스트 연산 수행
        for(int i=0; i<selected.size(); i++) {

            // 현재 데이터
            int current = selected.get(i);

            // 연산자인 경우
            if(current==-1 || current==-2) {

                // "+"
                if(preCal==-1) {
                    sum += preNum;
                    preCal = current;
                }

                // "-"
                else {
                    sum -= preNum;
                    preCal = current;
                }
            }

            // " "
            else if(current==-3) flag = true;

            // 숫자인 경우
            else {

                // 공백 연산이 있었던 경우
                if(flag) {
                    preNum = Integer.parseInt(String.valueOf(preNum)+current);
                    flag = false;
                }

                // 공백연산이 아니였던 경우
                else preNum = current;
            }
        }

        // 마지막 처리
        if(preCal==-1) sum += preNum;
        else sum -= preNum;

        // 연산 결과 0이되는 경우
        if(sum==0) return true;
        else return false;
    }

    // 결과 저장 메서드
    public static void saveCalculate() {

        // 선택된 수 저장 리스트 순회
        for(int i=0; i<selected.size(); i++) {

            // 선택된 정보
            int current = selected.get(i);

            // 숫자가 아닌 경우
            if(current==-1 || current==-2 || current==-3) {
                if(current==-1) sb.append("+");
                else if(current==-2) sb.append("-");
                else sb.append(" ");
            }

            // 숫자인 경우
            else sb.append(current);
        }

        sb.append("\n");
    }

    // 0 만들기 메서드
    public static void solve(int num, int numCnt) {

        // 숫자를 모두 확인한 경우
        if(num>numCnt) {

            // 연산 수행
            if(calculate())

                // 연산 결과 0인 경우
                saveCalculate();

            return;
        }

        // 아닌 경우
        for(int o=0; o<3; o++) {
            selected.add(calc[o]);
            selected.add(num);
            solve(num+1,numCnt);
            selected.remove(selected.size()-1);
            selected.remove(selected.size()-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=0; caseIdx<caseNum; caseIdx++) {

            // 숫자 개수 입력
            int numCnt = Integer.parseInt(br.readLine());

            // 선택된 수 저장 리스트 생성
            selected = new ArrayList<>();

            // 0 만들기
            selected.add(1);
            solve(2,numCnt);
            sb.append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}