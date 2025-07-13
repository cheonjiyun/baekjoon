import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	private static Node root;
	private static boolean found;
	private static int count;
	private static int k;
	private static String result;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");

			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			String input = br.readLine();

			root = new Node();

			for (int i = 0; i < input.length(); i++) {
				for (int j = i; j < input.length(); j++) {
					insert(input.substring(i, j+1));
				}
			}

			// init
			result = "";
			count = 0;
			found = false;

			dfs(root, new StringBuilder());
			if (found == false) {
				result = "none";
			}
			sb.append(result).append("\n");

		}
		System.out.println(sb);
	}

	static void dfs(Node node, StringBuilder path) {
		if (found) {
			return;
		}
		if (node.end) {
			count++;
			if (count == k) {
				found = true;
				result = path.toString();
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
		boolean end;
		Node[] children = new Node[26];
	}
}