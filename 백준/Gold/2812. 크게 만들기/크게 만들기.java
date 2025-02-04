
import java.io.BufferedReader; 		// BufferedReader import
import java.io.BufferedWriter; 		// BufferedWriter import
import java.io.IOException;
import java.io.InputStreamReader;	// InputStreamReader import
import java.io.OutputStreamWriter;	// OutputStreamWriter import
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		
		// 입력
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] first = br.readLine().split(" ");
        int n = Integer.valueOf(first[0]);
        int k = Integer.valueOf(first[1]);
        
        String inputNumber = br.readLine();
        
//         -----------------------------------------------------------------------------
//         처음에는 for문으로 아래 처럼 처음에 구현했지만 (최적화했다고 생각했는데도) 시간초과가 떳습니다. 
//         도저히 방법이 떠오르지않아 검색 후 스택을 사용하면 된다는 힌트를 얻어 다시 풀었습니다. 
//        LinkedList<Integer> numbers = new LinkedList<>();
//        for(int i = 0; i < n; i++) {
//        	numbers.add(Integer.valueOf(inputNumber.substring(i, i+1)));
//        }
//        // BufferedWriter에 입력
//        
//    	int findStartIdx = 1;
//        for(int roop = 0; roop < k; roop++) {
//        	
//        	int currentSize = numbers.size();
//        	int willRemoveIdx = currentSize - 1;
//        	for(int idx = findStartIdx; idx < currentSize; idx++) { // 왼쪽에서 오른쪽으로 이동하면서
//        		int beforeIdx = idx - 1;
//        		int beforeNum = numbers.get(beforeIdx);        		
//        		int curNum = numbers.get(idx);
//        		if(beforeNum < curNum) { // 작으면 앞에 숫자 삭제
//        			willRemoveIdx = beforeIdx;
//        			findStartIdx -= 1; // 삭제했으면 비교대상이 달라져서 다시 바로 앞에를 검사해야함.
//        			break;
//        		}
//        	}
//        	numbers.remove(willRemoveIdx);
//        	findStartIdx += 1; // 오른쪽으로 이동
//        }
//         -----------------------------------------------------------------------------
        
        // 앞에서 부터 시작
        // (앞 요소 < 뒷 요소) 라면 앞에는 지워야 커지므로 삭제한다. 앞에부터 해야 더 큰 숫자를 앞에 세울 수 있음
        Stack<Integer> numbers = new Stack<>();        
        int countRemove = 0;
        for(int i = 0; i < n; i++) {
        	int currentNum  = Integer.valueOf(inputNumber.substring(i, i + 1));
        	
        	while(!numbers.isEmpty() && numbers.peek() < currentNum && countRemove < k) { // 비어있지 않고 && 맨 위 요소 < 넣으려는 요소 && 아직 k만큼 지우지 않았다면
        		// 지웠는데 또 작을 수도 있으므로 while
        		numbers.pop();
        		countRemove += 1;
        	}
        	numbers.add(currentNum);
        }        
        
        // k만큼 삭제를 못했을 경우
        while(countRemove < k) {
        	numbers.pop();
        	countRemove += 1;
        }
        
        // 앞에서부터 출력
        Iterator<Integer> resultNumbers = numbers.iterator();
        while(resultNumbers.hasNext()) {
        	 bw.write(String.valueOf(resultNumbers.next()));
        }

        br.close();
        // 최종 출력
        bw.flush();
        bw.close();
	}
}