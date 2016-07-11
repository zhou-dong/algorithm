# Example 8

Suppose we had an algorithm that took in an array of strings, sorted each string, and then sorted the full array. What would the runtime be?

- Let s be the length of the longest string.
- Let a be the length of array.

- sort one string: s*log(s)
- sort a string: a*s*log(s)

- compare to string: s
- sort array without compare each character: a*log(a)

total: a*s*log(s) + s*a*log(a) = a*s*(log(s)+log(a))

reference: Cracking the Coding Interview