class Solution {
    public String[] getFolderNames(String[] arr) {
        int n = arr.length;

        HashMap<String,Integer> hp = new HashMap<>();

        String ans[] = new String[n];

        for(int i=0; i<n; i++){
            if(hp.containsKey(arr[i])){
                int val = hp.get(arr[i]);
                StringBuilder s = new StringBuilder(arr[i]);
                s.append('(');
                s.append(val);
                s.append(')');

                while(hp.containsKey(s.toString())){
                    val++;
                    s = new StringBuilder(arr[i]);
                    s.append('(');
                    s.append(val);
                    s.append(')');
                }
                ans[i] = s.toString();
                hp.put(s.toString(),1);
                hp.put(arr[i],val+1);
            }else{
                ans[i] = arr[i];
                hp.put(arr[i],1);
            }
        }
        return ans;
    }
}