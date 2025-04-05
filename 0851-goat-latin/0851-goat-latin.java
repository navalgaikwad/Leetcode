class Solution {
    public String toGoatLatin(String sentence) {
        String vowels = "aeiouAEIOU";
        StringBuilder sb = new StringBuilder();
        int i = 1;
        String[] arr = sentence.split(" ");
        for (String a : arr) {
            char c = a.charAt(0);
            if (vowels.indexOf(c) != -1) {
                sb.append(a);
            } else {
                sb.append(a.substring(1));
                sb.append(c);
            }

            sb.append("ma");
            sb.append("a".repeat(i++));//vvimp string la repeat
            sb.append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);

    }
}