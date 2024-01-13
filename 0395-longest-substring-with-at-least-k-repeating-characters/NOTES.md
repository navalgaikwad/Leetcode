* the count of the left letter by 1. If the count is equal to 0 we decrement
* the number of unique letters since all instances of this letter are gone, if
* it's equal to k it is now not k or more so we decrement charsKorMoreCount.
*/
while (uniqueChars > uniqueCharsTarget) {
char beginChar = s.charAt(begin);
​
if (map[beginChar] == k) {
charsKorMoreCount--;
}
map[beginChar]--;
​
if (map[beginChar] == 0) {
uniqueChars--;
}
begin++;
}
​
// if we found a string where the number of unique chars equals our target
// and all those chars are repeated at least K times then update max
if (uniqueChars == uniqueCharsTarget && uniqueChars == charsKorMoreCount)
d = Math.max(end - begin, d);
}
​
return d;
}