class Solution {
    public List<Integer> diffWaysToCompute(String e) {
        List<Integer> result = new ArrayList<>();
        int len = e.length();
        for(int i =0 ; i<len; i++) {
            char c = e.charAt(i);
            if(c == '*' || c == '-' || c == '+') {
                List<Integer> left = diffWaysToCompute(e.substring(0, i));
                List<Integer> right = diffWaysToCompute(e.substring(i + 1));
                for(Integer l : left) {
                    for(Integer r : right) {
                        if(c == '*') {
                           result.add(l*r); 
                        }else if(c == '+') {
                           result.add(l+r);  
                        }else if(c == '-') {
                           result.add(l-r); 
                        }
                    }
                }
            }
        }
        if(result.size() == 0) {//
            result.add(Integer.valueOf(e));
        }
        return result;
    }
}

// i will go from 0 to i when there is +, *, -
// i, to i + 1
