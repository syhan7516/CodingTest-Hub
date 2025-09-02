import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    // 학생 수, 자는 수, 전달 수, 구간 수
    public static int studentCount, sleepCount, codeCount, rangeCount;

    // 학생 정보 배열
    public static int[] students;

    // 구간 합 배열
    public static int[] prefixSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 학생 수, 자는 수, 전달 수, 구간 수 입력
        st = new StringTokenizer(br.readLine());
        studentCount = Integer.parseInt(st.nextToken());
        sleepCount = Integer.parseInt(st.nextToken());
        codeCount = Integer.parseInt(st.nextToken());
        rangeCount = Integer.parseInt(st.nextToken());

        // 학생 정보 배열 생성
        students = new int[studentCount+3];

        // 자는 학생 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<sleepCount; index++) {
            int student = Integer.parseInt(st.nextToken());
            students[student] = 1;
        }

        // 코드 전달 학생 입력
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<codeCount; index++) {

            // 학생 정보 입력
            int student = Integer.parseInt(st.nextToken());
            if(students[student] == 1) continue;

            // 전달
            students[student] = -1;
            for(int studentIndex=student*2; studentIndex<students.length; studentIndex+=student) {
                if(students[studentIndex] == 1) continue;
                students[studentIndex] = -1;
            }
        }

        // 구간 합 구하기
        prefixSum = new int[studentCount+3];
        for(int index=3; index<=studentCount+2; index++) {
            int currentStudent = students[index] == -1 ? 0 : 1;
            prefixSum[index] = prefixSum[index-1] + currentStudent;
        }

        // 구간 정보 입력
        for(int index=0; index<rangeCount; index++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int currentStudent = students[start] == -1 ? 0 : 1;
            sb.append(prefixSum[end] - prefixSum[start] + currentStudent).append("\n");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}