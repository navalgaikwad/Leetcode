class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
          if(s1.length()!=s2.length())
           return false;
        if(s1.equals(s2))
            return true;
        else{//one swap one char from 1 and secod character from another so 2
             List<Integer> list = new ArrayList<>();
            for (int i = 0;i<s1.length();i++)
                if (s1.charAt(i) != s2.charAt(i)) list.add(i);
            return list.size() == 2 && s1.charAt(list.get(0)) == s2.charAt(list.get(1))
                && s2.charAt(list.get(0)) == s1.charAt(list.get(1));

        }
    }
}