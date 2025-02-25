import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
  public static void main(String[] args) throws Exception {

    // System.setIn(new FileInputStream("테스트케이스.txt"));
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T;
    T = Integer.parseInt(in.readLine());
    for (int test_case = 1; test_case <= 10; test_case++) {
      sb.append("#" + test_case + " ");


      String[] input1 = in.readLine().split(" ");
      int v = Integer.parseInt(input1[0]);
      int e = Integer.parseInt(input1[1]);
      int a = Integer.parseInt(input1[2]);
      int b = Integer.parseInt(input1[3]);

      String[] input2 = in.readLine().split(" ");

      List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
      for (int i = 0; i <= v; i++) {
        list.add(new ArrayList<>());
      }

      for (int i = 0; i < e * 2; i += 2) {
        int p = Integer.parseInt(input2[i]);
        int c = Integer.parseInt(input2[i + 1]);

        list.get(p).add(c);
      }

      Node result = dfs(1, list, a, b);
      sb.append(result.number).append(" ").append(result.findCount).append("\n");

    }

    System.out.println(sb);
  }

  private static Node dfs(int i, List<ArrayList<Integer>> list, int a, int b) {
    Node node = new Node(false, 0, 1);

    for (int child : list.get(i)) {
      Node childReturn = dfs(child, list, a, b);

      node.isChild += childReturn.isChild;
      node.sub += childReturn.sub;
      if (childReturn.find) {
        node.find = true;
        node.number = childReturn.number;
        node.findCount = childReturn.findCount;
      }
    }

    if (i == a || i == b) {
      node.isChild += 1; // 내가
    }

    if (!node.find && node.isChild == 2) {
      node.find = true;
      // 만약 두개면 그게 조상
      node.number = i;
      node.findCount = node.sub;
    }


    return node;
  }

  static class Node {
    int number;
    boolean find;
    int findCount;
    int isChild;
    int sub;

    public Node(boolean find, int isChild, int sub) {
      super();
      this.find = find; // 그만
      this.isChild = isChild;
      this.sub = sub;
    }

    @Override
    public String toString() {
      return "Node [number=" + number + ", find=" + find + ", findCount=" + findCount + ", isChild="
          + isChild + ", sub=" + sub + "]";
    }



  }
}