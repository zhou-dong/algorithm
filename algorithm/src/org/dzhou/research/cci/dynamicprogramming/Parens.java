package org.dzhou.research.cci.dynamicprogramming;

/**
 * Practice of "cracking the code interview"
 * 
 * Implement an algorithm to print all valid combinations of n pairs of
 * parentheses .
 *
 * Example<br>
 * Input:3<br>
 * output: ()()(), ()(()), (()()), (())(), ((()))
 * 
 * @author DONG ZHOU
 *
 *         {@code class Solution(){ }} Solution A: <br>
 * 
 *         1. create one () <br>
 *         2. 在()的各个位置，插入() <br>
 * 
 *         Example: () <br>
 *         ()(), (()) [(()),()()]<br>
 * 
 *         Solution B:<br>
 * 
 *         从无到有以依次构造 <br>
 */
public class Parens {

}
