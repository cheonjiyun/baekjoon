import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

class Piece {
  int id;
  int y;
  int x;
  int dir;

  public Piece(int id, int row, int col, int dir) {
    super();
    this.id = id;
    this.y = row;
    this.x = col;
    this.dir = dir;
  }

  @Override
  public String toString() {
    return "Piece [id=" + id + " ,x=" + x + ", y=" + y + ", dir=" + dir + "]";
  }
}


class AChessBoard {
  int color;
  Stack<Piece> pieces = new Stack<>();

  public AChessBoard(int color) {
    super();
    this.color = color;
  }

  public void addPiece(Piece piece) {
    pieces.push(piece);
  }

  @Override
  public String toString() {
    return "aChessBoard [color=" + color + ", pieces=" + pieces + "]";
  }
}


class XY {
  int y;
  int x;

  public XY(int x, int y) {
    super();
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString() {
    return "RowCol [x=" + x + ", y=" + y + "]";
  }
}


public class Main {
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  static final int WHITE = 0;
  static final int RED = 1;
  static final int BLUE = 2;

  static boolean isend = false;

  // 0 흰색
  // 1 빨강
  // 2 파랑
  public static void main(String[] args) throws Exception {
    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int n = Integer.valueOf(st.nextToken());
    int k = Integer.valueOf(st.nextToken());

    // 체스판 정보
    AChessBoard[][] chess = new AChessBoard[n][n];
    for (int i = 0; i < n; i++) {
      StringTokenizer stn = new StringTokenizer(br.readLine(), " ");
      for (int j = 0; j < n; j++) {
        chess[i][j] = new AChessBoard(Integer.valueOf(stn.nextToken()));
      }
    }

    // 말 정보
    List<Piece> pieces = new ArrayList<Piece>();
    for (int i = 0; i < k; i++) {
      StringTokenizer stn = new StringTokenizer(br.readLine(), " ");

      int y = Integer.valueOf(stn.nextToken()) - 1;
      int x = Integer.valueOf(stn.nextToken()) - 1;
      int dir = Integer.valueOf(stn.nextToken()) - 1;

      Piece newPidce = new Piece(i + 1, y, x, dir);
      pieces.add(newPidce);

      chess[y][x].addPiece(newPidce);
    }

    // 한 턴
    int turn = 0;
    while (turn <= 1000 && isend == false) {
      turn++;
      // for (int i = 0; i < n; i++) {
      // for (int j = 0; j < n; j++) {
      // System.out.println(chess[i][j]);
      // }
      // System.out.println();
      // }
      // System.out.println("--------");

      for (Piece piece : pieces) {
        XY where = whereGo(piece);
        int color = whatColor(chess, where.x, where.y);
        if (color == WHITE) { // 흰색
          white(chess[piece.y][piece.x].pieces, chess[where.y][where.x].pieces, piece, where);

        } else if (color == RED) { // 빨강
          red(chess[piece.y][piece.x].pieces, chess[where.y][where.x].pieces, piece, where);

        } else if (color == BLUE) { // 파랑
          blue(chess, piece);
        }
      }

    }


    if (turn > 1000) {
      turn = -1;
    }

    System.out.println(turn);
  }

  public static XY whereGo(Piece piece) {
    int nx = piece.x + Main.dx[piece.dir];
    int ny = piece.y + Main.dy[piece.dir];

    return new XY(nx, ny);
  }

  @Override
  public String toString() {
    return "Main []";
  }

  public static int whatColor(AChessBoard[][] chess, int x, int y) {
    if (x < 0 || y < 0 || x >= chess.length || y >= chess.length) {
      return BLUE;
    }
    return chess[y][x].color;
  }

  // 원래 이던 칸, 가려는 칸, 본인
  public static void white(Stack<Piece> beforePieces, Stack<Piece> nextPieces, Piece mypiece,
      XY where) {
    // 스택으로 반환했으므로 거꾸로 집어넣음
    Deque<Piece> onPieces = popOnPieces(beforePieces, mypiece);
    int piecessize = onPieces.size();
    for (int i = 0; i < piecessize; i++) {
      Piece piece = onPieces.pollLast();
      nextPieces.push(piece);
      piece.x = where.x;
      piece.y = where.y;
    }

    // 이동 후 4개 이상이면 종료
    if (nextPieces.size() >= 4) {
      isend = true;
    }
  }

  public static void red(Stack<Piece> beforePieces, Stack<Piece> nextPieces, Piece mypiece,
      XY where) {
    // 거꾸로 반환했으므로 그대로 집어넣음
    Deque<Piece> onPieces = popOnPieces(beforePieces, mypiece);
    int piecessize = onPieces.size();
    for (int i = 0; i < piecessize; i++) {

      Piece piece = onPieces.pollFirst();
      nextPieces.push(piece);
      piece.x = where.x;
      piece.y = where.y;
    }

    // 이동 후 4개 이상이면 종료
    if (nextPieces.size() >= 4) {
      isend = true;
    }
  }

  public static void blue(AChessBoard[][] chess, Piece mypiece) {
    if (mypiece.dir == 0 || mypiece.dir == 2) {
      mypiece.dir = mypiece.dir + 1;
    } else if (mypiece.dir == 1 || mypiece.dir == 3) {
      mypiece.dir = mypiece.dir - 1;
    }

    XY where = whereGo(mypiece);
    int color = whatColor(chess, where.x, where.y);
    if (color == WHITE) { // 흰색
      white(chess[mypiece.y][mypiece.x].pieces, chess[where.y][where.x].pieces, mypiece, where);
    } else if (color == RED) { // 빨강
      red(chess[mypiece.y][mypiece.x].pieces, chess[where.y][where.x].pieces, mypiece, where);
    }
  }

  // 본인과 본인 위에 있는 말 반환
  public static Deque<Piece> popOnPieces(Stack<Piece> pieces, Piece piece) {
    Deque<Piece> onPieces = new ArrayDeque<>();
    int p = pieces.search(piece);
    for (int i = 0; i < p; i++) {
      onPieces.addLast(pieces.pop());
    }

    return onPieces;
  }
}
