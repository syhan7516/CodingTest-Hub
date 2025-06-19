import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.PriorityQueue;

// 책
class Book {
    String bookName;
    int soldCount;

    public Book(String bookName, int soldCount) {
        this.bookName = bookName;
        this.soldCount = soldCount;
    }
}

public class Main {

    // 판매된 책 수
    public static int soldBookCount;

    // 판매 정보 해시
    public static HashMap<String,Integer> soldBookInformation;

    // 판매순 우선 순위 큐
    public static PriorityQueue<Book> maxSoldBooks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 판매된 책 수 입력
        soldBookCount = Integer.parseInt(br.readLine());

        // 판매 정보 해시 생성
        soldBookInformation = new HashMap<>();

        // 판매된 책 정보 입력
        for(int bookIndex=0; bookIndex<soldBookCount; bookIndex++) {

            // 책
            String bookName = br.readLine();
            soldBookInformation.put(bookName,soldBookInformation.getOrDefault(bookName,0)+1);
        }

        // 판매순 우선 순위 큐 생성
        maxSoldBooks = new PriorityQueue<>((a,b) -> {
            if(a.soldCount==b.soldCount) {
                return a.bookName.compareTo(b.bookName);
            }
            return b.soldCount - a.soldCount;
        });

        // 판매 확인
        for(String bookName :soldBookInformation.keySet()) {
            maxSoldBooks.offer(new Book(bookName,soldBookInformation.get(bookName)));
        }

        // 결과 출력
        System.out.println(maxSoldBooks.poll().bookName);
    }
}