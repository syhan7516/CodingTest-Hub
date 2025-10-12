import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 원생 수, 그룹 수 입력
        st = new StringTokenizer(br.readLine());
        int childCount = Integer.parseInt(st.nextToken());
        int groupCount = Integer.parseInt(st.nextToken());

        // 리스트 생성
        ArrayList<Integer> talls = new ArrayList<>();
        ArrayList<Integer> differences = new ArrayList<>();

        // 키 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<childCount; index++) {
            talls.add(Integer.parseInt(st.nextToken()));
        }

        // 키 차이 확인
        for(int index=0; index<childCount-1; index++) {
            differences.add(talls.get(index+1) - talls.get(index));
        }

        // 정렬
        Collections.sort(differences);

        // 결과
        int answer = 0;

        // 키 차이 더하기
        for(int index=0; index<childCount-groupCount; index++){
            answer += differences.get(index);
        }

        // 결과 출력
        System.out.println(answer);
    }
}