class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum=0,bobSum=0;
		for(int i:aliceSizes) aliceSum+=i;
        
		for(int i:bobSizes) bobSum+=i;
        
		int half=(bobSum-aliceSum)/2;
        
		Set<Integer> set=new HashSet<>();
        
		for(int i:bobSizes) set.add(i);
		
		for(int i:aliceSizes) {
			if(set.contains(i+half))
				return new int[] {i,i+half};
		}
		return null;
    }
}