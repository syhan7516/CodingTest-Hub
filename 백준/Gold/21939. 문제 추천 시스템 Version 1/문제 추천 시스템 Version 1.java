import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

// 문제 클래스
class Problem implements Comparable<Problem> {
    int number;
    int grade;

    public Problem(int number, int grade) {
        this.number = number;
        this.grade = grade;
    }

    @Override
    public int compareTo(Problem other) {
        if(this.grade == other.grade)
            return this.number - other.number;
        return this.grade - other.grade;
    }
}

public class Main {

    // 문제 개수, 명령어 개수
    public static int problemCount, commandCount;

    // 문제 저장 트리셋
    public static TreeSet<Problem> set;

    // 문제 저장 해시
    public static HashMap<Integer,Integer> map;

    // 문제 추가 메서드
    public static void add(int problemNum, int problemGrade) {
        set.add(new Problem(problemNum, problemGrade));
        map.put(problemNum,problemGrade);
    }

    // 문제 추천 메서드
    public static int recommend(int value) {

        if(value==-1)
            return set.first().number;

        else
            return set.last().number;
    }

    // 문제 제거 메서드
    public static void solved(int problemNum) {
        set.remove(new Problem(problemNum,map.get(problemNum)));
        map.remove(problemNum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 문제 개수 입력
        problemCount = Integer.parseInt(br.readLine());

        // 문제 저장 트리셋 생성
        set = new TreeSet<>();

        // 문제 저장 해시 생성
        map = new HashMap<>();

        // 문제 정보 입력
        for(int index=0; index<problemCount; index++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            set.add(new Problem(number,grade));
            map.put(number,grade);
        }

        // 명령어 개수 입력
        commandCount = Integer.parseInt(br.readLine());
        for(int index=0; index<commandCount; index++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            int inputValue = Integer.parseInt(st.nextToken());

            if(command.equals("add")) {
                add(inputValue, Integer.parseInt(st.nextToken()));
            }

            else if(command.equals("recommend")) {
                sb.append(recommend(inputValue)).append("\n");
            }

            else {
                solved(inputValue);
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}