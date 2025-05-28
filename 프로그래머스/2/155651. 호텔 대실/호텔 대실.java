import java.util.*;

// 예약 클래스
class Book {
    int startTime;
    int endTime;

    public Book(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}


class Solution {
    
    // 결과
    public static int answer;

    // 예약 배열
    public static Book[] books;

    // 시간 변환 메서드
    public static int convertTimeToSecond(String time) {

        int totalSecond = 0;
        String[] times = time.split(":");

        totalSecond += Integer.parseInt(times[0])*60*60;
        totalSecond += Integer.parseInt(times[1])*60;

        return totalSecond;
    }

    // 객실 수 확인 메서드
    public static void solve() {

        // 우선 순위 큐 생성
        PriorityQueue<Book> queue
                = new PriorityQueue<>((a,b) -> a.endTime - b.endTime);

        // 예약 시간 확인
        for(int bookIndex=0; bookIndex<books.length; bookIndex++) {

            // 종료된 객실 확인
            while(!queue.isEmpty() && queue.peek().endTime<=books[bookIndex].startTime) {
                queue.poll();
            }

            queue.offer(books[bookIndex]);

            // 현재 객실 수 확인
            answer = Math.max(answer,queue.size());
        }
    }
    
    public int solution(String[][] book_time) {
        
        // 예약 배열 생성
        books = new Book[book_time.length];

        // 예약 정보 입력
        for(int bookIndex=0; bookIndex<book_time.length; bookIndex++) {
            int startTime = convertTimeToSecond(book_time[bookIndex][0]);
            int endTime = convertTimeToSecond(book_time[bookIndex][1])+600;
            books[bookIndex] = new Book(startTime,endTime);
        }

        // 시작 시간 기준으로 정렬
        Arrays.sort(books,(a,b) -> a.startTime - b.startTime);

        // 객실 수 확인
        solve();
        
        return answer;
    }
}