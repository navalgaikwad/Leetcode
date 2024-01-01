class Solution {
    public boolean isRobotBounded(String instructions) {
        return helper(0, 0, instructions);
    }
    
    
    boolean helper(int x, int y, String ins) {
        char prev = '0';
        int preDir = 0;
        int ans = 0;
        for(char c : ins.toCharArray()) {
            if(c == 'G') {
                if(preDir == 0) {
                    y+=1;
                } else if(preDir == 1) { // dir = 1;// right (east)
                    x+=1;
                } else if(preDir == 2) { // dir = -1;//down south
                    y-=1;
                } else if(preDir == 3) { //left (west)
                    x--;
                }
            }
            else if(c== 'R') {
                if(preDir == 3) {
                    preDir = 0;//change dir right
                }else {
                   preDir = preDir + 1; 
                }
                
            } else if(c == 'L') {
                if(preDir == 0) {
                   preDir = 3; //change dir left
                }else {
                   preDir = preDir - 1; 
                }
            }
            //prev = c;
        }
        return x == 0 && y==0 ||  preDir !=0;
    }
}