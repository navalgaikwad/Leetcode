class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, (a,b)->{
            int indexA = a.indexOf(" ") + 1;
            int indexB = b.indexOf(" ") + 1;
            
            boolean aIsLetter = Character.isLetter(a.charAt(indexA));//check for letter
            boolean bIsLetter = Character.isLetter(b.charAt(indexB));//check for letter
            if(aIsLetter && bIsLetter) {
                 int cmp = a.substring(indexA).compareTo(b.substring(indexB));//if equal return 0
                if(cmp != 0) return cmp;
                return a.compareTo(b);
            }else if(aIsLetter && !bIsLetter) {
                return -1;
            }else if(!aIsLetter && bIsLetter) {
                return 1;
            }else {
                return 0;
            }
        });
        return logs;
    }
}

      