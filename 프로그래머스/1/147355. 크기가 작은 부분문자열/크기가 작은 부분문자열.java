class Solution {
    public int solution(String t, String p) {
		char[] tc = t.toCharArray();
		char[] pc = p.toCharArray();
		
		int tLength = t.length();
		int pLength = p.length();	
		
		int result = 0;
		for (int i = 0; i <= tLength - pLength; i++) {
			char[] tTemp = new char[pLength];
			char[] pTemp = new char[pLength];
			
			for (int j = 0; j < pLength; j++) {
				tTemp[j] = tc[i+j];
				pTemp[j] = pc[j];
			}
			
			if(String.valueOf(tTemp).compareTo(String.valueOf(pTemp)) <= 0) {
				result += 1;
			}
			 
		}
		return result;
    }
}