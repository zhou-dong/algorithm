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

看到这种一直循环的题，本能的应该想到优化的话，可能可以用dynamic programming。


#### Time complexity： O(N^2)

             
#### space complexity: O(N)


## Code

```java

public class Solution{
	public boolean isMatch(String s, String p) {
		if(p.length()==0){
			return s.length() == 0 ;
		}
	
	}
}

```
## Conclusion


reference: http://articles.leetcode.com/regular-expression-matching