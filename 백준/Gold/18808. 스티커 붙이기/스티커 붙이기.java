import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] notebook = new int[N][M];

        List<Sticker> stickers = new ArrayList<>();
        int K = Integer.parseInt(st.nextToken());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            stickers.add(new Sticker(row, col));

            for (int j = 0; j < row; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < col; k++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        stickers.get(i).pos.add(new Coordinate(j, k));
                    }
                }
            }
        }

        for (int stickerNum = 0; stickerNum < K; stickerNum++) {
            Sticker curSticker = stickers.get(stickerNum);
            for (int i = 0; i < 4; i++) {
                if (curSticker.stick(notebook)) {
                    break;
                }
                curSticker.rotate();
            }
        }

        long ans = Arrays.stream(notebook)
                .flatMapToInt(Arrays::stream)
                .filter(value -> value == 1)
                .count();

        bw.write(Long.toString(ans));
        bw.flush();
    }
}

class Sticker {
    ArrayList<Coordinate> pos = new ArrayList<>();
    int rowSize;
    int colSize;


    public Sticker(int rowSize, int colSize) {
        this.rowSize = rowSize;
        this.colSize = colSize;
    }

    public void rotate() {
        int temp = rowSize;
        rowSize = colSize;
        colSize = temp;

        for (int i = 0; i < pos.size(); i++) {
            Coordinate c = pos.get(i);
            int prevRow = c.row;
            int prevCol = c.col;
            c.row = prevCol;
            c.col = colSize - prevRow - 1;
        }
    }

    public boolean stick(int[][] notebook) {
        for (int i = 0; i <= notebook.length - rowSize; i++) {
            for (int j = 0; j <= notebook[i].length - colSize; j++) {
                boolean canStick = true;
                for (Coordinate c : pos) {
                    if (notebook[i + c.row][j + c.col] == 1) {
                        canStick = false;
                        break;
                    }
                }
                if (canStick) {
                    for (Coordinate c : pos) {
                        notebook[i + c.row][j + c.col] = 1;
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int size() {
        return pos.size();
    }
}

class Coordinate {
    int row;
    int col;

    public Coordinate(int row, int col) {
        this.row = row;
        this.col = col;
    }
}