class Solution {
    public String sortString(String s) {
        int[] arr = new int[26];

        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i)-'a';
            arr[index] = arr[index]+1;
        }

        // System.out.print(Arrays.toString(arr));

        StringBuilder sb = new StringBuilder();
        while(sb.length() < s.length()){
        
        for(int i=0; i<26; i++){
            if (arr[i]>0){
                char ch = (char)('a'+i);
                sb.append(ch);
                arr[i]--;
            }
        }

        for(int i=25; i>=0; i--){
            if (arr[i]>0){
                char ch = (char)('a'+i);
                sb.append(ch);
                arr[i]--;
            }
        }

    }

        return sb.toString();
    }
}