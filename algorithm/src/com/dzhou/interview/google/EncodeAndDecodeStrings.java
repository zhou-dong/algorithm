package com.dzhou.interview.google;

import java.util.ArrayList;
import java.util.List;

/**
 * 271. Encode and Decode Strings
 * 
 * Design an algorithm to encode a list of strings to a string. The encoded
 * string is then sent over the network and is decoded back to the original list
 * of strings.
 * 
 * So Machine 1 does:
 * 
 * string encoded_string = encode(strs); and Machine 2 does:
 * 
 * vector<string> strs2 = decode(encoded_string); strs2 in Machine 2 should be
 * the same as strs in Machine 1.
 * 
 * Implement the encode and decode methods.
 * 
 * Note:
 * 
 * 1.The string may contain any possible characters out of 256 valid ascii
 * characters. Your algorithm should be generalized enough to work on any
 * possible characters.
 * 
 * 2.Do not use class member/global/static variables to store states. Your
 * encode and decode algorithms should be stateless.
 * 
 * 3.Do not rely on any library method such as eval or serialize methods. You
 * should implement your own encode/decode algorithm.
 * 
 * @author zhoudong
 *
 */
public class EncodeAndDecodeStrings {

	public class Codec {

		// Encodes a list of strings to a single string.
		public String encode(List<String> strs) {
			StringBuilder sb = new StringBuilder();
			for (String str : strs)
				sb.append(str.length()).append("#").append(str);
			return sb.toString();
		}

		// Decodes a single string to a list of strings.
		public List<String> decode(String s) {
			List<String> result = new ArrayList<>();
			for (int index = 0; index < s.length();) {
				int sharp = s.indexOf('#', index);
				int length = Integer.parseInt(s.substring(index, sharp));
				result.add(s.substring(sharp + 1, sharp + 1 + length));
				index = sharp + 1 + length;
			}
			return result;
		}

	}

	// Your Codec object will be instantiated and called as such:
	// Codec codec = new Codec();
	// codec.decode(codec.encode(strs));

}
