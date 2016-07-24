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

#### Time complexity： 

             
#### space complexity: 


## Code

recursive solution

```java
public class Solution {
	public boolean isMatch(String s, String p) {
		// recursive return condition
		if (p.length() == 0)
			return s.length() == 0;
		if (p.length() == 1)
			return s.length() == 1 && isMatch(s, p, 0);
		// main part
		if (p.charAt(1) != '*') { // normal compare
			return s.length() > 0 && isMatch(s, p, 0) && isMatch(s.substring(1), p.substring(1));
		} else {
			if (isMatch(s, p.substring(2)))
				return true;
			return s.length() > 0 && isMatch(s, p, 0) && isMatch(s.substring(1), p);
		}
	}
	private boolean isMatch(String s, String p, int index) {
		return p.charAt(index) == '.' || p.charAt(index) == s.charAt(index);
	}
}
```

## Conclusion


reference: 

http://articles.leetcode.com/regular-expression-matching

http://harrifeng.github.io/algo/leetcode/regular-expression-matching.html
