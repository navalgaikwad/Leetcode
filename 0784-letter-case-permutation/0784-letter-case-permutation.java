class Solution {
    public List<String> letterCasePermutation(String s) {
    String ip = s;
    String op = "";
    List<String> output = new ArrayList<>();
    return solve(ip, op, output);
    }
    
    public List<String> solve(String ip, String op, List<String> result) {
     if(ip.isEmpty()){
       result.add(op);
       return result;
     }
        String op1 = op, op2=op;
     if(!Character.isDigit(ip.charAt(0))){
       
         op1 =op1+ip.toLowerCase().charAt(0);//upper 
         op2 =op2+ip.toUpperCase().charAt(0);//lower
          ip=ip.substring(1);//next value
         solve(ip, op1, result);
         solve(ip, op2, result);
     }else{//fot digit
         op=op+ip.charAt(0);//saving current value
         ip=ip.substring(1);
         solve(ip, op, result); 
     }
    return result;
  }
}

