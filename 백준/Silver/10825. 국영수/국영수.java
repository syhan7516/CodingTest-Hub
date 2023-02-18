import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Subject implements Comparable<Subject> {
    private int kor;
    private int mat;
    private int eng;
    private String name;

    public Subject(int kor, int mat, int eng, String name) {
        this.kor = kor;
        this.mat = mat;
        this.eng = eng;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getKor() {
        return this.kor;
    }

    public int getMat() {
        return this.mat;
    }

    public int getEng() {
        return this.eng;
    }

    public int compareTo(Subject other) {
        if(this.kor > other.kor)
            return -1;

        else if(this.kor == other.kor) {
            if(this.eng < other.eng) {
                return -1;
            }
            else if(this.eng == other.eng) {
                if(this.mat > other.mat) {
                    return -1;
                }

                else if(this.mat == other.mat) {
                    return this.name.compareTo(other.name);
                }
                return 1;
            }
            return 1;
        }
        return 1;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 과목 점수 저장 리스트
        ArrayList<Subject> scores = new ArrayList<>();

        // 사람 수
        int personCnt = Integer.parseInt(st.nextToken());

        // 과목 점수 정보 입력
        for(int idx=0; idx<personCnt; idx++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int mat = Integer.parseInt(st.nextToken());
            scores.add(new Subject(kor, mat, eng, name));
        }

        // 좌표 정렬
        Collections.sort(scores);

        // 결과 출력
        for(int idx=0; idx<scores.size(); idx++) {
            Subject curSubject = scores.get(idx);
            String curName = curSubject.getName();
            System.out.println(curName);
        }
    }
}