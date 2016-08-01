# 115. Distinct Subsequences

Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:  
S = "rabbbit", T = "rabbit"

Return 3.

Dynamic programming

| - | - | r | a | b | b | b | i | t |
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|
| - | 1 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
| r | 0 | 1 | 1 | 1 | 1 | 1 | 1 | 1 |
| a | 0 | 0 | 1 | 1 | 1 | 1 | 1 | 1 |
| b | 0 | 0 | 0 | 1 | 2 | 3 | 3 | 3 |
| b | 0 | 0 | 0 | 0 | 1 | 3 | 3 | 3 |
| i | 0 | 0 | 0 | 0 | 0 | 0 | 3 | 3 |
| t | 0 | 0 | 0 | 0 | 0 | 0 | 0 | 3 |

| - | - | a | a | b | b |
|:-:|:-:|:-:|:-:|:-:|:-:|
| - | 1 | 1 | 1 | 1 | 1 |
| a | 0 | 1 | 2 | 2 | 2 |
| b | 0 | 0 | 0 | 2 | 4 |

