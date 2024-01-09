import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Problem implements Comparable<Problem> {
    int number;
    int level;

    public Problem(int number, int level) {
        this.number = number;
        this.level = level;
    }

    public int compareTo(Problem other) {
        if(this.level==other.level)
            return this.number-other.number;

        else
            return this.level-other.level;
    }
}

public class Main {

    // 문제 개수
    public static int problemCnt;

    // 최대, 최소 트리 셋
    public static TreeSet<Problem> set;

    // 문제 정보 해시 셋
    public static HashMap<Integer,Integer> problems;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 트리 셋, 해시 생성
        set = new TreeSet<>();
        problems = new HashMap<>();

        // 문제 개수 입력
        problemCnt = Integer.parseInt(br.readLine());

        // 문제 번호, 난이도 입력
        for(int i=0; i<problemCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            set.add(new Problem(number,level));
            problems.put(number,level);
        }

        // 명령어 개수 입력
        int orderCnt = Integer.parseInt(br.readLine());

        // 명령어 입력
        for(int i=0; i<orderCnt; i++) {
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            int first = Integer.parseInt(st.nextToken());

            // add
            if(order.equals("add")) {
                int second = Integer.parseInt(st.nextToken());
                set.add(new Problem(first,second));
                problems.put(first,second);
            }

            // recommend
            else if(order.equals("recommend")) {

                // 1
                if(first==1) {
                    sb.append(set.last().number).append("\n");
                }

                // -1
                else {
                    sb.append(set.first().number).append("\n");
                }
            }

            // solved
            else {
                set.remove(new Problem(first,problems.get(first)));
                problems.remove(first);
            }
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}