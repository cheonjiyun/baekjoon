import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static Node root;
	private static int n;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			String input = br.readLine();

			root = new Node();

			insert(input.substring(0));
			for (int i = 0; i < input.length(); i++) {
				insert(input.substring(i));
			}

			count=0;
			result = "";
			find = false;
			dfs(root, new StringBuilder());

			sb.append(result);
			sb.append("\n");

		}
		System.out.println(sb);
	}

	static int count;
	static String result;
	static boolean find = false;

	static void dfs(Node node, StringBuilder path) {
		if (find) {
			return;
		}

		if (node.end) {
			count++;

			if (count == n) {
				result = path.toString();
				return;
			}
		}

		for (int i = 0; i < node.children.length; i++) {
			if (node.children[i] != null) {
				path.append((char) (i + 'a'));
				dfs(node.children[i], path);
				path.deleteCharAt(path.length() - 1);
			}
		}
	}

	static void insert(String subInput) {
		Node node = root;
		for (int i = 0; i < subInput.length(); i++) {
			int idx = subInput.charAt(i) - 'a';
			if (node.children[idx] == null) {
				node.children[idx] = new Node();
			}
			node = node.children[idx];
		}
		node.end = true;
	}

	static class Node {
		Node[] children = new Node[26];
		boolean end = false;

		@Override
		public String toString() {
			return "Node [children=" + Arrays.toString(children) + ", end=" + end + "]";
		}

	}
}