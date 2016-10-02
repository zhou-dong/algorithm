package com.dzhou.interview.twitter.test;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.dzhou.interview.twitter.Anagram;

import junit.framework.Assert;

/**
 * Find the Anagram from a list of strings
 * 
 * input : {"tea", "ate", "eat", "apple", "java", "vaja", "cut", "utc"};
 * 
 * Output : {"tea", "ate", "eat","java", "vaja", "cut", "utc"}
 * 
 * @author zhoudong
 *
 */
public class AnagramTest {

	@Test
	public void test() {
		String[] input = { "tea", "ate", "eat", "apple", "java", "vaja", "cut", "utc" };
		Set<String> actual = new Anagram().findAnagrams(input);
		Assert.assertEquals(expected(), actual);
	}

	private Set<String> expected() {
		String[] output = { "tea", "ate", "eat", "java", "vaja", "cut", "utc" };
		Set<String> set = new HashSet<>();
		for (String str : output)
			set.add(str);
		return set;
	}

}
