class Solution {
    public int distMoney(int money, int children) {
        if(money<children)return -1;
        money-=children;
        int count=money/7;
        int mod=money%7;
        if(mod==3&&count==children-1)return count-1;
        if((count==children&&mod!=0))return count-1;
        if(count>children)return children-1;
        return count;
    }
}