package org.dzhou.interview.treeandgraph.editdistance;

import java.util.List;

public interface SpellingSuggest {

	public List<String> suggestions(String word, int numSuggestions);
	
}
