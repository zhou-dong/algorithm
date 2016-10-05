package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 399. Evaluate Division
 * 
 * Difficulty: Medium
 * 
 * Equations are given in the format A / B = k, where A and B are variables
 * represented as strings, and k is a real number (floating point number). Given
 * some queries, return the answers. If the answer does not exist, return -1.0.
 * 
 * Example: Given a / b = 2.0, b / c = 3.0. queries are: a / c = ?, b / a = ?, a
 * / e = ?, a / a = ?, x / x = ? . return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * 
 * The input is: vector<pair<string, string>> equations, vector<double>& values,
 * vector<pair<string, string>> queries , where equations.size() ==
 * values.size(), and the values are positive. This represents the equations.
 * Return vector<double>.
 * 
 * According to the example above:
 * 
 * equations = [ ["a", "b"], ["b", "c"] ], values = [2.0, 3.0], queries = [
 * ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * 
 * The input is always valid. You may assume that evaluating the queries will
 * result in no division by zero and there is no contradiction.
 * 
 * @author zhoudong
 *
 */
public class EvaluateDivision {
	// 存储关系，及被除数开头的情况下，有哪些除数
	HashMap<String, List<String>> divisionRelations = new HashMap<String, List<String>>();
	HashMap<String, Double> equationsResult = new HashMap<String, Double>();

	/**
	 * 搜索那些那可以 要么 a/b 存在 要么有 （a/c）*(c/b)存在，二选一
	 */
	public double dfs(HashSet<String> visited, double val, String a, String b) {
		double result = -1;
		visited.add(a);
		if (divisionRelations.containsKey(a) == false) {
			visited.remove(a);
			return result;
		}
		List<String> list = divisionRelations.get(a);
		for (String tmp : list) {
			if (tmp.equals(b)) {
				result = equationsResult.get(a + "%" + tmp);
				break;
			} else if (visited.contains(tmp) == false) {
				double midResult = dfs(visited, val, tmp, b);
				if (midResult != -1) {
					result = equationsResult.get(a + "%" + tmp) * midResult;
					break;
				}

			}
		}
		visited.remove(a);
		return result;
	}

	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

		/**
		 * 保存好关系 a/b 以及对应的 b/a,注意a/b = 0的时候，没有其他
		 */
		for (int i = 0; i < equations.length; i++) {
			String a = equations[i][0];
			String b = equations[i][1];
			if (divisionRelations.containsKey(a) == false)
				divisionRelations.put(a, new ArrayList<String>());
			if (divisionRelations.containsKey(b) == false)
				divisionRelations.put(b, new ArrayList<String>());
			divisionRelations.get(a).add(b);
			equationsResult.put(a + "%" + b, values[i]);
			if (values[i] != 0) {
				divisionRelations.get(b).add(a);
				equationsResult.put(b + "%" + a, 1.0 / values[i]);
			}
		}
		// 运算
		double[] result = new double[queries.length];
		for (int i = 0; i < queries.length; i++) {
			result[i] = dfs(new HashSet<String>(), 0, queries[i][0], queries[i][1]);
		}
		return result;
	}

}
