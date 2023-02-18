import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Person implements Comparable<Person> {
    private int age;
    private String name;
    private int orderNum;

    public Person(int age ,String name, int orderNum) {
        this.age = age;
        this.name = name;
        this.orderNum = orderNum;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public int compareTo(Person other) {
        if(this.age < other.age)
            return -1;

        else if(this.age == other.age) {
            if(this.orderNum < other.orderNum)
                return -1;
            return 1;
        }

        return 1;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사람 저장 리스트
        ArrayList<Person> persons = new ArrayList<>();

        // 사람 수 & 입력 순서
        int personCnt = Integer.parseInt(st.nextToken());
        int order = 0;


        // 사람 정보 입력
        for(int idx=0; idx<personCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            persons.add(new Person(age, name, ++order));
        }

        // 좌표 정렬
        Collections.sort(persons);

        // 결과 출력
        for(int idx=0; idx<persons.size(); idx++) {
            Person curPerson = persons.get(idx);
            int curAge = curPerson.getAge();
            String curName = curPerson.getName();
            System.out.println(curAge + " " + curName);
        }
    }
}