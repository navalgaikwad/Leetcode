// Solution  from @uwi
class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        // idea: sort rectangles and points in descending order by x value and type
        //       sweep line on y
        
        int n = rectangles.length;
        int m = points.length;
        int[][] elements = new int[n + m][];
        
        // init.
        for(int i = 0; i < n; i++){
            elements[i] = rectangles[i];
        }
        
        for(int i = 0; i < m; i++){
            elements[n + i] = new int[]{points[i][0], points[i][1], i};
        }
        
        // sort
        Arrays.sort(elements, (a, b) -> (a[0] != b[0] ? b[0] - a[0] : a.length - b.length));
        
        // sweep line : count values on y direction [1, 100]
        int[] ct = new int[101];
        int[] ret = new int[m];
        
        for(int[] element : elements){
            // check current is rectangle or point
            // case 1: if rectangle, range count 0 to yi ++
            if(element.length == 2){
                for(int y = 0; y <= element[1]; y++){
                    ct[y]++;
                }
            // case 2: if point, checkout by current count 
            }else{
                ret[element[2]] = ct[element[1]];
            }
        }
        
        return ret;
    }
}