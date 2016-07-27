# 10. Regular Expression Matching

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.  
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:  
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false    
isMatch("aa","aa") → true    
isMatch("aaa","aa") → false    
isMatch("aa", "a*") → true    
isMatch("aa", ".*") → true  
isMatch("ab", ".*") → true  
isMatch("aab", "c*a*b") → true  

## Analyze

关键是'*'的处理。

We need some kind of backtracking mechanism such that when a matching fails, we return to the last successful matching state and attempt to match more characters in s with ‘*’. This approach leads naturally to recursion.

The recursion mainly breaks down elegantly to the following two cases:

- If the next character of p is NOT ‘*’, then it must match the current character of s. Continue pattern matching with the next character of both s and p.
- If the next character of p is ‘*’, then we do a brute force exhaustive matching of 0, 1, or more repeats of current character of p… Until we could not match any more characters.

"匹配"这个问题,非常容易转换成"匹配了一部分",整个匹配不匹配,要看"剩下的匹配"情况. 这就很好的把一个大的问题转换成了规模较小的问题:递归


## Solution:

- 当前字符的后一位!=‘*’的时候，正常比较。
- 当前字符后一位==‘*’的时候：
	+ 当做本字符不存在（appear 0 time），直接比较后面的
	+ 本字符纯在，约掉被比较字符串一个字符，递归比较

Java code: recursive solution

```java
public boolean isMatch(String s, String p) {
	if (p.length() == 0)
		return s.length() == 0;
	if (p.length() == 1)
		return s.length() == 1 && isMatch(s, p, 0);

	if (p.charAt(1) != '*')
		return isMatch(s, p, 0) && isMatch(s.substring(1), p.substring(1));

	if (isMatch(s, p.substring(2))) // appear 0 time
		return true;

	return isMatch(s, p, 0) && isMatch(s.substring(1), p);
}

private boolean isMatch(String s, String p, int index) {
	if (validIndex(s, index) && validIndex(p, index))
		return p.charAt(index) == '.' || p.charAt(index) == s.charAt(index);
	return false;
}

private boolean validIndex(String str, int index) {
	return index >= 0 && index < str.length();
}
	
```

Dynamic Programming

|   |   | x | a | * | b | . | c |
|:-:|---|:-:|:-:|:-:|:-:|---|---|
|   | T | F | F | F | F | F | F |
| x | F | T | F | T | F | F | F |
| a | F | F | T | T | F | F | F |
| a | F | F | F | T | F | F | F |
| b | F | F | F | F | T | F | F |
| y | F | F | F | F | F | T | F |
| c | F | F | F | F | F | F | T |


reference: 

http://articles.leetcode.com/regular-expression-matching

http://harrifeng.github.io/algo/leetcode/regular-expression-matching.html

https://www.youtube.com/watch?v=l3hda49XcDE