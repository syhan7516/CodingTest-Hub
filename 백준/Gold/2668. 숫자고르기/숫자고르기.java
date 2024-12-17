import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    // 결과, 크기, 시작 인덱스
    public static int answer, size, startIndex;

    // 올바른 사이클 여부
    public static boolean flag;

    // 집합 정보 리스트
    public static ArrayList<Integer> set;

    // 표 배열
    public static int nums[];

    // 방문 여부, 선택 여부 배열
    public static boolean visited[], selected[];

    // 집합 탐색 메서드
    public static void solve(int idx) {

        // 사이클인 경우
        if(visited[nums[idx]]) {

            // 시작과 일치하는 경우
            if(startIndex==nums[idx]) flag = true;
        }

        // 사이클이 아닌 경우
        else {
            
            // 선택이 되지 않았던 원소의 경우
            if(!selected[nums[idx]]) {
                
                // 방문 처리
                visited[nums[idx]] = true;
                
                // 해당 원소 집합 탐색
                solve(nums[idx]);
                
                // 올바른 사이클인 경우
                if(flag) {
                    
                    // 선택 여부 처리 및 집합에 포함
                    selected[idx] = true;
                    set.add(nums[idx]);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 크기 입력
        size = Integer.parseInt(br.readLine());

        // 표 배열 생성
        nums = new int[size+1];

        // 표 정보 입력
        for(int index=1; index<=size; index++)
            nums[index] = Integer.parseInt(br.readLine());

        // 선택 여부 배열 생성
        selected = new boolean[size+1];

        // 집합 정보 리스트 생성
        set = new ArrayList<>();

        // 표 확인
        for(int index=1; index<=size; index++) {

            // 선택이 안된 목록인 경우
            if(!selected[index]) {
                
                // 방문 여부 배열 생성 후 시작 지점 방문 처리
                visited = new boolean[size+1];
                visited[index] = true;
                
                // 올바른 사이클 여부 초기화 및 시작 지점 저장
                flag = false;
                startIndex = index;
                
                // 집합 탐색 수행
                solve(index);
                
                // 올바른 사이클인 경우
                if(flag) {
                    
                    // 선택 여부 처리 및 집합에 포함
                    selected[index] = true;
                    set.add(index);
                }
            }
        }

        // 결과 정렬
        Collections.sort(set);
        System.out.println(set.size());
        for(int number: set) System.out.println(number);
    }
}