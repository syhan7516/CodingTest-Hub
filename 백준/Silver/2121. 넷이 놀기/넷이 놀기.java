import java.io.*;
import java.util.*;
public class Main {

    static int N,A,B;
    static Set<Point> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();
    static int result = 0;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        for(Point p : set) {
            Point p1 = new Point(p.y + B, p.x + A);
            Point p2 = new Point(p.y, p.x + A);
            Point p3 = new Point(p.y + B, p.x);

            if(set.contains(p1) && set.contains(p2) && set.contains(p3)) result++;
        }

        System.out.println(result);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            set.add(new Point(y, x));
        }
    }

    static class Point {
       final int y,x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public int hashCode() {
            int prime = 1_000_000_007;
            prime = prime*31 + x;
            return prime *31 + y;
        }

        @Override
        public boolean equals(Object obj) {
            Point point = (Point)obj;
            return (this.y == point.y && this.x == point.x);
        }
    }
}