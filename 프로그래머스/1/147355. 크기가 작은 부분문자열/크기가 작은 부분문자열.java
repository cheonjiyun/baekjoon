class Solution {
    public int solution(String t, String p) {
		char[] tc = t.toCharArray();
		char[] pc = p.toCharArray();
		
		int tLength = t.length();
		int pLength = p.length();	
		
		Long pLong =  Long.parseLong(p);
		
		int result = 0;
		for (int i = 0; i <= tLength - pLength; i++) {
			String tTemp = t.substring(i, i+pLength);
			
			if(Long.parseLong(tTemp) <= pLong) {
				result += 1;
			}
			 
		}
		return result;
    }
}