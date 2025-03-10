
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine().trim());
    int n = Integer.parseInt(st.nextToken());

    List<XY> stars = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine().trim());

      double x = Double.parseDouble(st.nextToken());
      double y = Double.parseDouble(st.nextToken());

      stars.add(new XY(x, y));
    }

    boolean[] visited = new boolean[n];
    double[] minEdge = new double[n];
    Arrays.fill(minEdge, Integer.MAX_VALUE);

    // 첫방문
    int count = 0;
    double result = 0;
    minEdge[0] = 0;

    // 반복
    for (int cnt = 0; cnt < n; cnt++) {
      // 최소 비용 정점
      double min = Double.MAX_VALUE;
      int current = 0;

      for (int i = 0; i < n; i++) {
        if (!visited[i] && min > minEdge[i]) {
          min = minEdge[i];
          current = i;
        }
      }
      visited[current] = true;

      // 누적
      result += min;

      count++;
      if (count == n) {
        break;
      }

      XY currentStar = stars.get(current);
      for (int i = 0; i < n; i++) {
        if (visited[i])
          continue;

        XY otherStar = stars.get(i);
        if (minEdge[i] > getDist(currentStar.x, currentStar.y, otherStar.x, otherStar.y)) {
          minEdge[i] = getDist(currentStar.x, currentStar.y, otherStar.x, otherStar.y);
        }

      }
    }

    System.out.println(result);
  }

  static double getDist(double x1, double y1, double x2, double y2) {
    return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
  }

  static class XY {
    double x;
    double y;

    public XY(double x, double y) {
      super();
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "XY [x=" + x + ", y=" + y + "]";
    }
  }
}
