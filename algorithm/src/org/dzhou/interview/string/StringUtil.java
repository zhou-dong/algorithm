package org.dzhou.interview.string;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	public static List<String> sentencesInParagraph(String paragraph) {
		return getTokens(paragraph, "[^.?!]+");
	}

	public static List<String> wordsInSentence(String sentence) {
		return getTokens(sentence, "[a-zA-Z]+");
	}

	public static List<String> getTokens(String string, String regex) {
		Matcher matcher = Pattern.compile(regex).matcher(string);
		List<String> result = new ArrayList<>();
		while (matcher.find())
			result.add(matcher.group());
		return result;
	}

	public static String replace(String word, char gone, char here) {
		char[] result = word.toCharArray();
		for (int i = 0; i < result.length; i++)
			if (result[i] == gone)
				result[i] = here;
		return new String(result);
	}

	public static int indexOf(String string, char character) {
		for (int i = 0; i < string.length(); i++)
			if (character == string.charAt(i))
				return i;
		return -1;
	}

	public static int indexOf(String sentence, String string) {
		char[] chars = string.toCharArray();
		for (int i = 0; i < sentence.length() - chars.length + 1; i++) {
			char[] tmp = new char[chars.length];
			for (int j = 0; j < chars.length; j++)
				tmp[j] = sentence.charAt(i + j);
			if (isEqual(chars, tmp))
				return i;
		}
		return -1;
	}

	public static boolean isEqual(char[] first, char[] second) {
		if (isEmpty(first) || isEmpty(second))
			return false;
		if (first.length != second.length)
			return false;
		for (int i = 0; i < first.length; i++)
			if (first[i] != second[i])
				return false;
		return true;
	}

	public static boolean isEmpty(char[] chars) {
		return (chars == null || chars.length == 0);
	}

}
