# 139. Word Break 

Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given  
s = "leetcode",  
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".

## Analyze

Example:  
input: thisisanexamplethankyou  
set: {this, is, an, example, thank, you}  
return true

### Dynamic Programming

possible[i] =  

- true	if	S[0,i]在dictionary里面
- true	if	possible[j] == true 并且 S[j,i]在dictionary里面， 0<j<i
- false	if	no such j exist.

如果用Java开发的话，注意：

- index是从0开始，
- substring(0, i+1)截取的是string[0,i]的字符串

#### Time complexity： O(N^2)

第1个character，需要检查运行1次，第N个character需要检查运行N次，

= ((1+N)*N)/2 = (N + N^2)/2 = O(N^2)
             
#### space complexity: O(N)

- Solution

```java
public class Solution {
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
			return false;
		boolean[] dp = new boolean[s.length() + 1];
		for (int i = 0; i < s.length(); i++) {
			// s.substring(0, i+1) 在dictionary里面
			if (wordDict.contains(s.substring(0, i + 1))) {
				dp[i + 1] = true;
				continue;
			}
			for (int j = 1; j <= i; j++) {
				// dp[j] == true 并且 s.substring(j, i+1)在dictionary里面
				if (dp[j] && wordDict.contains(s.substring(j, i + 1))) {
					dp[i + 1] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}
}
```

## Conclusion

coding：第2次做这道题，虽然还记得基本的原理，可是没能一步写出bug free的代码来，主要是在取sub string的时候，不够细心。

解题：遇到每个题，都不能着急动手，先举几个简答的例子，然后根据思路一步一步慢慢来。


reference: http://fisherlei.blogspot.com/2013/11/leetcode-word-break-solution.html