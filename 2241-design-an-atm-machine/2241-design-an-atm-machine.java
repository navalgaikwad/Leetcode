class ATM {
    private final long[] bills;
    private final long[] atm;

    public ATM() {
        this.atm = new long[5];
        this.bills = new long[] { 20, 50, 100, 200, 500 };
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < banknotesCount.length; ++i)
            this.atm[i] += banknotesCount[i];
    }
    
    public int[] withdraw(int amount) {
        final int[] result = new int[5];

        for(int i = 4; i >= 0 && amount != 0; --i) {
            result[i] = (int) Math.min(amount / this.bills[i], atm[i]);
            amount -= result[i] * this.bills[i];
        }

        if(amount != 0)
            return new int[] { -1 };

        for(int i = 0; i < this.bills.length; ++i)
            this.atm[i] -= result[i];

        return result;
    }
}


/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */