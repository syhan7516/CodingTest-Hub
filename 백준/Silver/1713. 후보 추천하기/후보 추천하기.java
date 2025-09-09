import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

// 학생 클래스
class Student {
    int order;
    int count;

    public Student(int order, int count) {
        this.order = order;
        this.count = count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 사진 틀 개수 입력
        int frameCount = Integer.parseInt(br.readLine());

        // 추천 횟수 입력
        int recommendCount = Integer.parseInt(br.readLine());

        // 해시 맵 생성
        HashMap<Integer, Student> frames = new HashMap<>();

        // 순서 저장 배열 생성
        int[] orders = new int[101];

        // 추천 정보 입력
        int totalOrder = 1;
        st = new StringTokenizer(br.readLine());
        for(int index=0; index<recommendCount; index++) {
            int num = Integer.parseInt(st.nextToken());

            // 새로운 학생이면서 개수가 한계인 경우
            if(!frames.containsKey(num) && frames.size() == frameCount) {
                int student = 10000;
                int order = 10000;
                int count = 10000;

                for(int key: frames.keySet()) {
                    Student currentStudent = frames.get(key);

                    // 추천 수가 작은 경우
                    if(currentStudent.count <= count) {

                        if(currentStudent.count == count) {
                            if(currentStudent.order < order) {
                                student = key;
                                order = currentStudent.order;
                            }
                        }

                        else {
                            student = key;
                            order = currentStudent.order;
                            count = currentStudent.count;
                        }
                    }
                }

                frames.remove(student);
                frames.put(num, new Student(totalOrder, 1));
                orders[num] = totalOrder++;
            }

            // 기존에 존재했던 경우
            else if(frames.containsKey(num)) {
                frames.put(num, new Student(orders[num], frames.get(num).count+1));
            }

            // 자리가 있는 경우
            else {
                frames.put(num, new Student(totalOrder, 1));
                orders[num] = totalOrder++;
            }
        }

        // 결과 저장
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int key: frames.keySet()) {
            queue.offer(key);
        }
        while(!queue.isEmpty()) {
            sb.append(queue.poll()).append(" ");
        }

        // 결과 출력
        System.out.println(sb.toString());
    }
}