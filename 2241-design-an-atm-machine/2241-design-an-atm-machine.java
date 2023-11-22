class ATM {
    long[] denoms;
    long[] notes = new long[5];
    public ATM() {
      denoms = new long[]{ 20,50,100,200,500 };        // all denomination  
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < banknotesCount.length; i++){
			notes[i] += banknotesCount[i]; // add new deposit money to existing
		}
    }
    
    public int[] withdraw(int amount) {
        int[] result = new int[5];
        for(int i=4; i>=0; i--){ // start from end
            if(amount>= denoms[i]){
                // find the quantity required
                // how will you find it 
                // amount / and total denomination
                int count = (int) (amount / denoms[i]);
                int quantity =(int) Math.min(notes[i], count);
                amount -= denoms[i] * quantity;
                result[i] = quantity;
            }
           
        }
       // System.out.print(amount); if amount is not zero return -1;
        if(amount != 0){ return new int[]{-1}; }
        //update the quantity
        for(int i = 0; i < 5; i++){  notes[i] -= result[i];  }   
        
        return result;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */