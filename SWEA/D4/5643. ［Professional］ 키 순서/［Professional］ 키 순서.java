import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    // 학생 수, 비교 수, 학생 지정, 결과
    public static int studentCnt, compareCnt, saram, result;

    // 관게 수 저장 배열
    public static int relCnt[];

    // 키 큰 관계 리스트, 키 작은 관계 리스트
    public static ArrayList<ArrayList<Integer>> sRel;
    public static ArrayList<ArrayList<Integer>> tRel;

    // 키 작은 사람 확인 메소드
    static void smallSolve(int person, boolean visited[]) {

        // 확인 처리
        visited[person] = true;

        // 해당 인원 관계 확인
        for(int i=0; i<sRel.get(person).size(); i++) {

            // 확인 학생
            int cPerson = sRel.get(person).get(i);

            // 확인 처리가 안된 경우
            if(!visited[cPerson]) {
                relCnt[saram]++;
                smallSolve(cPerson, visited);
            }
        }
    }

    // 키 큰 사람 확인 메소드
    static void tallSolve(int person, boolean visited[]) {

        // 확인 처리
        visited[person] = true;

        // 해당 인원 관계 확인
        for(int i=0; i<tRel.get(person).size(); i++) {

            // 확인 학생
            int cPerson = tRel.get(person).get(i);

            // 확인 처리가 안된 경우
            if(!visited[cPerson]) {
                relCnt[saram]++;
                tallSolve(cPerson, visited);
            }
        }
    }

    public static void main(String [] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스 수 입력
        int caseNum = Integer.parseInt(br.readLine());

        // 케이스 수 만큼 수행
        for(int caseIdx=1; caseIdx<=caseNum; caseIdx++) {

            // 학생 수 입력
            studentCnt = Integer.parseInt(br.readLine());

            // 비교 수 입력
            compareCnt = Integer.parseInt(br.readLine());

            // 관계 리스트 생성, 초기화
            sRel = new ArrayList<>();
            tRel = new ArrayList<>();

            for(int i=0; i<=studentCnt; i++) {
                tRel.add(new ArrayList<>());
                sRel.add(new ArrayList<>());
            }

            // 키 정보 입력
            for(int i=0; i<compareCnt; i++) {
                st = new StringTokenizer(br.readLine());
                int small = Integer.parseInt(st.nextToken());
                int tall = Integer.parseInt(st.nextToken());
                tRel.get(small).add(tall);
                sRel.get(tall).add(small);
            }

            // 관계 수 저장 배열 생성
            relCnt = new int[studentCnt+1];

            // 키 작은 사람 확인
            for(int i=1; i<=studentCnt; i++) {
                saram = i;
                smallSolve(i,new boolean[studentCnt+1]);
            }

            // 키 큰 사람 확인
            for(int i=1; i<=studentCnt; i++) {
                saram = i;
                tallSolve(i,new boolean[studentCnt+1]);
            }

            // 자신과 관계된 수 확인
            result = 0;
            for(int i=1; i<=studentCnt; i++) {

                // 관계 수가 학생 수에서 자신을 뺀 값과 동일한 경우
                if(relCnt[i]==studentCnt-1)
                    result++;
            }

            // 결과 저장
            sb.append("#").append(caseIdx).append(" ").append(result).append("\n");
        }

        // 결과 저장
        System.out.println(sb.toString());
    }
}