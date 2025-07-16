import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    // 조상 리스트
    public static ArrayList<Integer> firstNumFatherList, secondNumFatherList;

    // 조상 구하기 메서드
    public static void getFatherList(ArrayList<Integer> fatherList, int num) {
        while(num>0) {
            fatherList.add(num);
            num = num/2;
        }
    }

    // 조상 비교 메서드
    public static int LCA() {

        // 인덱스, 조상 정보 초기화
        int index = 0;
        int father = 0;

        while(index<firstNumFatherList.size() && index<secondNumFatherList.size()) {

            // 조상 확인
            int firstNumFather = firstNumFatherList.get(index);
            int secondNumFather = secondNumFatherList.get(index);

            // 조상이 다른 경우
            if(firstNumFather!=secondNumFather) {
                return father;
            }

            // 조상이 동일한 경우
            father = firstNumFather;

            // 인덱스 갱신
            index++;
        }

        return father;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseCount = Integer.parseInt(br.readLine());

        // 케이스 수행
        for(int caseNum=0; caseNum<caseCount; caseNum++) {

            // 질의 입력
            st = new StringTokenizer(br.readLine());
            int firstNum = Integer.parseInt(st.nextToken());
            int secondNum = Integer.parseInt(st.nextToken());

            // 조상 구하기
            firstNumFatherList = new ArrayList<>();
            secondNumFatherList = new ArrayList<>();
            getFatherList(firstNumFatherList,firstNum);
            getFatherList(secondNumFatherList,secondNum);

            // 정렬
            Collections.sort(firstNumFatherList);
            Collections.sort(secondNumFatherList);

            // LCA 구하기
            sb.append(LCA()*10).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}