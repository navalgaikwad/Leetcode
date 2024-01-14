class Solution {
    public List<Integer> diffWaysToCompute(String exp) {
        List<Integer> answer  = new ArrayList<>();
        for(int i=0; i<exp.length(); i++) {//iterate over string
            char ch = exp.charAt(i);//take one by one charater
            if(ch == '-' || ch == '+' || ch == '*') {//check for -,+*
                List<Integer> left =diffWaysToCompute(exp.substring(0, i));//0 to i
                List<Integer> right =diffWaysToCompute(exp.substring(i + 1));//i+1
                for(int m : left) {//iterate over list left
                    for(int n : right) {{//iterate over list right
                        if(ch == '-') {//for minus
                            answer.add(m-n);
                        }else if(ch == '+') {
                            answer.add(m+n);
                        }else {
                            answer.add(m*n);
                        }
                    }
                }
            }
        }
    }
        if(answer.size() == 0) {//
            answer.add(Integer.valueOf(exp));
        }
        return answer;
    }
}