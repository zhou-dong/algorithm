package org.dzhou.interview.treeandgraph.trie;

import java.util.List;

/**
 * @author Christine
 *
 *         copy for study
 * 
 */
public interface AutoComplete {

	public List<String> predictCompletions(String prefix, int numCompletions);

}
