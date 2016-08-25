package org.dzhou.practice.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival
 * airports [from, to], reconstruct the itinerary in order. All of the tickets
 * belong to a man who departs from JFK. Thus, the itinerary must begin with
 * JFK.
 * 
 * Note: <br>
 * 1.If there are multiple valid itineraries, you should return the itinerary
 * that has the smallest lexical order when read as a single string. For
 * example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"].
 * 
 * 2.All airports are represented by three capital letters (IATA code).
 * 
 * 3.You may assume all tickets form at least one valid itinerary.
 * 
 * Example 1:
 * 
 * tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 
 * Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
 * 
 * Example 2:
 * 
 * tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 
 * Return ["JFK","ATL","JFK","SFO","ATL","SFO"]. Another possible reconstruction
 * is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 * 
 * @author zhoudong
 *
 */
public class ReconstructItinerary {

	public class Solution {

		public List<String> findItinerary(String[][] tickets) {
			Map<String, List<String>> graph = createGraph(tickets);
			sortGraph(graph);
			List<String> result = new ArrayList<>();
			result.add("JFK");
			dfs(result, tickets.length + 1, graph);
			return result;
		}

		private boolean dfs(List<String> result, int size, Map<String, List<String>> graph) {
			if (result.size() == size) {
				return true;
			}
			String from = result.get(result.size() - 1);
			if (!graph.containsKey(from) || graph.get(from).size() == 0) {
				return false;
			}
			List<String> to = graph.get(from);
			for (int i = 0; i < to.size(); i++) {
				String temp = to.get(i);
				result.add(temp);
				to.remove(i);
				if (dfs(result, size, graph)) {
					return true;
				}
				result.remove(result.size() - 1);
				to.add(i, temp);
			}
			return false;
		}

		private Map<String, List<String>> createGraph(String[][] tickets) {
			Map<String, List<String>> map = new HashMap<>();
			for (String[] ticket : tickets) {
				if (!map.containsKey(ticket[0])) {
					map.put(ticket[0], new ArrayList<>());
				}
				map.get(ticket[0]).add(ticket[1]);
			}
			return map;
		}

		private void sortGraph(Map<String, List<String>> map) {
			for (List<String> item : map.values()) {
				Collections.sort(item);
			}
		}

	}

}
