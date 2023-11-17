class OrderedStream {
    String stream[];
    int ptr =0;
    public OrderedStream(int n) {
        stream = new String[n];
    }
    
    public List<String> insert(int idKey, String value) {
        stream[idKey - 1] = value;
        List<String> chunk = new ArrayList<>();
        while(ptr < stream.length  && stream[ptr] != null){ //
            chunk.add(stream[ptr++]);
        }
        return chunk;
    }
}
/**
1. iterate till next value is not null
2. if it is null return the value. 
**/

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */

//(1, "aaaa")