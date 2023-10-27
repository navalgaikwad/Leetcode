start = j;
end = i;
}
}
}
}
return s.substring(start, end + 1);
}
boolean palindrome(int start, int end, String s, Boolean[][] palindromeMemo) {
if (start >= end) return true;
if (palindromeMemo[start][end] != null) {
return palindromeMemo[start][end];
}
if (s.charAt(start) == s.charAt(end)) {
boolean result = palindrome(start + 1, end - 1, s, palindromeMemo);
palindromeMemo[start][end] = result;
return result;
}
palindromeMemo[start][end] = false;
return false;
}
}
​