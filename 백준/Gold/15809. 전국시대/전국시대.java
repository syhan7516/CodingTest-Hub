import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    // 국가 수, 기록 수
    public static int countryCount, historyCount;

    // 동맹 정보 배열
    public static int[] groups;

    // 국가 병사 정보 배열
    public static int[] countries;

    // 국가 저장 해시 셋
    public static HashSet<Integer> resultCountries;

    // 국가 병력 저장 리스트
    public static ArrayList<Integer> resultArmyCount;

    // find
    public static int find(int country) {
        if(groups[country] == country) {
            return country;
        }

        return groups[country] = find(groups[country]);
    }

    // union
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a < b) {
            groups[b] = a;
            countries[a] += countries[b];
        }

        else {
            groups[a] = b;
            countries[b] += countries[a];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 국가 수, 기록 수 입력
        st = new StringTokenizer(br.readLine());
        countryCount = Integer.parseInt(st.nextToken());
        historyCount = Integer.parseInt(st.nextToken());

        // 국가 병사 정보 배열, 그룹 배열 생성
        countries = new int[countryCount+1];
        groups = new int[countryCount+1];

        // 그룹 배열 초기화
        for(int index=1; index<=countryCount; index++) {
            groups[index] = index;
        }

        // 병사 정보 입력
        for(int index=1; index<=countryCount; index++) {
            countries[index] = Integer.parseInt(br.readLine());
        }

        // 기록 정보 입력
        for(int index=0; index<historyCount; index++) {
            st = new StringTokenizer(br.readLine());
            boolean isAlliance = Integer.parseInt(st.nextToken()) == 1;
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 전쟁인 경우
            if(!isAlliance) {

                // 동맹 그룹 확인
                int firstGroupNum = find(a);
                int secondGroupNum = find(b);

                // 병력이 동일한 경우
                if(countries[firstGroupNum] == countries[secondGroupNum]) {
                    countries[firstGroupNum] = countries[secondGroupNum] = 0;
                    groups[firstGroupNum] = groups[secondGroupNum] = 0;
                }

                // A 국가가 더 강한 경우
                else if(countries[firstGroupNum] > countries[secondGroupNum]) {
                    countries[firstGroupNum] -= countries[secondGroupNum];
                    countries[secondGroupNum] = 0;
                }

                // B 국가가 더 강한 경우
                else {
                    countries[secondGroupNum] -= countries[firstGroupNum];
                    countries[firstGroupNum] = 0;
                }
            }

            // 국가 합치기
            union(a, b);
        }

        // 국가 저장 해시 셋 생성
        resultCountries = new HashSet<>();

        // 국가 병력 저장 리스트 생성
        resultArmyCount = new ArrayList<>();

        // 남은 국가 저장
        for(int index=1; index<=countryCount; index++) {
            int groupNum = find(index);
            if(groupNum > 0) {
                resultCountries.add(groupNum);
            }
        }

        // 남은 병력 저장
        for(int country: resultCountries) {
            resultArmyCount.add(countries[country]);
        }
        Collections.sort(resultArmyCount);

        // 결과 저장
        sb.append(resultArmyCount.size()).append("\n");
        for(int count: resultArmyCount) sb.append(count).append(" ");

        // 결과 출력
        System.out.println(sb.toString());
    }
}