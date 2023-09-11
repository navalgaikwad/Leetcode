class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] res = {-100000, 100000};
        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->a[0]-b[0]);
        int k=nums.size();
        int max=Integer.MIN_VALUE;
        for(int i=0; i<k; i++){
            int value = nums.get(i).get(0);
            max =Math.max(value, max);
            q.add(new int[]{value, 0, i});
        }
        //create pq sort in min
        //find max
        //check range if it has min from existing then update
        //if it reaches end break it
        while(true){
          int[] current = q.remove();  
          if(res[1]-res[0] > max-current[0]){
              res[0]=current[0];
              res[1]= max;
          }
            current[1]++;
            //edge condition
           List<Integer>cl= nums.get(current[2]);
            if(current[1] == cl.size()){
               break; 
            }else{
                max =Math.max(cl.get(current[1]), max);
                current[0]=cl.get(current[1]);
                q.add(current);
            }
        }
        return res;
    }
}