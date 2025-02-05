
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    // 입력
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int count = 0;
    while (st.hasMoreTokens()) {
      arr[count++] = Integer.valueOf(st.nextToken());
    }

    // ----입력 끝----
    List<Integer> lastMinNumber = new ArrayList<>();

    // 초기값
    lastMinNumber.add(0);

    for (int i = 0; i < n; i++) {
      int curNum = arr[i];

      if (lastMinNumber.get(lastMinNumber.size() - 1) < curNum) {
        // 현재 가장 큰 수보다 크면 그냥 추가
        lastMinNumber.add(curNum);
      } else {

        // 사이 어딘가에 있다면
        // 본인보다 큰 값 중 가장 작은 값ㄴ
        int where = search(n, lastMinNumber, curNum);
        lastMinNumber.set(where, curNum);
      }
    }
    bw.write(String.valueOf(lastMinNumber.size() - 1));
    br.close();

    // 최종 출력
    bw.flush();
    bw.close();

  }

  // 이분 탐색
  public static int search(int n, List<Integer> lastMinNumber, int target) {
    int start = 0;
    int end = lastMinNumber.size() - 1;
    while (start < end) {
      int middle = (start + end) / 2;
      if (lastMinNumber.get(middle) < target) {
        start = middle + 1;
      } else {
        end = middle;
      }

    }
    return start;
  }
}
