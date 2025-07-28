import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 그룹 클래스
class Group {
    int num;
    int power;

    public Group(int num, int power) {
        this.num = num;
        this.power = power;
    }
}

public class Main {

    // 결과, 왕국 수, 동맹 수, CTP, HAN, 최대 동맹 가능 횟수
    public static int answer, countryCount, allianceCount, CTP, HAN, maxAllianceCount;

    // 그룹 배열
    public static int[] parent;

    // find
    public static int find(int num) {
        if(parent[num] == num) {
            return num;
        }

        return parent[num] = find(parent[num]);
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a<b) parent[b] = a;
        else parent[a] = b;
    }

    // 왕국의 힘의 최댓값 구하기 메서드
    public static void solve() {

        for(int index=1; index<=countryCount; index++) {
            find(index);
        }

        // 속한 그룹 확인
        CTP = find(CTP);
        HAN = find(HAN);

        // 그룹에 속한 왕국 수 확인
        Group[] powers = new Group[countryCount+1];
        for(int index=0; index<=countryCount; index++) {
            powers[index] = new Group(index, 0);
        }

        for(int index=1; index<=countryCount; index++) {
            powers[parent[index]].power++;
        }

        // 동맹 파워순으로 정렬
        answer = powers[CTP].power;
        Arrays.sort(powers, (a,b) -> b.power - a.power);

        // 동맹 시도
        int index = 0;
        while(powers[index].power>0 && maxAllianceCount>0) {

            // CTP, HAN 둘이 속한 그룹이 아닌 경우
            if(powers[index].num != CTP && powers[index].num != HAN) {
                answer += powers[index].power;
                maxAllianceCount--;
            }

            index++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 왕국 수, 동맹 수 입력
        st = new StringTokenizer(br.readLine());
        countryCount = Integer.parseInt(st.nextToken());
        allianceCount = Integer.parseInt(st.nextToken());

        // 그룹 배열 생성 및 초기화
        parent = new int[countryCount+1];
        for(int index=1; index<=countryCount; index++) {
            parent[index] = index;
        }

        // 동맹 정보 입력
        for(int index=0; index<allianceCount; index++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            union(from, to);
        }

        // CTP, HAN, 최대 동맹 가능 횟수 입력
        st = new StringTokenizer(br.readLine());
        CTP = Integer.parseInt(st.nextToken());
        HAN = Integer.parseInt(st.nextToken());
        maxAllianceCount = Integer.parseInt(st.nextToken());

        // 왕국의 힘의 최댓값 구하기
        solve();

        // 결과 출력
        System.out.println(answer);
    }
}